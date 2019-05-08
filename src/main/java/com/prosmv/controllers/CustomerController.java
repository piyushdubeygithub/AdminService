//package com.prosmv.controllers;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.validation.BindingResult;
//import org.springframework.validation.annotation.Validated;
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.prosmv.annotations.sequence.ValidateSequence;
//import com.prosmv.constants.url.ApiUrl;
//import com.prosmv.domain.Brand;
//import com.prosmv.domain.CustomerSupplier;
//import com.prosmv.dto.response.ResponseDTO;
//import com.prosmv.form.AddBrandForm;
//import com.prosmv.form.CustomerForm;
//import com.prosmv.form.modelattributre.BrandIdModel;
//import com.prosmv.form.modelattributre.CustomerIdModel;
//import com.prosmv.form.modelattributre.FactoryIdModel;
//import com.prosmv.service.customer.helper.CustomerServiceHelper;
//import com.prosmv.util.ResponseHandler;
//
///**
// * This controller class will contains all the api end points used for
// * operations such as save,update,get,delete and so on related to
// * {@link CustomerSupplier}.
// * 
// * @author piyush
// *
// */
//@RestController
//public class CustomerController {
//
//	private static final Logger LOGGER = LoggerFactory.getLogger(CustomerController.class);
//
//	@Autowired
//	private CustomerServiceHelper customerServiceHelper;
//
//	/**
//	 * This api end point is used to create {@link CustomerSupplier}
//	 * 
//	 * @param customerForm  {@link CustomerForm}
//	 * @param bindingResult {@link BindingResult}
//	 * @return {@link ResponseEntity} of {@link ResponseDTO}
//	 */
//	@PostMapping(value = ApiUrl.REGISTER_CUSTOMER)
//	public ResponseEntity<ResponseDTO> registerCustomer(
//			@Validated(value = ValidateSequence.class) @RequestBody CustomerForm customerForm,
//			BindingResult bindingResult) {
//		if (bindingResult.hasErrors()) {
//			LOGGER.error(
//					"Validation failed while creating customer for field {} with rejected value {} with message {} ",
//					bindingResult.getFieldError().getField(), bindingResult.getFieldError().getRejectedValue(),
//					bindingResult.getAllErrors().get(0).getDefaultMessage());
//			return ResponseHandler.generateValidationResponse(bindingResult.getAllErrors().get(0).getDefaultMessage());
//		}
//		return ResponseHandler.generateControllerResponse(customerServiceHelper.saveCustomer(customerForm));
//	}
//
//	/**
//	 * This api end point is used to update {@link CustomerSupplier}
//	 * 
//	 * @param customerIdModel {@link CustomerIdModel}
//	 * @param customerForm    {@link CustomerForm}
//	 * @param bindingResult   {@link BindingResult}
//	 * @return {@link ResponseEntity} of {@link ResponseDTO}
//	 */
//	@PutMapping(value = ApiUrl.UPDATE_CUSTOMER)
//	public ResponseEntity<ResponseDTO> updateCustomer(
//			@Validated(value = ValidateSequence.class) @ModelAttribute CustomerIdModel customerIdModel,
//			BindingResult bindingResult1,
//			@Validated(value = ValidateSequence.class) @RequestBody CustomerForm customerForm,
//			BindingResult bindingResult2) {
//		if (bindingResult1.hasErrors()) {
//			LOGGER.error(
//					"Validation failed while updating customer for field {} with rejected value {} with message {} ",
//					bindingResult1.getFieldError().getField(), bindingResult1.getFieldError().getRejectedValue(),
//					bindingResult1.getAllErrors().get(0).getDefaultMessage());
//			return ResponseHandler.generateValidationResponse(bindingResult1.getAllErrors().get(0).getDefaultMessage());
//		}
//		if (bindingResult2.hasErrors()) {
//			LOGGER.error(
//					"Validation failed while updating customer for field {} with rejected value {} with message {} ",
//					bindingResult2.getFieldError().getField(), bindingResult2.getFieldError().getRejectedValue(),
//					bindingResult2.getAllErrors().get(0).getDefaultMessage());
//			return ResponseHandler.generateValidationResponse(bindingResult2.getAllErrors().get(0).getDefaultMessage());
//		}
//		return ResponseHandler.generateControllerResponse(
//				customerServiceHelper.updateCustomer(customerIdModel.getCustomerId(), customerForm));
//	}
//
//	/**
//	 * This api end point is used to add {@link Brand}.
//	 * 
//	 * @param addBrandForm  {@link AddBrandForm}
//	 * @param bindingResult {@link BindingResult}
//	 * @return {@link ResponseEntity} of {@link ResponseDTO}
//	 */
//	@PostMapping(value = ApiUrl.ADD_BRAND)
//	public ResponseEntity<ResponseDTO> addBrand(
//			@Validated(value = ValidateSequence.class) @ModelAttribute CustomerIdModel customerIdModel,
//			BindingResult bindingResult1,
//			@Validated(value = ValidateSequence.class) @RequestBody AddBrandForm addBrandForm,
//			BindingResult bindingResult2) {
//		if (bindingResult1.hasErrors()) {
//			LOGGER.error("Validation failed while adding brand for field {} with rejected value {} with message {} ",
//					bindingResult1.getFieldError().getField(), bindingResult1.getFieldError().getRejectedValue(),
//					bindingResult1.getAllErrors().get(0).getDefaultMessage());
//			return ResponseHandler.generateValidationResponse(bindingResult1.getAllErrors().get(0).getDefaultMessage());
//		}
//		if (bindingResult2.hasErrors()) {
//			LOGGER.error("Validation failed while adding brand for field {} with rejected value {} with message {} ",
//					bindingResult2.getFieldError().getField(), bindingResult2.getFieldError().getRejectedValue(),
//					bindingResult2.getAllErrors().get(0).getDefaultMessage());
//			return ResponseHandler.generateValidationResponse(bindingResult2.getAllErrors().get(0).getDefaultMessage());
//		}
//		return ResponseHandler.generateControllerResponse(
//				customerServiceHelper.addBrands(customerIdModel.getCustomerId(), addBrandForm));
//	}
//
//	/**
//	 * This api end point is used to get all {@link Brand}
//	 * 
//	 * @param customerIdModel {@link CustomerIdModel}
//	 * @param bindingResult   {@link BindingResult}
//	 * @return {@link ResponseEntity} of {@link ResponseDTO}
//	 */
//	@GetMapping(value = ApiUrl.GET_ALL_BRANDS)
//	public ResponseEntity<ResponseDTO> getAllBrands(
//			@Validated(value = ValidateSequence.class) @ModelAttribute CustomerIdModel customerIdModel,
//			BindingResult bindingResult) {
//		if (bindingResult.hasErrors()) {
//			LOGGER.error(
//					"Validation failed while getting all brands for field {} with rejected value {} with message {} ",
//					bindingResult.getFieldError().getField(), bindingResult.getFieldError().getRejectedValue(),
//					bindingResult.getAllErrors().get(0).getDefaultMessage());
//			return ResponseHandler.generateValidationResponse(bindingResult.getAllErrors().get(0).getDefaultMessage());
//		}
//		return ResponseHandler
//				.generateControllerResponse(customerServiceHelper.getAllBrands(customerIdModel.getCustomerId()));
//	}
//
//	/**
//	 * This api end point is used to deactivate {@link CustomerSupplier}
//	 * 
//	 * @param customerIdModel {@link CustomerIdModel}
//	 * @param bindingResult   {@link BindingResult}
//	 * @return {@link ResponseEntity} of {@link ResponseDTO}
//	 */
//	@PutMapping(value = ApiUrl.DEACTIVATE_CUSTOMER)
//	public ResponseEntity<ResponseDTO> deActivateCustomer(
//			@Validated(value = ValidateSequence.class) @RequestBody CustomerIdModel customerIdModel,
//			BindingResult bindingResult) {
//		if (bindingResult.hasErrors()) {
//			LOGGER.error(
//					"Validation failed while deactivating customer for field {} with rejected value {} with message {} ",
//					bindingResult.getFieldError().getField(), bindingResult.getFieldError().getRejectedValue(),
//					bindingResult.getAllErrors().get(0).getDefaultMessage());
//			return ResponseHandler.generateValidationResponse(bindingResult.getAllErrors().get(0).getDefaultMessage());
//		}
//		return ResponseHandler
//				.generateControllerResponse(customerServiceHelper.deActivateCustomer(customerIdModel.getCustomerId()));
//	}
//
//	/**
//	 * This api end point is used to activate {@link CustomerSupplier}
//	 * 
//	 * @param customerIdModel {@link CustomerIdModel}
//	 * @param bindingResult   {@link BindingResult}
//	 * @return {@link ResponseEntity} of {@link ResponseDTO}
//	 */
//	@PutMapping(value = ApiUrl.ACTIVATE_CUSTOMER)
//	public ResponseEntity<ResponseDTO> activateCustomer(
//			@Validated(value = ValidateSequence.class) @RequestBody CustomerIdModel customerIdModel,
//			BindingResult bindingResult) {
//		if (bindingResult.hasErrors()) {
//			LOGGER.error(
//					"Validation failed while activating customer for field {} with rejected value {} with message {} ",
//					bindingResult.getFieldError().getField(), bindingResult.getFieldError().getRejectedValue(),
//					bindingResult.getAllErrors().get(0).getDefaultMessage());
//			return ResponseHandler.generateValidationResponse(bindingResult.getAllErrors().get(0).getDefaultMessage());
//		}
//		return ResponseHandler
//				.generateControllerResponse(customerServiceHelper.activateCustomer(customerIdModel.getCustomerId()));
//	}
//
//	/**
//	 * This api end point is used to delete {@link Brand}
//	 * 
//	 * @param brandIdModel  {@link BrandIdModel}
//	 * @param bindingResult {@link BindingResult}
//	 * @return {@link ResponseEntity} of {@link ResponseDTO}
//	 */
//	@DeleteMapping(value = ApiUrl.DELETE_BRAND)
//	public ResponseEntity<ResponseDTO> deleteBrand(
//			@Validated(value = ValidateSequence.class) @ModelAttribute BrandIdModel brandIdModel,
//			BindingResult bindingResult) {
//		if (bindingResult.hasErrors()) {
//			LOGGER.error("Validation failed while deleting brand for field {} with rejected value {} with message {} ",
//					bindingResult.getFieldError().getField(), bindingResult.getFieldError().getRejectedValue(),
//					bindingResult.getAllErrors().get(0).getDefaultMessage());
//			return ResponseHandler.generateValidationResponse(bindingResult.getAllErrors().get(0).getDefaultMessage());
//		}
//		return ResponseHandler
//				.generateControllerResponse(customerServiceHelper.deleteBrand(brandIdModel.getBranchId()));
//	}
//	
//	@GetMapping(value = ApiUrl.GET_FACTORY_CUSTOMERS)
//	public ResponseEntity<ResponseDTO> getcustomers(
//			@Validated(value = ValidateSequence.class) @ModelAttribute FactoryIdModel factoryIdModel,
//			BindingResult bindingResult) {
//		if (bindingResult.hasErrors()) {
//			LOGGER.error("Validation failed while deleting brand for field {} with rejected value {} with message {} ",
//					bindingResult.getFieldError().getField(), bindingResult.getFieldError().getRejectedValue(),
//					bindingResult.getAllErrors().get(0).getDefaultMessage());
//			return ResponseHandler.generateValidationResponse(bindingResult.getAllErrors().get(0).getDefaultMessage());
//		}
//		return ResponseHandler
//				.generateControllerResponse(customerServiceHelper.getcustomers(factoryIdModel.getFactoryId()));
//	}
//	
//	@GetMapping(value = ApiUrl.GET_COMPANY_CUSTOMERS)
//	public ResponseEntity<ResponseDTO> getAllcustomers(
//			@Validated(value = ValidateSequence.class) @ModelAttribute FactoryIdModel factoryIdModel,
//			BindingResult bindingResult) {
//		return ResponseHandler
//				.generateControllerResponse(customerServiceHelper.getcustomers(factoryIdModel.getFactoryId()));
//	}
//}
