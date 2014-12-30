package com.spring.example.form.validator;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import com.spring.example.form.validator.impl.SelectValueConstraintValidator;

/**
 *
 * @author ajay
 */

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy=SelectValueConstraintValidator.class)
public @interface SelectValueConstraint {
	String message() default "{SelectValueConstraint}";
	Class<?>[] groups() default {};
	Class<? extends Payload>[] payload() default {};
}
