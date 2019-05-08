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
import com.prosmv.domain.Factory;
import com.prosmv.dto.response.ResponseDTO;
import com.prosmv.form.FactoryForm;
import com.prosmv.form.UpdateFactoryForm;
import com.prosmv.form.modelattributre.CompanyIdModel;
import com.prosmv.form.modelattributre.FactoryIdModel;
import com.prosmv.service.factory.helper.FactoryServiceHelper;
import com.prosmv.util.ResponseHandler;

/**
 * This controller class will contains all the api end points used for
 * operations such as save,update,get,delete and so on related to
 * {@link Factory}.
 * 
 * @author piyush
 *
 */
@RestController
public class FactoryController {

	private static final Logger LOGGER = LoggerFactory.getLogger(FactoryController.class);

	@Autowired
	private FactoryServiceHelper factoryServiceHelper;

	/**
	 * This api end point is used to create or register {@link Factory}.
	 * 
	 * @param factoryForm
	 *            {@link FactoryForm}
	 * @param bindingResult
	 *            {@link BindingResult}
	 * @return
	 */
	@PostMapping(value = ApiUrl.REGISTER_FACTORY)
	public ResponseEntity<ResponseDTO> registerFactory(
			@Validated(value = ValidateSequence.class) @RequestBody FactoryForm factoryForm,
			BindingResult bindingResult2) {
		if (bindingResult2.hasErrors()) {
			LOGGER.error(
					"Validation failed while creating factory for field {} with rejected value {} with message {} ",
					bindingResult2.getFieldError().getField(), bindingResult2.getFieldError().getRejectedValue(),
					bindingResult2.getAllErrors().get(0).getDefaultMessage());
			return ResponseHandler.generateValidationResponse(bindingResult2.getAllErrors().get(0).getDefaultMessage());
		}
		return ResponseHandler.generateControllerResponse(factoryServiceHelper.saveFactory(factoryForm));
	}

	/**
	 * This api end point is used to update {@link Factory}.
	 * 
	 * @param factoryIdModel
	 *            {@link FactoryIdModel}
	 * @param factoryForm
	 *            {@link FactoryForm}
	 * @param bindingResult
	 *            {@link BindingResult}
	 * @return {@link ResponseEntity} of {@link ResponseDTO}
	 */
	@PutMapping(value = ApiUrl.UPDATE_FACTORY)
	public ResponseEntity<ResponseDTO> updateFactory(
			@Validated(value = ValidateSequence.class) @RequestBody UpdateFactoryForm factoryForm,
			BindingResult bindingResult2) {
		if (bindingResult2.hasErrors()) {
			LOGGER.error(
					"Validation failed while updating factory for field {} with rejected value {} with message {} ",
					bindingResult2.getFieldError().getField(), bindingResult2.getFieldError().getRejectedValue(),
					bindingResult2.getAllErrors().get(0).getDefaultMessage());
			return ResponseHandler.generateValidationResponse(bindingResult2.getAllErrors().get(0).getDefaultMessage());
		}
		return ResponseHandler.generateControllerResponse(factoryServiceHelper.updateFactory(factoryForm));
	}

	/**
	 * This api end point is used to get all {@link Factory}.
	 * 
	 * @return {@link ResponseEntity} of {@link ResponseDTO}
	 */
	@GetMapping(value = ApiUrl.FACTORY_LIST)
	public ResponseEntity<ResponseDTO> getFactoryList() {
		return ResponseHandler.generateControllerResponse(factoryServiceHelper.getFactoryList());
	}

	@GetMapping(value = ApiUrl.FACTORY_LIST_BY_COMPANY)
	public ResponseEntity<ResponseDTO> getFactoryListByCompany(
			@Validated(value = ValidateSequence.class) @ModelAttribute CompanyIdModel companyIdModel,
			BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return ResponseHandler.generateValidationResponse(bindingResult.getAllErrors().get(0).getDefaultMessage());
		}
		return ResponseHandler.generateControllerResponse(
				factoryServiceHelper.getFactoryListByCompany(companyIdModel.getCompanyId()));
	}

	/**
	 * This api end point is used to de activate {@link Factory}.
	 * 
	 * @param factoryIdModel
	 *            {@link FactoryIdModel}
	 * @param bindingResult
	 *            {@link BindingResult}
	 * @return {@link ResponseEntity} of {@link ResponseDTO}
	 */
	@PutMapping(value = ApiUrl.DEACTIVATE_FACTORY)
	public ResponseEntity<ResponseDTO> deActivateFactory(
			@Validated(value = ValidateSequence.class) @ModelAttribute FactoryIdModel factoryIdModel,
			BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			LOGGER.error(
					"Validation failed while deactivating factory for field {} with rejected value {} with message {} ",
					bindingResult.getFieldError().getField(), bindingResult.getFieldError().getRejectedValue(),
					bindingResult.getAllErrors().get(0).getDefaultMessage());
			return ResponseHandler.generateValidationResponse(bindingResult.getAllErrors().get(0).getDefaultMessage());
		}
		return ResponseHandler
				.generateControllerResponse(factoryServiceHelper.deActivateFactory(factoryIdModel.getFactoryId()));
	}

	/**
	 * This api end point is used to activate {@link Factory}.
	 * 
	 * @param factoryIdModel
	 *            {@link FactoryIdModel}
	 * @param bindingResult
	 *            {@link BindingResult}
	 * @return {@link ResponseEntity} of {@link ResponseDTO}
	 */
	@PutMapping(value = ApiUrl.ACTIVATE_FACTORY)
	public ResponseEntity<ResponseDTO> activateFactory(
			@Validated(value = ValidateSequence.class) @ModelAttribute FactoryIdModel factoryIdModel,
			BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			LOGGER.error(
					"Validation failed while activating factory for field {} with rejected value {} with message {} ",
					bindingResult.getFieldError().getField(), bindingResult.getFieldError().getRejectedValue(),
					bindingResult.getAllErrors().get(0).getDefaultMessage());
			return ResponseHandler.generateValidationResponse(bindingResult.getAllErrors().get(0).getDefaultMessage());
		}
		return ResponseHandler
				.generateControllerResponse(factoryServiceHelper.activateFactory(factoryIdModel.getFactoryId()));
	}

	/**
	 * This api end point is used to delete {@link Factory}.
	 * 
	 * @param factoryIdModel
	 *            {@link FactoryIdModel}
	 * @param bindingResult
	 *            {@link BindingResult}
	 * @return {@link ResponseEntity} of {@link ResponseDTO}
	 */
	@DeleteMapping(value = ApiUrl.DELETE_FACTORY)
	public ResponseEntity<ResponseDTO> deleteFactory(
			@Validated(value = ValidateSequence.class) @ModelAttribute FactoryIdModel factoryIdModel,
			BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			LOGGER.error(
					"Validation failed while deleting factory for field {} with rejected value {} with message {} ",
					bindingResult.getFieldError().getField(), bindingResult.getFieldError().getRejectedValue(),
					bindingResult.getAllErrors().get(0).getDefaultMessage());
			return ResponseHandler.generateValidationResponse(bindingResult.getAllErrors().get(0).getDefaultMessage());
		}
		return ResponseHandler
				.generateControllerResponse(factoryServiceHelper.deleteFactory(factoryIdModel.getFactoryId()));
	}

	/**
	 * This api end point is used to set {@link Factory} status.
	 * 
	 * @param factoryStatusForm
	 *            {@link FactoryStatusForm}
	 * @param bindingResult
	 *            {@link BindingResult}
	 * @return {@link ResponseEntity} of {@link ResponseDTO}
	 */
	@GetMapping(value = ApiUrl.SET_FACTORY_STATUS)
	public ResponseEntity<ResponseDTO> setFactoryStatus(
			@Validated(value = ValidateSequence.class) @ModelAttribute FactoryIdModel factoryIdModel,
			BindingResult bindingResult, @RequestParam boolean active) {
		if (bindingResult.hasErrors()) {
			LOGGER.error(
					"Validation failed while set factory status for field {} with rejected value {} with message {} ",
					bindingResult.getFieldError().getField(), bindingResult.getFieldError().getRejectedValue(),
					bindingResult.getAllErrors().get(0).getDefaultMessage());
			return ResponseHandler.generateValidationResponse(bindingResult.getAllErrors().get(0).getDefaultMessage());
		}
		return ResponseHandler.generateControllerResponse(
				factoryServiceHelper.setFactoryStatus(factoryIdModel.getFactoryId(), active));
	}

	/**
	 * This api endpoint is used to auto complete factory name.
	 * 
	 * @param factoryName
	 *            name of {@link Factory}
	 * @return {@link ResponseEntity} of {@link ResponseDTO}
	 */
	@GetMapping(value = ApiUrl.AUTO_COMPLETE_FACTORY)
	public ResponseEntity<ResponseDTO> getAutoCompleteFactory(@RequestParam String factoryName) {
		return ResponseHandler.generateControllerResponse(factoryServiceHelper.getAutoCompleteFactory(factoryName));
	}

	@GetMapping(value = ApiUrl.FACTORY_COMPANY)
	public ResponseEntity<ResponseDTO> getCompanyByFactory(
			@Validated(value = ValidateSequence.class) @ModelAttribute FactoryIdModel factoryIdModel,
			BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			LOGGER.error(
					"Validation failed while deleting factory for field {} with rejected value {} with message {} ",
					bindingResult.getFieldError().getField(), bindingResult.getFieldError().getRejectedValue(),
					bindingResult.getAllErrors().get(0).getDefaultMessage());
			return ResponseHandler.generateValidationResponse(bindingResult.getAllErrors().get(0).getDefaultMessage());
		}
		return ResponseHandler.generateControllerResponse(factoryServiceHelper.getCompanyByFactory(factoryIdModel.getFactoryId()));
	}

}
