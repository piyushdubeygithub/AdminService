package com.prosmv.annotations.user;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.prosmv.config.context.SpringContext;
import com.prosmv.service.validation.ValidationService;

/**
 * This class is an implementation of {@link IsUserNameAlreadyExist}.
 * 
 * @author piyush
 *
 */
public class IsUserNameAlreadyExistImplementation implements ConstraintValidator<IsUserNameAlreadyExist, String> {

	private ValidationService validationService = (ValidationService) SpringContext.getBean(ValidationService.class);

	@Override
	public boolean isValid(String userName, ConstraintValidatorContext context) {
		return !validationService.isUserNameAlreadyExist(userName);
	}

}
