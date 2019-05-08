package com.prosmv.service.factory.helper;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.prosmv.constants.message.ServiceMessageCode;
import com.prosmv.domain.Company;
import com.prosmv.domain.Factory;
import com.prosmv.dto.AutoCompleteFactoryDTO;
import com.prosmv.dto.CompanyDTO;
import com.prosmv.dto.FactoryDTO;
import com.prosmv.dto.response.ResponseDTO;
import com.prosmv.exception.FactoryException;
import com.prosmv.form.FactoryForm;
import com.prosmv.form.UpdateFactoryForm;
import com.prosmv.service.factory.FactoryService;
import com.prosmv.util.ResponseHandler;

/**
 * This helper service is used to access {@link FactoryService} and return the
 * response accordingly.
 * 
 * @author piyush
 *
 */
@Service
public class FactoryServiceHelper {

	private static final Logger LOGGER = LoggerFactory.getLogger(FactoryServiceHelper.class);

	@Autowired
	private FactoryService factoryService;

	/**
	 * This helper method is used to access service to delete {@link Factory}.
	 * 
	 * @param factoryId
	 *            id of {@link Factory}
	 * @return {@link ResponseDTO}
	 */
	public ResponseDTO deleteFactory(Long factoryId) {
		try {
			factoryService.deleteFactory(factoryId);
		} catch (Exception e) {
			throw new FactoryException(ServiceMessageCode.UNABLE_TO_DELETE_FACTORY);
		}
		return ResponseHandler.generateServiceResponse(null, ServiceMessageCode.FACTORY_DELETED_SUCCESSFULLY, null,
				true, HttpStatus.OK);
	}

	/**
	 * This helper method is used to access service to set {@link Factory} status.
	 * 
	 * @param factoryId
	 *            id of {@link Factory}
	 * @param isActive
	 *            {@code true} or {@code false}
	 * @return {@link ResponseDTO}
	 */
	public ResponseDTO setFactoryStatus(Long factoryId, boolean isActive) {
		try {
			factoryService.setFactoryStatus(factoryId, isActive);
		} catch (Exception e) {
			throw new FactoryException(ServiceMessageCode.UNABLE_TO_SET_FACTORY_STATUS);
		}
		return ResponseHandler.generateServiceResponse(null, ServiceMessageCode.FACTORY_STATUS_SET_SUCCESSFULLY, null,
				true, HttpStatus.OK);
	}

	/**
	 * This helper method is used to access service to activate {@link Factory}.
	 * 
	 * @param factoryId
	 *            id of {@link Factory}
	 * @return {@link ResponseDTO}
	 */
	public ResponseDTO activateFactory(Long factoryId) {
		try {
			factoryService.activateFactory(factoryId);
		} catch (Exception e) {
			throw new FactoryException(ServiceMessageCode.UNABLE_TO_ACTIVATE_FACTORY);
		}
		return ResponseHandler.generateServiceResponse(null, ServiceMessageCode.FACTORY_ACTIVATED_SUCCESSFULLY, null,
				true, HttpStatus.OK);
	}

	/**
	 * This helper method is used to access service to de activate {@link Factory}.
	 * 
	 * @param factoryId
	 *            id of {@link Factory}
	 * @return {@link ResponseDTO}
	 */
	public ResponseDTO deActivateFactory(Long factoryId) {
		try {
			factoryService.deActivateFactory(factoryId);
		} catch (Exception e) {
			throw new FactoryException(ServiceMessageCode.UNABLE_TO_DEACTIVATE_FACTORY);
		}
		return ResponseHandler.generateServiceResponse(null, ServiceMessageCode.FACTORY_DEACTIVATED_SUCCESSFULLY, null,
				true, HttpStatus.OK);
	}

	/**
	 * This helper method is used to access service to get all {@link Factory}.
	 * 
	 * @return {@link ResponseDTO}
	 */
	public ResponseDTO getFactoryList() {
		List<FactoryDTO> factoryDTOs = factoryService.getFactoryList();
		if (factoryDTOs.isEmpty()) {
			return ResponseHandler.generateServiceResponse(null, ServiceMessageCode.NO_FACTORY_CREATED_YET, null, true,
					HttpStatus.OK);
		}
		return ResponseHandler.generateServiceResponse(factoryDTOs,
				ServiceMessageCode.FACTORY_LIST_FETCHED_SUCCESSFULLY, null, true, HttpStatus.OK);
	}

	/**
	 * This helper method is used to access service to create {@link Factory}.
	 * 
	 * @param factoryForm
	 *            {@link FactoryForm}
	 * @return {@link ResponseDTO}
	 */
	public ResponseDTO saveFactory(FactoryForm factoryForm) {
		try {
			factoryService.saveFactory(factoryForm);
			return ResponseHandler.generateServiceResponse(null, ServiceMessageCode.FACTORY_CREATED_SUCCESSFULLY, null,
					true, HttpStatus.OK);
		} catch (Exception e) {
			throw new FactoryException(ServiceMessageCode.UNABLE_TO_CREATE_FACTORY);
		}
	}

	/**
	 * This helper method is used to access service to update {@link Factory}.
	 * 
	 * @param factoryId
	 *            id of {@link Factory}
	 * @param factoryForm
	 *            {@link FactoryForm}
	 * @return {@link ResponseDTO}
	 */
	public ResponseDTO updateFactory(UpdateFactoryForm factoryForm) {
		try {
			factoryService.updateFactory(factoryForm);
			return ResponseHandler.generateServiceResponse(null, ServiceMessageCode.FACTORY_UPDATED_SUCCESSFULLY, null,
					true, HttpStatus.OK);
		} catch (Exception e) {
			throw new FactoryException(ServiceMessageCode.UNABLE_TO_UPDATE_FACTORY);
		}
	}

	private Factory getFactoryByFactoryForm(FactoryForm factoryForm) {
		Factory factory = new Factory();
		return factory;
	}

	/**
	 * This helper method is used to access auto complete factory.
	 * 
	 * @param factoryName
	 *            name of {@link Factory}
	 * @return {@link ResponseDTO}
	 */
	public ResponseDTO getAutoCompleteFactory(String factoryName) {
		List<AutoCompleteFactoryDTO> autoCompleteFactoryDTOs = factoryService.getAutoCompleteFactory(factoryName);
		if (autoCompleteFactoryDTOs.isEmpty()) {
			return ResponseHandler.generateServiceResponse(null, ServiceMessageCode.NO_AUTO_COMPLETE_FACTORY_AVAILABLE,
					null, true, HttpStatus.OK);
		}
		return ResponseHandler.generateServiceResponse(autoCompleteFactoryDTOs,
				ServiceMessageCode.AUTO_COMPLETE_FACTORY_FOUND_SUCCESSFULLY, null, true, HttpStatus.OK);
	}

	public ResponseDTO getFactoryListByCompany(Long companyId) {
		List<FactoryDTO> factoryDTOs = factoryService.getFactoryListByCompany(companyId);
		if (factoryDTOs.isEmpty()) {
			return ResponseHandler.generateServiceResponse(null, ServiceMessageCode.NO_FACTORY_CREATED_YET, null, true,
					HttpStatus.OK);
		}
		return ResponseHandler.generateServiceResponse(factoryDTOs,
				ServiceMessageCode.FACTORY_LIST_FETCHED_SUCCESSFULLY, null, true, HttpStatus.OK);
	}

	public ResponseDTO getCompanyByFactory(Long factoryId) {
		CompanyDTO company = factoryService.getCompanyByFactory(factoryId);
		return ResponseHandler.generateServiceResponse(company,
				ServiceMessageCode.FACTORY_LIST_FETCHED_SUCCESSFULLY, null, true, HttpStatus.OK);
	}

}
