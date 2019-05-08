package com.prosmv.annotations.designation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.prosmv.config.context.SpringContext;
import com.prosmv.service.validation.ValidationService;

/**
 * This class is an implementation of {@link IsDesignationAlreadyExist}
 * 
 * @author piyush
 *
 */
public class IsDesignationAlreadyExistImplementation implements ConstraintValidator<IsDesignationAlreadyExist, Long> {

	private ValidationService validationService = (ValidationService) SpringContext.getBean(ValidationService.class);

	@Override
	public boolean isValid(Long designationId, ConstraintValidatorContext context) {
		return !validationService.isDesignationAlreadyExist(designationId);
	}

}
