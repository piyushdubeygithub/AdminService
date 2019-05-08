package com.prosmv.annotations.factory;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.prosmv.config.context.SpringContext;
import com.prosmv.service.validation.ValidationService;

/**
 * This class is an implementation of {@link IsFactoryNameAlreadyExist}.
 * 
 * @author piyush
 *
 */
public class IsFactoryNameAlreadyExistImplementation implements ConstraintValidator<IsFactoryNameAlreadyExist, String> {

	private ValidationService validationService = (ValidationService) SpringContext.getBean(ValidationService.class);

	@Override
	public boolean isValid(String factoryName, ConstraintValidatorContext context) {
		return !validationService.isFactoryNameAlreadyExist(factoryName);
	}

}
