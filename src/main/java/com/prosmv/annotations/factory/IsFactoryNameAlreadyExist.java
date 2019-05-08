package com.prosmv.annotations.factory;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import com.prosmv.constants.message.ValidationMessageCode;

@Documented
@Retention(RUNTIME)
@Target({ FIELD, METHOD, PARAMETER })
@Constraint(validatedBy = IsFactoryNameAlreadyExistImplementation.class)
public @interface IsFactoryNameAlreadyExist {

	String message() default ValidationMessageCode.FACTORY_ALREADY_EXIST;

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};

}
