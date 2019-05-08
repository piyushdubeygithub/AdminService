package com.prosmv.service.message;

import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

/**
 * This class is service class is used for message handling with there message
 * source and properties file and can also be used for internationalization.
 * 
 * @author piyush
 *
 */
@Service
public class MessageService {

	private static final Logger LOGGER = LoggerFactory.getLogger(MessageService.class);

	@Autowired
	@Qualifier("validationMessageSource")
	private MessageSource validationMessageSource;

	@Autowired
	@Qualifier("errorCodeMessageSource")
	private MessageSource errorCodeMessageSource;

	@Autowired
	@Qualifier("serviceMessageSource")
	private MessageSource serviceMessageSource;

	/**
	 * This method will return the validation message.
	 * 
	 * @param validationMessageCode validationMessageCode
	 * @return validation message from validationmessage_en.properties
	 */
	public String getValidationMessage(String validationMessageCode) {

		return validationMessageSource.getMessage(validationMessageCode, null, new Locale("en"));

	}

	/**
	 * This method will return the error code
	 * 
	 * @param errorCode error code key
	 * @return error code from errorcode_en.properties
	 */
	public String getErrorCode(String errorCode) {

		return errorCodeMessageSource.getMessage(errorCode, null, new Locale("en"));

	}

	/**
	 * This method will return the service message.
	 * 
	 * @param serviceMessageCode        service message code
	 * @param serviceMessageDynamicData service message dynamic data
	 * @return service message from servicemessage_en.properties
	 */
	public String getServiceMessage(String serviceMessageCode, Object[] serviceMessageDynamicData) {

		return serviceMessageSource.getMessage(serviceMessageCode, serviceMessageDynamicData, new Locale("en"));

	}

}
