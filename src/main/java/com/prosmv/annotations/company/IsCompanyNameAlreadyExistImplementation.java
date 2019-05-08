package com.prosmv.annotations.company;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.prosmv.config.context.SpringContext;
import com.prosmv.service.validation.ValidationService;

/**
 * This class is an implementation to {@link IsCompanyNameAlreadyExist}.
 * @author piyush
 *
 */
public class IsCompanyNameAlreadyExistImplementation implements ConstraintValidator<IsCompanyNameAlreadyExist, String> {

	private ValidationService validationService = (ValidationService) SpringContext.getBean(ValidationService.class);

	@Override
	public boolean isValid(String companyName, ConstraintValidatorContext context) {
		return !validationService.isComapnyNameAlreadyExist(companyName);
	}

}
