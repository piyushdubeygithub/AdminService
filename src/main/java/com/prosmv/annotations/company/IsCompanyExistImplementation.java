package com.prosmv.annotations.company;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.prosmv.config.context.SpringContext;
import com.prosmv.service.validation.ValidationService;

/**
 * This is an implementation class for {@link IsCompanyExist}.
 * @author piyush
 *
 */
public class IsCompanyExistImplementation implements ConstraintValidator<IsCompanyExist, Long> {

	private ValidationService validationService = (ValidationService) SpringContext.getBean(ValidationService.class);

	@Override
	public boolean isValid(Long companyId, ConstraintValidatorContext context) {
		return validationService.isCompanyAlreadyExist(companyId);
	}

}
