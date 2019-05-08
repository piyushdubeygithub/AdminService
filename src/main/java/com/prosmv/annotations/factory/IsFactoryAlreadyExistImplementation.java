package com.prosmv.annotations.factory;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.prosmv.config.context.SpringContext;
import com.prosmv.service.validation.ValidationService;

/**
 * This class is an implementation of {@link IsFactoryAlreadyExist}.
 * 
 * @author piyush
 *
 */
public class IsFactoryAlreadyExistImplementation implements ConstraintValidator<IsFactoryAlreadyExist, Long> {

	private ValidationService validationService = (ValidationService) SpringContext.getBean(ValidationService.class);

	@Override
	public boolean isValid(Long factoryId, ConstraintValidatorContext context) {
		return validationService.isFactoryAlreadyExist(factoryId);
	}

}
