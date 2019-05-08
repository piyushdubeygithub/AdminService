package com.prosmv.annotations.user;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.prosmv.config.context.SpringContext;
import com.prosmv.service.validation.ValidationService;

/**
 * This class is an implementation of {@link IsUserAlreadyExist}.
 * @author piyush
 *
 */
public class IsUserAlreadyExistImplementation implements ConstraintValidator<IsUserAlreadyExist, Long>{

	private ValidationService validationService = (ValidationService) SpringContext.getBean(ValidationService.class);

	@Override
	public boolean isValid(Long userId, ConstraintValidatorContext context) {
		return validationService.isUserAlreadyExist(userId);
	}
	
}
