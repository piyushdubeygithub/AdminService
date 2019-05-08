package com.prosmv.service.permission;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.prosmv.domain.Company;
import com.prosmv.domain.Module;
import com.prosmv.domain.Role;
import com.prosmv.domain.SubModule;
import com.prosmv.domain.SubModulePermission;
import com.prosmv.dto.AutoCompleteRoleDTO;
import com.prosmv.dto.RoleDTO;
import com.prosmv.dto.SubModuleDTO;
import com.prosmv.dto.SubModulePermissionDTO;
import com.prosmv.form.PermissionForm;
import com.prosmv.form.SubModulePermissionForm;
import com.prosmv.repositories.CompanyRepository;
import com.prosmv.repositories.ModuleRepository;
import com.prosmv.repositories.RoleRepository;
import com.prosmv.repositories.SubModulePermissionRepository;
import com.prosmv.repositories.SubModuleRepository;
import com.prosmv.util.Constant;

/**
 * This service class is used for accessing all the service related to
 * Permission.
 * 
 * @author piyush
 *
 */
@Service
public class PermissionService {

	private static final Logger LOGGER = LoggerFactory.getLogger(PermissionService.class);

	@Autowired
	private CompanyRepository companyRepository;

	@Autowired
	private RoleRepository roleRepository;

	@Autowired
	private SubModuleRepository subModuleRepository;

	@Autowired
	private SubModulePermissionRepository subModulePermissionRepository;

	@Autowired
	ModuleRepository moduleRepository;

	public Map<String, Object> saveRole(PermissionForm permissionForm) {
		Map<String, Object> result = new HashMap<>();
		Role role = getRole(permissionForm);
		if (!isRoleExists(role)) {
			role = roleRepository.save(role);
			if (role != null) {
				result.put(Constant.MESSAGE, "error occured while saving role");
				result.put(Constant.RESPONSE_MESSAGE, Constant.ERROR);
				return result;
			}
		} else {
			result.put(Constant.MESSAGE, "role already exists");
			result.put(Constant.RESPONSE_MESSAGE, Constant.ERROR);
			return result;
		}
		result.put(Constant.RESPONSE_MESSAGE, Constant.SUCCESS);
		return result;
	}

	private boolean isRoleExists(Role role) {
		boolean roleExists = false;
		role = roleRepository.findByRoleNameAndCompany(role.getRoleName(), role.getCompany());
		if (role != null) {
			roleExists = true;
		}
		return roleExists;
	}

	private Role getRole(PermissionForm permissionForm) {
		Role role = new Role();
		Company company = companyRepository.findById(permissionForm.getCompanyId());
		role.setCompany(company);
		role.setRoleName(permissionForm.getRoleName());
		return role;
	}

	public String saveRolePermission(PermissionForm permissionForm) {
		Map<String, Object> result = saveRole(permissionForm);
		if (Constant.SUCCESS.equals(result.get(Constant.RESPONSE_MESSAGE))) {
			result = saveSubModulePermission(permissionForm);
		}
		return (String) result.get(Constant.MESSAGE);
	}

	private Map<String, Object> saveSubModulePermission(PermissionForm permissionForm) {
		Map<String, Object> result = new HashMap<>();
		List<SubModulePermissionForm> subModulePermissionForms = permissionForm.getSubModulePermissionForms();
		for (SubModulePermissionForm form : subModulePermissionForms) {
			SubModulePermission subModulePermission = getSubModulePermission(form, permissionForm.getCompanyId(),
					permissionForm.getRoleName());
			if (!isExistsSubModulePermission(subModulePermission)) {
				subModulePermission = subModulePermissionRepository.save(subModulePermission);
			}
		}

		result.put(Constant.RESPONSE_MESSAGE, Constant.SUCCESS);
		return result;
	}

	private boolean isExistsSubModulePermission(SubModulePermission subModulePermission) {
		boolean subModulePermissionExists = false;
		SubModulePermission oldSubModulePermission = subModulePermissionRepository
				.findByRoleAndSubModule(subModulePermission.getRole(), subModulePermission.getSubModule());
		if (oldSubModulePermission != null) {
			subModulePermissionExists = true;
		}
		return subModulePermissionExists;
	}

	private SubModulePermission getSubModulePermission(SubModulePermissionForm permissionForm, Long compId,
			String roleName) {
		SubModulePermission subModulePermission = new SubModulePermission();
		subModulePermission.setCanAccess(permissionForm.isCanAccess());
		subModulePermission.setCanApprove(permissionForm.isCanApprove());
		subModulePermission.setCanDelete(subModulePermission.isCanDelete());
		subModulePermission.setCanPrint(permissionForm.isCanPrint());
		subModulePermission.setCanSendForApproval(permissionForm.isCanSendForApproval());
		subModulePermission.setCanUpdate(permissionForm.isCanUpdate());
		subModulePermission.setCanView(permissionForm.isCanView());
		Company company = companyRepository.findById(compId);
		Role role = roleRepository.findByRoleNameAndCompany(roleName, company);
		subModulePermission.setRole(role);
		SubModule subModule = subModuleRepository.findBySubModuleName(permissionForm.getSubModuleName());
		subModulePermission.setSubModule(subModule);
		return subModulePermission;
	}

	public String updateRolePermission(PermissionForm permissionForm) {
		String response = null;
		List<SubModulePermissionForm> subModulePermissionForms = permissionForm.getSubModulePermissionForms();
		for (SubModulePermissionForm form : subModulePermissionForms) {
			SubModulePermission subModulePermission = getSubModulePermission(form, permissionForm.getCompanyId(),
					permissionForm.getRoleName());
			if (isExistsSubModulePermission(subModulePermission)) {
				subModulePermission = subModulePermissionRepository.save(subModulePermission);
			}
		}
		response = "updated";
		return response;
	}

	public String deleteRolePermission(PermissionForm permissionForm) {
		String response = null;
		List<SubModulePermissionForm> subModulePermissionForms = permissionForm.getSubModulePermissionForms();
		for (SubModulePermissionForm form : subModulePermissionForms) {
			SubModulePermission subModulePermission = getSubModulePermission(form, permissionForm.getCompanyId(),
					permissionForm.getRoleName());
			if (isExistsSubModulePermission(subModulePermission)) {
				Role role = subModulePermission.getRole();
				subModulePermissionRepository.delete(subModulePermission);
				roleRepository.delete(role);
			}
		}
		response = "role deleted successfully";
		return response;
	}

	private void setSubModulePermission(Company company, Role role, SubModule subModule) {
		SubModulePermission subModulePermission = new SubModulePermission();
		subModulePermission.setCanAccess(true);
		subModulePermission.setCanApprove(true);
		subModulePermission.setCanDelete(true);
		subModulePermission.setCanPrint(true);
		subModulePermission.setCanSendForApproval(true);
		subModulePermission.setCanUpdate(true);
		subModulePermission.setCanView(true);
		subModulePermission.setRole(role);
		subModulePermission.setSubModule(subModule);
		subModulePermissionRepository.save(subModulePermission);
	}

	public List<SubModulePermissionDTO> getRolePermissions(Long roleId) {
		Role role = roleRepository.findById(roleId);
		List<SubModulePermission> subModulePermissions = subModulePermissionRepository.findByRole(role);
		List<SubModulePermissionDTO> subModulePermissionList = new ArrayList<>();
		for (SubModulePermission subModulePermission : subModulePermissions) {
			subModulePermissionList.add(new SubModulePermissionDTO(subModulePermission));
		}
		return subModulePermissionList;
	}

	public List<SubModuleDTO> getSubModules(Long moduleId) {
		Module module = moduleRepository.findById(moduleId);
		List<SubModule> subModules = subModuleRepository.findByModule(module);
		List<SubModuleDTO> subModuleDTOs = new ArrayList<>();
		for (SubModule subModule : subModules) {
			subModuleDTOs.add(new SubModuleDTO(subModule));
		}
		return subModuleDTOs;
	}

	public List<RoleDTO> getRoles(Long companyId) {
		Company company = companyRepository.findById(companyId);
		List<Role> roles = roleRepository.findByCompany(company);
		List<RoleDTO> roleList = new ArrayList<>();
		for (Role role : roles) {
			roleList.add(new RoleDTO(role));
		}
		return roleList;
	}

	/**
	 * This service will be used to get the list of {@link AutoCompleteRoleDTO} by
	 * role name.
	 * 
	 * @param roleName name of {@link Role}
	 * @return {@link List} of {@link AutoCompleteRoleDTO}
	 */
	public List<AutoCompleteRoleDTO> getAutoCompleteRole(String roleName) {
		return roleRepository.findByRoleNameIgnoreCaseContaining(roleName);
	}

	/**
	 * This service will be used to get list of {@link AutoCompleteRoleDTO} by role
	 * name and company id.
	 * 
	 * @param companyId id of {@link Company}
	 * @param roleName  name of {@link Role}
	 * @return {@link List} of {@link AutoCompleteRoleDTO}
	 */
	public List<AutoCompleteRoleDTO> getAutoCompleteRoleByCompany(Long companyId, String roleName) {
		return roleRepository.findByRoleNameIgnoreCaseContainingAndCompanyId(roleName, companyId);
	}

}
