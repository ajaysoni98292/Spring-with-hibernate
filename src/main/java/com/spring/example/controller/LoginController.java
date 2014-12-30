package com.spring.example.controller;

import org.springframework.security.authentication.RememberMeAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author ajay
 */

@Controller
public class LoginController {


	@RequestMapping(value = {"/" , "/login"}, method = RequestMethod.GET)
	public String login() {
		if (isRememberMeAuthenticated()) {
			return "redirect:/home";
		}
		return "login";
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout() {
		return "login";
	}
	
	private boolean isRememberMeAuthenticated() {
		Authentication authentication =  SecurityContextHolder.getContext().getAuthentication();
		if (authentication == null) {
			return false;
		}
		return RememberMeAuthenticationToken.class.isAssignableFrom(authentication.getClass());
	}
}