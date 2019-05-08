package com.prosmv.annotations.company;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.prosmv.config.context.SpringContext;
import com.prosmv.service.validation.ValidationService;

public class IsCompanyEmailAlreadyExistImplementation
		implements ConstraintValidator<IsCompanyEmailAlreadyExist, String> {

	private ValidationService validationService = (ValidationService) SpringContext.getBean(ValidationService.class);

	@Override
	public boolean isValid(String email, ConstraintValidatorContext context) {
		return !validationService.isCompanyEmailAlreadyExist(email);
	}

}
