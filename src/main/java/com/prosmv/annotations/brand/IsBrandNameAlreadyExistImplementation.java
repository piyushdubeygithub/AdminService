package com.prosmv.annotations.brand;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.prosmv.config.context.SpringContext;
import com.prosmv.service.validation.ValidationService;

/**
 * This class is an implementation of {@link IsBrandNameAlreadyExist}.
 * 
 * @author piyush
 *
 */
public class IsBrandNameAlreadyExistImplementation implements ConstraintValidator<IsBrandNameAlreadyExist, String> {

	private ValidationService validationService = (ValidationService) SpringContext.getBean(ValidationService.class);

	@Override
	public boolean isValid(String brandName, ConstraintValidatorContext context) {
		return !validationService.isBrandNameAlreadyExist(brandName);
	}

}
