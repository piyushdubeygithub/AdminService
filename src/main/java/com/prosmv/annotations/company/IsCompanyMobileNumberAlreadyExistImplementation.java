package com.prosmv.annotations.company;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * This class is an implementation class for {@link IsCompanyMobileNumberAlreadyExist}.
 * @author piyush
 *
 */
public class IsCompanyMobileNumberAlreadyExistImplementation implements ConstraintValidator<IsCompanyMobileNumberAlreadyExist, String>{

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		return false;
	}

}
