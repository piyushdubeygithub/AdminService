package com.prosmv.annotations.customer;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.prosmv.config.context.SpringContext;
import com.prosmv.service.validation.ValidationService;

/**
 * This is an implementation class for {@link IsCustomerExist}
 * 
 * @author piyush
 *
 */
public class IsCustomerExistImplementation implements ConstraintValidator<IsCustomerExist, Long> {

	private ValidationService validationService = (ValidationService) SpringContext.getBean(ValidationService.class);

	@Override
	public boolean isValid(Long customerId, ConstraintValidatorContext context) {
		return !validationService.isCustomerAlreadyExist(customerId);
	}

}
