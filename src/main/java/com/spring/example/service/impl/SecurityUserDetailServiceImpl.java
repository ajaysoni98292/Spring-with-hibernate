package com.spring.example.service.impl;

import com.spring.example.persistence.model.User;
import com.spring.example.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class SecurityUserDetailServiceImpl implements UserDetailsService {

	private static final Logger LOGGER = LoggerFactory.getLogger(SecurityUserDetailServiceImpl.class);
	private static User EMPTY = new User();

	@Autowired
	private UserService userService;

	/* The following method is in built method UserDetailService class and this class
	 * method loadUserByUserName is overwritten by the author for custom use
	 * if any exception occurred in the following approach then author not returning the null
	 * he is returning the empty user because empty user is not harmful
	 */

	@Override
	public UserDetails loadUserByUsername(String username){
		try{
			LOGGER.info("Login using username : " + username);
			User user = userService.getUserByEmailId(username);
			return user;
		}catch(Exception e){
			LOGGER.error("Exception occurred in getting the logged in user {}", e);
			return EMPTY;
		}
	}
}