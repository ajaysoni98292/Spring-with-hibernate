package com.spring.example.form.validator.impl;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.spring.example.form.validator.EmailExistsConstraint;
import com.spring.example.persistence.model.User;
import com.spring.example.service.UserService;

/**
 *
 * @author ajay
 */

public class EmailExistsConstraintValidator implements ConstraintValidator<EmailExistsConstraint, String> {

	private static final Logger logger = LoggerFactory.getLogger(EmailExistsConstraintValidator.class);

	@Autowired
	private UserService userService;

	@Override
	public boolean isValid(String target, ConstraintValidatorContext context) {

		try {
			if(target != null && target.length() > 0){
				if(userService != null){
					User user = userService.getUserByEmailId(target);
					if (user != null) {
						return false;
					}
				}
			}
		} catch (Exception e) {
			logger.error(e.getMessage());
			e.printStackTrace();
		}
		return true;
	}


	@Override
	public void initialize(EmailExistsConstraint arg0) {
		
	}

}