package com.prosmv.service.permission.helper;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.prosmv.constants.message.ServiceMessageCode;
import com.prosmv.domain.Company;
import com.prosmv.domain.Role;
import com.prosmv.dto.AutoCompleteRoleDTO;
import com.prosmv.dto.RoleDTO;
import com.prosmv.dto.SubModulePermissionDTO;
import com.prosmv.dto.response.ResponseDTO;
import com.prosmv.exception.PermissionException;
import com.prosmv.form.PermissionForm;
import com.prosmv.service.permission.PermissionService;
import com.prosmv.util.ResponseHandler;

/**
 * This helper class is used to access {@link PermissionService} accordingly.
 * 
 * @author piyush
 *
 */
@Service
public class PermissionServiceHelper {

	private static final Logger LOGGER = LoggerFactory.getLogger(PermissionServiceHelper.class);

	@Autowired
	private PermissionService permissionService;

	/**
	 * This helper method will access {@link PermissionService} to save role based
	 * permission.
	 * 
	 * @param permissionForm {@link PermissionForm}
	 * @return {@link ResponseDTO}
	 */
	public ResponseDTO saveRolePermission(PermissionForm permissionForm) {
		try {
			permissionService.saveRolePermission(permissionForm);
			return ResponseHandler.generateServiceResponse(null, ServiceMessageCode.ROLE_PERMISSION_SAVED_SUCCESSFULLY,
					null, true, HttpStatus.OK);
		} catch (Exception e) {
			throw new PermissionException(ServiceMessageCode.UNABLE_TO_SAVE_ROLE_PERMISSION);
		}
	}

	/**
	 * This helper method will access {@link PermissionService} to update role based
	 * permission.
	 * 
	 * @param permissionId   id of permission
	 * @param permissionForm {@link PermissionForm}
	 * @return {@link ResponseDTO}
	 */
	public ResponseDTO updatePermission(Long permissionId, PermissionForm permissionForm) {
		try {
			permissionService.updateRolePermission(permissionForm);
			return ResponseHandler.generateServiceResponse(null,
					ServiceMessageCode.ROLE_PERMISSION_UPDATED_SUCCESSFULLY, null, true, HttpStatus.OK);
		} catch (Exception e) {
			throw new PermissionException(ServiceMessageCode.UNABLE_TO_UPDATE_ROLE_PERMISSION);
		}
	}

	/**
	 * This helper method is used to access {@link PermissionService} to delete role
	 * based permission.
	 * 
	 * @param permissionForm {@link PermissionForm}
	 * @return {@link ResponseDTO}
	 */
	public ResponseDTO deleteRolePermissions(PermissionForm permissionForm) {
		try {
			permissionService.deleteRolePermission(permissionForm);
			return ResponseHandler.generateServiceResponse(null,
					ServiceMessageCode.ROLE_BASED_PERMISSION_DELTED_SUCCESSFULLY, null, true, HttpStatus.OK);
		} catch (Exception e) {
			throw new PermissionException(ServiceMessageCode.UNABLE_TO_DELETE_ROLE_BASED_PERMISSION);
		}
	}

	/**
	 * This helper method is used to access {@link PermissionService} to
	 * gellRolePermissions by role id.
	 * 
	 * @param roleId id of {@link Role}
	 * @return {@link ResponseDTO}
	 */
	public ResponseDTO getRolePermission(Long roleId) {
		List<SubModulePermissionDTO> subModulePermissionDTOs = permissionService.getRolePermissions(roleId);
		if (subModulePermissionDTOs.isEmpty()) {
			return ResponseHandler.generateServiceResponse(null,
					ServiceMessageCode.NO_PERMISSIONS_AVAILABLE_TO_THIS_ROLE, null, true, HttpStatus.OK);
		}
		return ResponseHandler.generateServiceResponse(subModulePermissionDTOs,
				ServiceMessageCode.ROLE_BASED_PERMISSION_FETCHED_SUCCESSFULLY, null, true, HttpStatus.OK);
	}

	/**
	 * This helper method is used to access {@link PermissionService} to get auto
	 * complete {@link Role}.
	 * 
	 * @param roleName name of {@link Role}
	 * @return {@link ResponseDTO}
	 */
	public ResponseDTO getAutoCompleteRole(String roleName) {
		List<AutoCompleteRoleDTO> autoCompleteRoleDTOs = permissionService.getAutoCompleteRole(roleName);
		if (autoCompleteRoleDTOs.isEmpty()) {
			return ResponseHandler.generateServiceResponse(null, ServiceMessageCode.NO_AUTO_COMPLETE_ROLES_AVAILABLE,
					null, true, HttpStatus.OK);
		}
		return ResponseHandler.generateServiceResponse(autoCompleteRoleDTOs,
				ServiceMessageCode.AUTO_COMPLETE_ROLE_FOUND_SUCCESSFULLY, null, true, HttpStatus.OK);
	}

	/**
	 * This helper method is used to access {@link PermissionService} to get auto
	 * complete {@link Role} by {@link Company#getId()}.
	 * 
	 * @param companyId id of {@link Company} for which you want the {@link Role}.
	 * @param roleName  name of {@link Role}
	 * @return {@link ResponseDTO}
	 */
	public ResponseDTO getAutoCompleteRoleByCompany(Long companyId, String roleName) {
		List<AutoCompleteRoleDTO> autoCompleteRoleDTOs = permissionService.getAutoCompleteRoleByCompany(companyId,
				roleName);
		if (autoCompleteRoleDTOs.isEmpty()) {
			return ResponseHandler.generateServiceResponse(null, ServiceMessageCode.NO_AUTO_COMPLETE_ROLES_AVAILABLE,
					null, true, HttpStatus.OK);
		}
		return ResponseHandler.generateServiceResponse(autoCompleteRoleDTOs,
				ServiceMessageCode.AUTO_COMPLETE_ROLE_FOUND_SUCCESSFULLY, null, true, HttpStatus.OK);
	}

}
