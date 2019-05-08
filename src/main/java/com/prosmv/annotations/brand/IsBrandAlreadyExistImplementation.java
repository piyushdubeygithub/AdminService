package com.prosmv.annotations.brand;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.prosmv.config.context.SpringContext;
import com.prosmv.service.validation.ValidationService;

/**
 * This class is implementation class for {@link IsBrandAlreadyExist}.
 * @author piyush
 *
 */
public class IsBrandAlreadyExistImplementation implements ConstraintValidator<IsBrandAlreadyExist, Long> {

	private ValidationService validationService = (ValidationService) SpringContext.getBean(ValidationService.class);

	@Override
	public boolean isValid(Long brandId, ConstraintValidatorContext context) {
		return !validationService.isBrandAlreadyExist(brandId);
	}
	
	
}
