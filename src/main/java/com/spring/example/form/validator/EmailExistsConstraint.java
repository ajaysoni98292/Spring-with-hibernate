package com.spring.example.form.validator;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import com.spring.example.form.validator.impl.EmailExistsConstraintValidator;

/**
 *
 * @author ajay
 */

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy=EmailExistsConstraintValidator.class)
public @interface EmailExistsConstraint {
	String message() default "{EmailExistsConstraint}";
	Class<?>[] groups() default {};
	Class<? extends Payload>[] payload() default {};
}