package com.prosmv.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.prosmv.annotations.sequence.ValidateSequence;
import com.prosmv.constants.url.ApiUrl;
import com.prosmv.domain.Role;
import com.prosmv.dto.RoleDTO;
import com.prosmv.dto.SubModuleDTO;
import com.prosmv.dto.response.ResponseDTO;
import com.prosmv.form.PermissionForm;
import com.prosmv.form.modelattributre.CompanyIdModel;
import com.prosmv.form.modelattributre.PermissionIdModel;
import com.prosmv.service.permission.PermissionService;
import com.prosmv.service.permission.helper.PermissionServiceHelper;
import com.prosmv.util.Constant;
import com.prosmv.util.ResponseHandler;

/**
 * This controller class will contains all the api end points used for
 * operations such as save,update,get,delete and so on related to {@link Role}.
 * 
 * @author piyush
 *
 */
@RestController
public class PermissionController {

	private static final Logger LOGGER = LoggerFactory.getLogger(PermissionController.class);

	@Autowired
	private PermissionServiceHelper permissionServiceHelper;

	@Autowired
	private PermissionService permissionService;

	/**
	 * This api end point is used to save role based permissions.
	 * 
	 * @param permissionForm {@link PermissionForm}
	 * @param bindingResult  {@link BindingResult}
	 * @return {@link ResponseEntity} of {@link ResponseDTO}
	 */
	@PostMapping(value = ApiUrl.SAVE_ROLE_PERMISSIONS)

	public ResponseEntity<ResponseDTO> saveRolePermission(
			@Validated(value = ValidateSequence.class) @RequestBody PermissionForm permissionForm,
			BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			LOGGER.error(
					"Validation failed while saving role permissions for field {} with rejected value {} with message {} ",
					bindingResult.getFieldError().getField(), bindingResult.getFieldError().getRejectedValue(),
					bindingResult.getAllErrors().get(0).getDefaultMessage());
			return ResponseHandler.generateValidationResponse(bindingResult.getAllErrors().get(0).getDefaultMessage());
		}
		return ResponseHandler.generateControllerResponse(permissionServiceHelper.saveRolePermission(permissionForm));
	}

	/**
	 * This api end point is used to update role based permission.
	 * 
	 * @param permissionIdModel {@link PermissionIdModel}
	 * @param permissionForm    {@link PermissionForm}
	 * @param bindingResult     {@link BindingResult}
	 * @return {@link ResponseEntity} of {@link ResponseDTO}
	 */
	@PutMapping(value = ApiUrl.UPDATE_ROLE_PERMISSIONS)
	public ResponseEntity<ResponseDTO> updateRolePermission(
			@Validated(value = ValidateSequence.class) @ModelAttribute PermissionIdModel permissionIdModel,
			@Validated(value = ValidateSequence.class) @RequestBody PermissionForm permissionForm,
			BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			LOGGER.error(
					"Validation failed while updating role permissions for field {} with rejected value {} with message {} ",
					bindingResult.getFieldError().getField(), bindingResult.getFieldError().getRejectedValue(),
					bindingResult.getAllErrors().get(0).getDefaultMessage());
			return ResponseHandler.generateValidationResponse(bindingResult.getAllErrors().get(0).getDefaultMessage());
		}
		return ResponseHandler.generateControllerResponse(
				permissionServiceHelper.updatePermission(permissionIdModel.getPermissionId(), permissionForm));
	}

	/**
	 * This api end point is used to delete role based permission.
	 * 
	 * @param permissionForm {@link PermissionForm}
	 * @param bindingResult  {@link BindingResult}
	 * @return {@link ResponseEntity} of {@link ResponseDTO}
	 */
	@PutMapping(value = ApiUrl.DELETE_ROLE_PERMISSIONS)
	public ResponseEntity<ResponseDTO> deleteRolePermission(
			@Validated(value = ValidateSequence.class) @RequestBody PermissionForm permissionForm,
			BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			LOGGER.error(
					"Validation failed while deleting role permissions for field {} with rejected value {} with message {} ",
					bindingResult.getFieldError().getField(), bindingResult.getFieldError().getRejectedValue(),
					bindingResult.getAllErrors().get(0).getDefaultMessage());
			return ResponseHandler.generateValidationResponse(bindingResult.getAllErrors().get(0).getDefaultMessage());
		}
		return ResponseHandler
				.generateControllerResponse(permissionServiceHelper.deleteRolePermissions(permissionForm));
	}

	/**
	 * This api end point is used to get all permissions by role id.
	 * 
	 * @param roleId id of role.
	 * @return {@link ResponseEntity} of {@link ResponseDTO}
	 */
	@GetMapping(value = ApiUrl.GET_ROLE_PERMISSIONS)
	public ResponseEntity<ResponseDTO> getRolePermissions(@RequestParam Long roleId) {
		return ResponseHandler.generateControllerResponse(permissionServiceHelper.getRolePermission(roleId));
	}

	@GetMapping(value = ApiUrl.GET_SUBMODULES)
	public ResponseEntity<com.prosmv.dto.ResponseDTO<List<SubModuleDTO>>> getSubModules(@RequestBody Long moduleId) {
		List<SubModuleDTO> subModuleDTOs = permissionService.getSubModules(moduleId);
		if (subModuleDTOs != null) {
			return ResponseHandler.generateSuccessResponse(HttpStatus.OK, Boolean.FALSE, Constant.SUCCESS,
					subModuleDTOs);
		}
		return ResponseHandler.generateSuccessResponse(HttpStatus.BAD_REQUEST, true, Constant.ERROR, null);
	}

	@RequestMapping(value = ApiUrl.GET_ROLES, method = RequestMethod.GET)
	public ResponseEntity<com.prosmv.dto.ResponseDTO<List<RoleDTO>>> getRoles(@RequestBody Long companyId) {
		List<RoleDTO> roleDTOs = permissionService.getRoles(companyId);
		if (roleDTOs != null) {
			return ResponseHandler.generateSuccessResponse(HttpStatus.OK, Boolean.FALSE, Constant.SUCCESS, roleDTOs);
		}
		return ResponseHandler.generateSuccessResponse(HttpStatus.BAD_REQUEST, true, Constant.ERROR, null);
	}

	/**
	 * This api end point is used to get auto complete role details by role name.
	 * 
	 * @param roleName name of {@link Role}
	 * @return {@link ResponseEntity} of {@link ResponseDTO}
	 */
	@GetMapping(value = ApiUrl.AUTO_COMPLETE_ROLE)
	public ResponseEntity<ResponseDTO> getAutoCompleteRole(@RequestParam String roleName) {
		return ResponseHandler.generateControllerResponse(permissionServiceHelper.getAutoCompleteRole(roleName));
	}

	/**
	 * This api end point is used to get auto complete role details by role name and
	 * company id.
	 * 
	 * @param companyIdModel {@link CompanyIdModel}
	 * @param bindingResult  {@link BindingResult}
	 * @param roleName       name of {@link Role}
	 * @return {@link ResponseEntity} of {@link ResponseDTO}
	 */
	@GetMapping(value = ApiUrl.AUTO_COMPLETE_ROLE_BY_COMPANY)
	public ResponseEntity<ResponseDTO> getAutoCompleteRoleByCompany(
			@Validated(value = ValidateSequence.class) @ModelAttribute CompanyIdModel companyIdModel,
			BindingResult bindingResult, @RequestParam String roleName) {
		if (bindingResult.hasErrors()) {
			return ResponseHandler.generateValidationResponse(bindingResult.getAllErrors().get(0).getDefaultMessage());
		}
		return ResponseHandler.generateControllerResponse(
				permissionServiceHelper.getAutoCompleteRoleByCompany(companyIdModel.getCompanyId(), roleName));
	}
}
