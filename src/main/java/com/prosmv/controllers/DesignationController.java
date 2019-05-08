package com.prosmv.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.prosmv.annotations.sequence.ValidateSequence;
import com.prosmv.constants.url.ApiUrl;
import com.prosmv.domain.Designation;
import com.prosmv.dto.response.ResponseDTO;
import com.prosmv.form.DesignationForm;
import com.prosmv.form.modelattributre.DesignationIdModel;
import com.prosmv.service.designation.helper.DesignationServiceHelper;
import com.prosmv.util.ResponseHandler;

/**
 * This controller class will contains all the api end points used for
 * operations such as save,update,get,delete and so on related to
 * {@link Designation}.
 * 
 * @author piyush
 *
 */
@RestController
public class DesignationController {

	private static final Logger LOGGER = LoggerFactory.getLogger(DesignationController.class);

	@Autowired
	private DesignationServiceHelper designationServiceHelper;

	/**
	 * This api end point is used to create {@link Designation}.
	 * 
	 * @param designationForm {@link DesignationForm}
	 * @param bindingResult   {@link BindingResult}
	 * @return {@link ResponseEntity} of {@link ResponseDTO}
	 */
	@PostMapping(value = ApiUrl.CREATE_DESIGNATION)
	public ResponseEntity<ResponseDTO> createDesignation(
			@Validated(value = ValidateSequence.class) @RequestBody DesignationForm designationForm,
			BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			LOGGER.error(
					"Validation failed while creating designation for field {} with rejected value {} with message {} ",
					bindingResult.getFieldError().getField(), bindingResult.getFieldError().getRejectedValue(),
					bindingResult.getAllErrors().get(0).getDefaultMessage());
			return ResponseHandler.generateValidationResponse(bindingResult.getAllErrors().get(0).getDefaultMessage());
		}
		return ResponseHandler.generateControllerResponse(designationServiceHelper.createDesignation(designationForm));
	}

	/**
	 * This api end point is used to update {@link Designation}.
	 * 
	 * @param designationIdModel {@link DesignationIdModel}
	 * @param designationForm    {@link DesignationForm}
	 * @param bindingResult      {@link BindingResult}
	 * @return {@link ResponseEntity} of {@link ResponseDTO}
	 */
	@PutMapping(value = ApiUrl.UPDATE_DESIGNATION)
	public ResponseEntity<ResponseDTO> updateDesignation(
			@Validated(value = ValidateSequence.class) @ModelAttribute DesignationIdModel designationIdModel,
			@Validated(value = ValidateSequence.class) @RequestBody DesignationForm designationForm,
			BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			LOGGER.error(
					"Validation failed while updating designation for field {} with rejected value {} with message {} ",
					bindingResult.getFieldError().getField(), bindingResult.getFieldError().getRejectedValue(),
					bindingResult.getAllErrors().get(0).getDefaultMessage());
			return ResponseHandler.generateValidationResponse(bindingResult.getAllErrors().get(0).getDefaultMessage());
		}
		return ResponseHandler.generateControllerResponse(
				designationServiceHelper.updateDesignation(designationIdModel.getDesignationId(), designationForm));
	}

	/**
	 * This api end point is used to delete {@link Designation}.
	 * 
	 * @param designationIdModel {@link DesignationIdModel}
	 * @param bindingResult      {@link BindingResult}
	 * @return {@link ResponseEntity} of {@link ResponseDTO}
	 */
	@DeleteMapping(value = ApiUrl.DELETE_DESIGNATION)
	public ResponseEntity<ResponseDTO> deleteDesignation(
			@Validated(value = ValidateSequence.class) @ModelAttribute DesignationIdModel designationIdModel,
			BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			LOGGER.error(
					"Validation failed while deleting designation for field {} with rejected value {} with message {} ",
					bindingResult.getFieldError().getField(), bindingResult.getFieldError().getRejectedValue(),
					bindingResult.getAllErrors().get(0).getDefaultMessage());
			return ResponseHandler.generateValidationResponse(bindingResult.getAllErrors().get(0).getDefaultMessage());
		}
		return ResponseHandler.generateControllerResponse(
				designationServiceHelper.deleteDesignation(designationIdModel.getDesignationId()));
	}

	/**
	 * This api end point is used to get all {@link Designation}.
	 * 
	 * @return {@link ResponseEntity} of {@link ResponseDTO}
	 */
	@DeleteMapping(value = ApiUrl.GET_ALL_DESIGNATIONS)
	public ResponseEntity<ResponseDTO> getAllDesignations() {
		return ResponseHandler.generateControllerResponse(designationServiceHelper.getAllDesignations());
	}
}
