package com.prosmv.config.message;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;

/**
 * This class is configuration class used to configure the message source with
 * there properties file accordingly.
 * 
 * @author piyush
 *
 */
@Configuration
public class MessageConfig {

	private static final Logger LOGGER = LoggerFactory.getLogger(MessageConfig.class);

	/**
	 * This message source will be used for validation messages handling.
	 * 
	 * @return validation {@link MessageSource}
	 */
	@Bean
	public MessageSource validationMessageSource() {

		ResourceBundleMessageSource resourceBundleMessageSource = new ResourceBundleMessageSource();

		resourceBundleMessageSource.setCacheMillis(3600);

		resourceBundleMessageSource.setBasename("locale/validationmessage");

		resourceBundleMessageSource.setDefaultEncoding("UTF-8");

		resourceBundleMessageSource.setUseCodeAsDefaultMessage(true);

		return resourceBundleMessageSource;

	}

	/**
	 * This message source will be used for error code handling.
	 * 
	 * @return error code {@link MessageSource}
	 */
	@Bean
	public MessageSource errorCodeMessageSource() {

		ResourceBundleMessageSource resourceBundleMessageSource = new ResourceBundleMessageSource();

		resourceBundleMessageSource.setCacheMillis(3600);

		resourceBundleMessageSource.setBasename("locale/errorcode");

		resourceBundleMessageSource.setDefaultEncoding("UTF-8");

		resourceBundleMessageSource.setUseCodeAsDefaultMessage(true);

		return resourceBundleMessageSource;

	}

	/**
	 * This message source will be used for service message handling.
	 * 
	 * @return service {@link MessageSource}
	 */
	@Bean
	public MessageSource serviceMessageSource() {

		ResourceBundleMessageSource resourceBundleMessageSource = new ResourceBundleMessageSource();

		resourceBundleMessageSource.setCacheMillis(3600);

		resourceBundleMessageSource.setBasename("locale/servicemessage");

		resourceBundleMessageSource.setDefaultEncoding("UTF-8");

		resourceBundleMessageSource.setUseCodeAsDefaultMessage(true);

		return resourceBundleMessageSource;

	}

}
