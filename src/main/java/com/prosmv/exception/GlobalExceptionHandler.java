package com.prosmv.exception;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.prosmv.dto.response.ResponseDTO;
import com.prosmv.util.ResponseHandler;

/**
 * This class is global exception handler class.
 * 
 * @author piyush
 *
 */

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

	private static final Logger LOGGER = LoggerFactory.getLogger(GlobalExceptionHandler.class);

	/**
	 * This method will handle the {@link Exception}
	 * 
	 * @param ex      {@link Exception}
	 * @param request {@link HttpServletRequest}
	 * @return {@link ResponseEntity} of {@link ResponseDTO}
	 */
	@ExceptionHandler(Exception.class)
	public final ResponseEntity<ResponseDTO> handleAllExceptions(Exception ex, HttpServletRequest request) {
		ex.printStackTrace();
		LOGGER.error("Exception message is {} ", ex.getMessage());
		return ResponseHandler.generateExceptionResponse(ex);
	}

	/**
	 * This method will handle the {@link CompanyException}.
	 * 
	 * @param exception {@link Exception}
	 * @return {@link ResponseEntity} of {@link ResponseDTO}
	 */
	@ExceptionHandler(CompanyException.class)
	public final ResponseEntity<ResponseDTO> handleCompanyException(Exception exception) {
		LOGGER.error("Exception message is {} ", exception.getMessage());
		return ResponseHandler.generateExceptionResponse(exception);
	}

	/**
	 * This method will handle the {@link FactoryException}.
	 * 
	 * @param exception {@link Exception}
	 * @return {@link ResponseEntity} of {@link ResponseDTO}
	 */
	@ExceptionHandler(FactoryException.class)
	public final ResponseEntity<ResponseDTO> handleFactoryException(Exception exception) {
		LOGGER.error("Exception message is {} ", exception.getMessage());
		return ResponseHandler.generateExceptionResponse(exception);
	}

	/**
	 * This method will handle the {@link CustomerException}.
	 * 
	 * @param exception {@link Exception}
	 * @return {@link ResponseEntity} of {@link ResponseDTO}
	 */
	@ExceptionHandler(CustomerException.class)
	public final ResponseEntity<ResponseDTO> handleCustomerExeption(Exception exception) {
		LOGGER.error("Exception message is {} ", exception.getMessage());
		return ResponseHandler.generateExceptionResponse(exception);
	}

	/**
	 * This method will handle the {@link DesignationException}.
	 * 
	 * @param exception {@link Exception}
	 * @return {@link ResponseEntity} of {@link ResponseDTO}
	 */
	@ExceptionHandler(DesignationException.class)
	public final ResponseEntity<ResponseDTO> handleDesignationException(Exception exception) {
		LOGGER.error("Exception message is {} ", exception.getMessage());
		return ResponseHandler.generateExceptionResponse(exception);
	}

	/**
	 * This method will handle the {@link ImageUploadException}.
	 * 
	 * @param exception {@link Exception}
	 * @return {@link ResponseEntity} of {@link ResponseDTO}
	 */
	@ExceptionHandler(ImageUploadException.class)
	public final ResponseEntity<ResponseDTO> handleImageUploadException(Exception exception) {
		LOGGER.error("Exception message is {} ", exception.getMessage());
		return ResponseHandler.generateExceptionResponse(exception);
	}

	/**
	 * This method will handle the {@link UserException}.
	 * 
	 * @param exception {@link Exception}
	 * @return {@link ResponseEntity} of {@link ResponseDTO}
	 */
	@ExceptionHandler(UserException.class)
	public final ResponseEntity<ResponseDTO> handleUserException(Exception exception) {
		LOGGER.error("Exception message is {} ", exception.getMessage());
		return ResponseHandler.generateExceptionResponse(exception);
	}

	/**
	 * This method will handle the {@link PermissionException}.
	 * 
	 * @param exception {@link Exception}
	 * @return {@link ResponseEntity} of {@link ResponseDTO}
	 */
	@ExceptionHandler(PermissionException.class)
	public final ResponseEntity<ResponseDTO> handlePermissionException(Exception exception) {
		LOGGER.error("Exception message is {} ", exception.getMessage());
		return ResponseHandler.generateExceptionResponse(exception);
	}
}
