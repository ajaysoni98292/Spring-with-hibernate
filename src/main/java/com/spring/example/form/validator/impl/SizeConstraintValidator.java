package com.spring.example.form.validator.impl;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.spring.example.form.validator.SizeConstraint;
import com.spring.example.service.UserService;

/**
 *
 * @author ajay
 */

public class SizeConstraintValidator implements ConstraintValidator<SizeConstraint, String> {

	private static final Logger logger = LoggerFactory.getLogger(SizeConstraintValidator.class);

	private int min = 0;
	private int max = 0;
	
	@Autowired
	private UserService userService;

	@Override
	public boolean isValid(String target, ConstraintValidatorContext context) {

		try {
			if(target.trim().length() < min || target.trim().length() > max){
				return false;
			}
		} catch (Exception e) {
			logger.error(e.getMessage());
			e.printStackTrace();
		}
		return true;
	}


	@Override
	public void initialize(SizeConstraint sizeConstraint) {
		min = sizeConstraint.min();
		max = sizeConstraint.max();
	}

}