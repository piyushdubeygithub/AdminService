package com.prosmv.config.context;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * This class is used as component to get the object of spring bean in non
 * spring bean using {@link ApplicationContextAware}
 * 
 * @author piyush
 *
 */
@Component
public class SpringContext implements ApplicationContextAware {

	private static ApplicationContext applicationContext;

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {

		SpringContext.applicationContext = applicationContext;

	}

	/**
	 * This method will return the bean object using applicationcontext.
	 * 
	 * @param className name of class for which the object is required.
	 * @return {@link Object}
	 */
	public static <T> Object getBean(Class<T> className) {

		return applicationContext.getBean(className);

	}

}
