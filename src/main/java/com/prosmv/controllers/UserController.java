package com.prosmv.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.prosmv.annotations.sequence.ValidateSequence;
import com.prosmv.constants.url.ApiUrl;
import com.prosmv.domain.Company;
import com.prosmv.domain.User;
import com.prosmv.dto.response.ResponseDTO;
import com.prosmv.form.UpdateUserForm;
import com.prosmv.form.UserForm;
import com.prosmv.form.modelattributre.CompanyIdModel;
import com.prosmv.form.modelattributre.UserIdModel;
import com.prosmv.service.user.helper.UserServiceHelper;
import com.prosmv.util.ResponseHandler;

/**
 * This controller class will contains all the api end points used for
 * operations such as save,update,get,delete and so on related to {@link User}.
 * 
 * @author piyush
 *
 */
@RestController
public class UserController {

	private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

	@Autowired
	private UserServiceHelper userServiceHelper;

	/**
	 * This api end point is used to register {@link User}.
	 * 
	 * @param userForm      {@link UserForm}
	 * @param bindingResult {@link BindingResult}
	 * @return {@link ResponseEntity} of {@link ResponseDTO}
	 */
	@PostMapping(value = ApiUrl.REGISTER_USER)
	public ResponseEntity<ResponseDTO> registerUser(
			@Validated(value = ValidateSequence.class) @RequestBody UserForm userForm, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			LOGGER.error("Validation failed while creating user for field {} with rejected value {} with message {} ",
					bindingResult.getFieldError().getField(), bindingResult.getFieldError().getRejectedValue(),
					bindingResult.getAllErrors().get(0).getDefaultMessage());
			return ResponseHandler.generateValidationResponse(bindingResult.getAllErrors().get(0).getDefaultMessage());
		}
		return ResponseHandler.generateControllerResponse(userServiceHelper.saveUser(userForm));
	}

	/**
	 * This api end point is used to update {@link User}.
	 * 
	 * @param userIdModel   {@link UserIdModel}
	 * @param userForm      {@link UserForm}
	 * @param bindingResult {@link BindingResult}
	 * @return {@link ResponseEntity} of {@link ResponseDTO}
	 */
	@PutMapping(value = ApiUrl.UPDATE_USER)
	public ResponseEntity<ResponseDTO> updateUser(
			@Validated(value = ValidateSequence.class) @RequestBody UpdateUserForm userForm, BindingResult bindingResult2) {
		if (bindingResult2.hasErrors()) {
			LOGGER.error("Validation failed while updating user for field {} with rejected value {} with message {} ",
					bindingResult2.getFieldError().getField(), bindingResult2.getFieldError().getRejectedValue(),
					bindingResult2.getAllErrors().get(0).getDefaultMessage());
			return ResponseHandler.generateValidationResponse(bindingResult2.getAllErrors().get(0).getDefaultMessage());
		}
		return ResponseHandler
				.generateControllerResponse(userServiceHelper.updateUser(userForm));
	}

	/**
	 * This api end point is used to get all {@link User} by {@link Company} id.
	 * 
	 * @param companyIdModel {@link CompanyIdModel}
	 * @param bindingResult  {@link BindingResult}
	 * @return {@link ResponseEntity} of {@link ResponseDTO}
	 */
	@GetMapping(value = ApiUrl.USER_LIST)
	public ResponseEntity<ResponseDTO> getCompanyUserList(
			@Validated(value = ValidateSequence.class) @ModelAttribute CompanyIdModel companyIdModel,
			BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			LOGGER.error(
					"Validation failed while getting users list by company for field {} with rejected value {} with message {} ",
					bindingResult.getFieldError().getField(), bindingResult.getFieldError().getRejectedValue(),
					bindingResult.getAllErrors().get(0).getDefaultMessage());
			return ResponseHandler.generateValidationResponse(bindingResult.getAllErrors().get(0).getDefaultMessage());
		}
		return ResponseHandler.generateControllerResponse(userServiceHelper.getAllUser(companyIdModel.getCompanyId()));
	}

	/**
	 * This api end point is used to deactivate {@link User}.
	 * 
	 * @param userIdModel   {@link UserIdModel}
	 * @param bindingResult {@link BindingResult}
	 * @return {@link ResponseEntity} of {@link ResponseDTO}
	 */
	@PutMapping(value = ApiUrl.DEACTIVATE_USER)
	public ResponseEntity<ResponseDTO> deActivateUser(
			@Validated(value = ValidateSequence.class) @ModelAttribute UserIdModel userIdModel,
			BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			LOGGER.error(
					"Validation failed while deactivating user for field {} with rejected value {} with message {} ",
					bindingResult.getFieldError().getField(), bindingResult.getFieldError().getRejectedValue(),
					bindingResult.getAllErrors().get(0).getDefaultMessage());
			return ResponseHandler.generateValidationResponse(bindingResult.getAllErrors().get(0).getDefaultMessage());
		}

		return ResponseHandler.generateControllerResponse(userServiceHelper.deActivateUser(userIdModel.getUserId()));
	}

	/**
	 * This api end point is used to activate {@link User}.
	 * 
	 * @param userIdModel   {@link UserIdModel}
	 * @param bindingResult {@link BindingResult}
	 * @return {@link ResponseEntity} of {@link ResponseDTO}
	 */
	@PutMapping(value = ApiUrl.ACTIVATE_USER)
	public ResponseEntity<ResponseDTO> activateUser(
			@Validated(value = ValidateSequence.class) @ModelAttribute UserIdModel userIdModel,
			BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			LOGGER.error("Validation failed while activating user for field {} with rejected value {} with message {} ",
					bindingResult.getFieldError().getField(), bindingResult.getFieldError().getRejectedValue(),
					bindingResult.getAllErrors().get(0).getDefaultMessage());
			return ResponseHandler.generateValidationResponse(bindingResult.getAllErrors().get(0).getDefaultMessage());
		}
		return ResponseHandler.generateControllerResponse(userServiceHelper.activateUser(userIdModel.getUserId()));
	}

	/**
	 * This api end point is used to set {@link User} status.
	 * 
	 * @param userIdModel   {@link UserIdModel}
	 * @param active        {@code true} or {@code false}
	 * @param bindingResult {@link BindingResult}
	 * @return {@link ResponseEntity} of {@link ResponseDTO}
	 */
	@GetMapping(value = ApiUrl.SET_USER_STATUS)
	public ResponseEntity<ResponseDTO> setUserStatus(
			@Validated(value = ValidateSequence.class) @ModelAttribute UserIdModel userIdModel,BindingResult bindingResult,
			@RequestParam boolean active) {
		if (bindingResult.hasErrors()) {
			LOGGER.error(
					"Validation failed while setting user status for field {} with rejected value {} with message {} ",
					bindingResult.getFieldError().getField(), bindingResult.getFieldError().getRejectedValue(),
					bindingResult.getAllErrors().get(0).getDefaultMessage());
			return ResponseHandler.generateValidationResponse(bindingResult.getAllErrors().get(0).getDefaultMessage());
		}
		return ResponseHandler
				.generateControllerResponse(userServiceHelper.setUserStatus(userIdModel.getUserId(), active));
	}

	/**
	 * This api end point is used to get all {@link User}.
	 * 
	 * @return {@link ResponseEntity} of {@link ResponseDTO}
	 */
	@GetMapping(value = ApiUrl.GET_ALL_USERS)
	public ResponseEntity<ResponseDTO> getUserList() {
		return ResponseHandler.generateControllerResponse(userServiceHelper.getAllUser());
	}

	/**
	 * This api end point is used to delete {@link User}.
	 * 
	 * @param userIdModel   {@link UserIdModel}
	 * @param bindingResult {@link BindingResult}
	 * @return {@link ResponseEntity} of {@link ResponseDTO}
	 */
	@DeleteMapping(value = ApiUrl.DELETE_USER)
	public ResponseEntity<ResponseDTO> deleteUser(
			@Validated(value = ValidateSequence.class) @ModelAttribute UserIdModel userIdModel,
			BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			LOGGER.error("Validation failed while deleting user for field {} with rejected value {} with message {} ",
					bindingResult.getFieldError().getField(), bindingResult.getFieldError().getRejectedValue(),
					bindingResult.getAllErrors().get(0).getDefaultMessage());
			return ResponseHandler.generateValidationResponse(bindingResult.getAllErrors().get(0).getDefaultMessage());
		}
		return ResponseHandler.generateControllerResponse(userServiceHelper.deleteUser(userIdModel.getUserId()));
	}
	
}
