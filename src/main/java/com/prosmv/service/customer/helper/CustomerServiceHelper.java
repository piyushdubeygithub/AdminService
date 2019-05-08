package com.prosmv.service.customer.helper;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.prosmv.constants.message.ServiceMessageCode;
import com.prosmv.domain.Brand;
import com.prosmv.domain.CustomerSupplier;
import com.prosmv.dto.BrandDTO;
import com.prosmv.dto.CustomerDTO;
import com.prosmv.dto.response.ResponseDTO;
import com.prosmv.exception.CustomerException;
import com.prosmv.form.AddBrandForm;
import com.prosmv.form.CustomerForm;
import com.prosmv.service.customer.CustomerService;
import com.prosmv.util.ResponseHandler;

/**
 * This Service class is used for Customer service responses send to controller.
 * 
 * @author piyush
 *
 */
@Service
public class CustomerServiceHelper {

	private static final Logger LOGGER = LoggerFactory.getLogger(CustomerServiceHelper.class);

	@Autowired
	private CustomerService customerService;

	/**
	 * This helper method will access the service to create {@link CustomerSupplier}
	 * 
	 * @param customerForm
	 *            {@link CustomerForm}
	 * @return {@link ResponseDTO}
	 */
	public ResponseDTO saveCustomer(CustomerForm customerForm) {
		LOGGER.info("creating a new customer with details {} ", customerForm.toString());
		try {
			customerService.saveCustomer(customerForm);
			LOGGER.info("customer has been created successfully");
			return ResponseHandler.generateServiceResponse(null, ServiceMessageCode.CUSTOMER_CREATED_SUCCESSFULLY, null,
					true, HttpStatus.OK);
		} catch (Exception e) {
			LOGGER.error("Exception has been occures while creating customer");
			throw new CustomerException(ServiceMessageCode.UNABLE_TO_CREATE_CUSTOMER);
		}
	}

	/**
	 * This helper method will access the service to update {@link CustomerSupplier}
	 * 
	 * @param customerId
	 *            id of {@link CustomerSupplier}
	 * @param customerForm
	 *            {@link CustomerForm}
	 * @return {@link ResponseDTO}
	 */
	public ResponseDTO updateCustomer(Long customerId, CustomerForm customerForm) {
		try {
			customerService.updateCustomer(customerForm);
			return ResponseHandler.generateServiceResponse(null, ServiceMessageCode.CUSTOMER_UPDATED_SUCCESSFULLY, null,
					true, HttpStatus.OK);
		} catch (Exception e) {
			throw new CustomerException(ServiceMessageCode.UNABLE_TO_UPDATE_CUSTOMER);
		}
	}

	/**
	 * This helper method is used to access the service to add {@link Brand}
	 * 
	 * @param addBrandForm
	 *            {@link AddBrandForm}
	 * @return {@link ResponseDTO}
	 */
	public ResponseDTO addBrands(Long customerId, AddBrandForm addBrandForm) {
		try {
			customerService.addBrand(customerId, addBrandForm.getBrandName());
		} catch (Exception e) {
			throw new CustomerException(ServiceMessageCode.UNABLE_TO_ADD_BRAND);
		}
		return ResponseHandler.generateServiceResponse(null, ServiceMessageCode.BRAND_ADDED_SUCCESSFULLY, null, true,
				HttpStatus.OK);
	}

	/**
	 * This helper method is used to access service to get all {@link Brand}
	 * 
	 * @param customerId
	 *            id of {@link CustomerSupplier}
	 * @return {@link ResponseDTO}
	 */
	public ResponseDTO getAllBrands(Long customerId) {
		List<BrandDTO> brandDTOs = customerService.getAllBrands(customerId);
		if (brandDTOs.isEmpty()) {
			return ResponseHandler.generateServiceResponse(null, ServiceMessageCode.NO_BRAND_CREATED_YET, null, true,
					HttpStatus.OK);
		}
		return ResponseHandler.generateServiceResponse(brandDTOs, ServiceMessageCode.BRAND_LIST_FETCHED_SUCCESSFULLY,
				null, true, HttpStatus.OK);
	}

	/**
	 * This helper method is used to access service to de activate
	 * {@link CustomerSupplier}
	 * 
	 * @param customerId
	 *            id of {@link CustomerSupplier}
	 * @return {@link ResponseDTO}
	 */
	public ResponseDTO deActivateCustomer(Long customerId) {
		try {
			customerService.deActivateCustomer(customerId);
		} catch (Exception e) {
			throw new CustomerException(ServiceMessageCode.UNABLE_TO_DEACTIVATE_CUSTOMER);
		}
		return ResponseHandler.generateServiceResponse(null, ServiceMessageCode.CUSTOMER_DEACTIVATED_SUCCESSFULLY, null,
				true, HttpStatus.OK);
	}

	/**
	 * This helper method is used for access service to activate
	 * {@link CustomerSupplier}
	 * 
	 * @param customerId
	 *            id of {@link CustomerSupplier}
	 * @return {@link ResponseDTO}
	 */
	public ResponseDTO activateCustomer(Long customerId) {
		try {
			customerService.activateCustomer(customerId);
		} catch (Exception e) {
			throw new CustomerException(ServiceMessageCode.UNABLE_TO_ACTIVATE_CUSTOMER);
		}
		return ResponseHandler.generateServiceResponse(null, ServiceMessageCode.CUSTOMER_ACTIVATED_SUCCESSFULLY, null,
				true, HttpStatus.OK);
	}

	/**
	 * This helper method is used to access service to delete {@link Brand}
	 * 
	 * @param brandId
	 *            id of {@link Brand}
	 * @return {@link ResponseDTO}
	 */
	public ResponseDTO deleteBrand(Long brandId) {
		try {
			customerService.deleteBrand(brandId);
		} catch (Exception e) {
			throw new CustomerException(ServiceMessageCode.UNABLE_TO_DELETE_BRAND);
		}
		return ResponseHandler.generateServiceResponse(null, ServiceMessageCode.BRAND_DELETED_SUCCESSFULLY, null, true,
				HttpStatus.OK);
	}

	public ResponseDTO getcustomers(Long factoryId) {
		List<CustomerDTO> customers = customerService.getcustomers(factoryId);
		return ResponseHandler.generateServiceResponse(customers, ServiceMessageCode.BRAND_LIST_FETCHED_SUCCESSFULLY,
				null, true, HttpStatus.OK);
	}

}
