package com.prosmv.annotations.customer;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.prosmv.config.context.SpringContext;
import com.prosmv.service.validation.ValidationService;

/**
 * This class is an implementation of {@link IsCustomerNameAlreadyExist}.
 * 
 * @author piyush
 *
 */
public class IsCustomerNameAlreadyExistImplementation
		implements ConstraintValidator<IsCustomerNameAlreadyExist, String> {

	private ValidationService validationService = (ValidationService) SpringContext.getBean(ValidationService.class);

	@Override
	public boolean isValid(String customerName, ConstraintValidatorContext context) {
		return !validationService.isCustomerNameAlreadyExist(customerName);
	}

}
