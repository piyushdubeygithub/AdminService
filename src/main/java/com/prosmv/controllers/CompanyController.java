package com.prosmv.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
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
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.prosmv.annotations.sequence.ValidateSequence;
import com.prosmv.constants.url.ApiUrl;
import com.prosmv.domain.Company;
import com.prosmv.dto.response.ResponseDTO;
import com.prosmv.form.CompanyForm;
import com.prosmv.form.UpdateCompanyForm;
import com.prosmv.form.modelattributre.CompanyIdModel;
import com.prosmv.form.modelattributre.CompanyStatusModel;
import com.prosmv.form.modelattributre.UserIdModel;
import com.prosmv.service.company.helper.CompanyServiceHelper;
import com.prosmv.util.ResponseHandler;

/**
 * This controller class will contains all the api end points used for
 * operations such as save,update,get,delete and so on related to
 * {@link Company}.
 * 
 * @author piyush
 *
 */
@RestController
public class CompanyController {

	private static final Logger LOGGER = LoggerFactory.getLogger(CompanyController.class);

	@Autowired
	private CompanyServiceHelper companyServiceHelper;

	/**
	 * This api endpoint is used to register a new company.
	 * 
	 * @param companyForm
	 * @param bindingResult
	 * @return
	 */
	@PostMapping(value = ApiUrl.REGISTER_COMPANY,consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public ResponseEntity<ResponseDTO> registerCompany(
			@Validated(value = ValidateSequence.class) @RequestBody(required = true) CompanyForm companyForm,
			BindingResult bindingResult, @RequestPart(required = false) MultipartFile companyLogo) {
		if (bindingResult.hasErrors()) {
			LOGGER.error(
					"Validation failed while creating company for field {} with rejected value {} with message {} ",
					bindingResult.getFieldError().getField(), bindingResult.getFieldError().getRejectedValue(),
					bindingResult.getAllErrors().get(0).getDefaultMessage());
			return ResponseHandler.generateValidationResponse(bindingResult.getAllErrors().get(0).getDefaultMessage());
		}
		return ResponseHandler.generateControllerResponse(companyServiceHelper.saveCompany(companyForm, companyLogo));
	}

	/**
	 * This api endpoint is used to update an existing company
	 * 
	 * @param companyForm
	 * @return
	 */
	@PutMapping(value = ApiUrl.UPDATE_COMPANY)
	public ResponseEntity<ResponseDTO> updateCompany(
			@Validated(value = ValidateSequence.class) @RequestBody(required = true) UpdateCompanyForm companyForm,
			BindingResult bindingResult2, @RequestParam(required = false) MultipartFile companyLogo) {
		if (bindingResult2.hasErrors()) {
			LOGGER.error(
					"Validation failed while updating company for field {} with rejected value {} with message {} ",
					bindingResult2.getFieldError().getField(), bindingResult2.getFieldError().getRejectedValue(),
					bindingResult2.getAllErrors().get(0).getDefaultMessage());
			return ResponseHandler.generateValidationResponse(bindingResult2.getAllErrors().get(0).getDefaultMessage());
		}
		return ResponseHandler.generateControllerResponse(companyServiceHelper.updateCompany(companyForm, companyLogo));
	}

	/**
	 * This api endpoint is used to get the list of companies
	 * 
	 * @param request
	 * @return
	 */
	@GetMapping(value = ApiUrl.COMPANY_LIST)
	public ResponseEntity<ResponseDTO> getCompanyList() {
		return ResponseHandler.generateControllerResponse(companyServiceHelper.getCompanyList());
	}

	/**
	 * This api endpoint is used to de activate the company.
	 * 
	 * @param deActivateCompanyModel {@link DeActivateCompanyModel}
	 * @param bindingResult          {@link BindingResult}
	 * @return {@link ResponseEntity} of {@link ResponseDTO}
	 */
	@GetMapping(value = ApiUrl.DEACTIVATE_COMPANY)
	public ResponseEntity<ResponseDTO> deActivateCompany(
			@Validated(value = ValidateSequence.class) CompanyIdModel companyIdModel, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			LOGGER.error(
					"Validation failed while de activating company for field {} with rejected value {} with message {} ",
					bindingResult.getFieldError().getField(), bindingResult.getFieldError().getRejectedValue(),
					bindingResult.getAllErrors().get(0).getDefaultMessage());
			return ResponseHandler.generateValidationResponse(bindingResult.getAllErrors().get(0).getDefaultMessage());
		}
		return ResponseHandler
				.generateControllerResponse(companyServiceHelper.deActivateCompany(companyIdModel.getCompanyId()));
	}

	/**
	 * This api endpoint is used to activate company.
	 * 
	 * @param activateCompanyModel {@link ActivateCompanyModel}
	 * @param bindingResult        {@link BindingResult}
	 * @return {@link ResponseEntity} of {@link ResponseDTO}
	 */
	@GetMapping(value = ApiUrl.ACTIVATE_COMPANY)
	public ResponseEntity<ResponseDTO> activateCompany(
			@Validated(value = ValidateSequence.class) @ModelAttribute CompanyIdModel companyIdModel,
			BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			LOGGER.error(
					"Validation failed while activating company company for field {} with rejected value {} with message {} ",
					bindingResult.getFieldError().getField(), bindingResult.getFieldError().getRejectedValue(),
					bindingResult.getAllErrors().get(0).getDefaultMessage());
			return ResponseHandler.generateValidationResponse(bindingResult.getAllErrors().get(0).getDefaultMessage());
		}
		return ResponseHandler
				.generateControllerResponse(companyServiceHelper.activateCompany(companyIdModel.getCompanyId()));
	}

	/**
	 * This api endpoint is used to delete company.
	 * 
	 * @param deleteCompanyModel {@link DeleteCompanyModel}
	 * @param bindingResult      {@link BindingResult}
	 * @return {@link ResponseEntity} of {@link ResponseDTO}
	 */
	@DeleteMapping(value = ApiUrl.DELETE_COMPANY)
	public ResponseEntity<ResponseDTO> deleteCompany(
			@Validated(value = ValidateSequence.class) @ModelAttribute CompanyIdModel companyIdModel,
			BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			LOGGER.error(
					"Validation failed while deleting company for field {} with rejected value {} with message {} ",
					bindingResult.getFieldError().getField(), bindingResult.getFieldError().getRejectedValue(),
					bindingResult.getAllErrors().get(0).getDefaultMessage());
			return ResponseHandler.generateValidationResponse(bindingResult.getAllErrors().get(0).getDefaultMessage());
		}
		return ResponseHandler
				.generateControllerResponse(companyServiceHelper.deleteCompany(companyIdModel.getCompanyId()));
	}

	/**
	 * This api endpoint is used to set company status.
	 * 
	 * @param companyStatusModel {@link CompanyStatusModel}
	 * @param bindingResult      {@link BindingResult}
	 * @return {@link ResponseEntity} of {@link ResponseDTO}
	 */
	@GetMapping(value = ApiUrl.SET_COMPANY_STATUS)
	public ResponseEntity<ResponseDTO> setCompanyStatus(
			@Validated(value = ValidateSequence.class) @ModelAttribute CompanyIdModel companyIdModel,
			BindingResult bindingResult, @ModelAttribute CompanyStatusModel companyStatusModel) {
		if (bindingResult.hasErrors()) {
			LOGGER.error(
					"Validation failed while setting company status company for field {} with rejected value {} with message {} ",
					bindingResult.getFieldError().getField(), bindingResult.getFieldError().getRejectedValue(),
					bindingResult.getAllErrors().get(0).getDefaultMessage());
			return ResponseHandler.generateValidationResponse(bindingResult.getAllErrors().get(0).getDefaultMessage());
		}
		return ResponseHandler.generateControllerResponse(
				companyServiceHelper.setCompanyStatus(companyIdModel.getCompanyId(), companyStatusModel.isActive()));
	}

	/**
	 * This api end point is used to get auto complete company data.
	 * 
	 * @param companyName name of {@link Company}
	 * @return {@link ResponseEntity} of {@link ResponseDTO}
	 */
	@GetMapping(value = ApiUrl.AUTO_COMPLETE_COMPANY)
	public ResponseEntity<ResponseDTO> autoCompleteCompany(@RequestParam String companyName) {
		return ResponseHandler.generateControllerResponse(companyServiceHelper.autoCompleteCompany(companyName));
	}

	@GetMapping(value = ApiUrl.USER_COMPANY)
	public ResponseEntity<ResponseDTO> getCompanyByUser(
			@Validated(value = ValidateSequence.class) @ModelAttribute UserIdModel userIdIdModel,
			BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			LOGGER.error(
					"Validation failed while deleting company for field {} with rejected value {} with message {} ",
					bindingResult.getFieldError().getField(), bindingResult.getFieldError().getRejectedValue(),
					bindingResult.getAllErrors().get(0).getDefaultMessage());
			return ResponseHandler.generateValidationResponse(bindingResult.getAllErrors().get(0).getDefaultMessage());
		}
		return ResponseHandler
				.generateControllerResponse(companyServiceHelper.getCompanyByUser(userIdIdModel.getUserId()));
	}

	@PostMapping(value = ApiUrl.UPLOAD_COMPANY_LOGO,consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public ResponseEntity<ResponseDTO> uploadCompanyImage(
			@Validated(value = ValidateSequence.class) @ModelAttribute CompanyIdModel companyIdModel,
			BindingResult bindingResult, @RequestPart(required = true) MultipartFile companyLogo) {
		if (bindingResult.hasErrors()) {
			return ResponseHandler.generateValidationResponse(bindingResult.getAllErrors().get(0).getDefaultMessage());
		}
		return ResponseHandler.generateControllerResponse(
				companyServiceHelper.uploadCompanyLogo(companyIdModel.getCompanyId(), companyLogo));
	}

}
