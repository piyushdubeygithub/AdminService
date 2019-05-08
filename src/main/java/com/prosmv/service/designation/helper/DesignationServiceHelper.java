package com.prosmv.service.designation.helper;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.prosmv.constants.message.ServiceMessageCode;
import com.prosmv.domain.Designation;
import com.prosmv.dto.DesignationDTO;
import com.prosmv.dto.response.ResponseDTO;
import com.prosmv.exception.DesignationException;
import com.prosmv.form.DesignationForm;
import com.prosmv.service.designation.DesignationService;
import com.prosmv.util.ResponseHandler;

/**
 * This helper class is a layer to use all the services related to
 * {@link DesignationService} and return the response regarding the service.
 * 
 * @author piyush
 *
 */
@Service
public class DesignationServiceHelper {

	private static final Logger LOGGER = LoggerFactory.getLogger(DesignationServiceHelper.class);

	@Autowired
	private DesignationService designationService;

	/**
	 * This helper method is used to access service to delete {@link Designation}.
	 * 
	 * @param designationId id of {@link Designation}
	 * @return {@link ResponseDTO}
	 */
	public ResponseDTO deleteDesignation(Long designationId) {
		try {
			designationService.deleteDesignation(designationId);
		} catch (Exception e) {
			throw new DesignationException(ServiceMessageCode.UNABLE_TO_DELETE_DESIGNATION);
		}
		return ResponseHandler.generateServiceResponse(null, ServiceMessageCode.DESIGNATION_DELETED_SUCCESSFULLY, null,
				true, HttpStatus.OK);
	}

	/**
	 * This helper method is used to access service to get all {@link Designation}.
	 * 
	 * @return {@link ResponseDTO}
	 */
	public ResponseDTO getAllDesignations() {
		List<DesignationDTO> designationDTOs = designationService.getAllDesignations();
		if (designationDTOs.isEmpty()) {
			return ResponseHandler.generateServiceResponse(null, ServiceMessageCode.NO_DESIGNATION_CREATED_YET, null,
					true, HttpStatus.OK);
		}
		return ResponseHandler.generateServiceResponse(designationDTOs,
				ServiceMessageCode.DESIGNATION_LIST_FETCHED_SUCCESSFULLY, null, true, HttpStatus.OK);
	}

	/**
	 * This helper method is used to access {@link DesignationService} to update
	 * {@link Designation}.
	 * 
	 * @param designationId   id of {@link Designation} to be updated
	 * @param designationForm {@link DesignationForm}
	 * @return {@link ResponseDTO}
	 */
	public ResponseDTO updateDesignation(Long designationId, DesignationForm designationForm) {
		try {
			designationService.updateDesignation(designationForm);
			return ResponseHandler.generateServiceResponse(null, ServiceMessageCode.DESIGNATION_UPDATED_SUCCESSFULLY,
					null, true, HttpStatus.OK);
		} catch (Exception e) {
			throw new DesignationException(ServiceMessageCode.UNABLE_TO_UPDATE_DESIGNATION);
		}
	}

	/**
	 * This helper method is used to access {@link DesignationService} to create
	 * {@link Designation}.
	 * 
	 * @param designationForm {@link DesignationForm}
	 * @return {@link ResponseDTO}
	 */
	public ResponseDTO createDesignation(DesignationForm designationForm) {
		try {
			designationService.createDesignation(designationForm);
			return ResponseHandler.generateServiceResponse(null, ServiceMessageCode.DESIGNATION_CREATED_SUCCESSFULLY,
					null, true, HttpStatus.OK);
		} catch (Exception e) {
			throw new DesignationException(ServiceMessageCode.UNABLE_TO_CREATE_DESIGNATION);
		}
	}

}
