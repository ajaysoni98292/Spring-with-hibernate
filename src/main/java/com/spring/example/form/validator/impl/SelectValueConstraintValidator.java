package com.spring.example.form.validator.impl;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.spring.example.form.validator.SelectValueConstraint;
import com.spring.example.persistence.model.Role;
import com.spring.example.service.UserService;

/**
 *
 * @author ajay
 */

public class SelectValueConstraintValidator implements ConstraintValidator<SelectValueConstraint, Object> {

	private static final Logger logger = LoggerFactory.getLogger(EmailExistsConstraintValidator.class);

	@Autowired
	private UserService userService;

	@Override
	public boolean isValid(Object target, ConstraintValidatorContext context) {
		try {
			if(target != null){
				if(target instanceof Role){
					if(((Role)target).getId() > 0){
						return true;
					}
				}
			}
		} catch (Exception e) {
			logger.error(e.getMessage());
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public void initialize(SelectValueConstraint arg0) {
	}
}