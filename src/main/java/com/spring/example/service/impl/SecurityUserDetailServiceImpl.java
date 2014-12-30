package com.spring.example.service.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.example.persistence.model.Role;
import com.spring.example.service.UserService;

@Service
@Transactional(readOnly = true)
public class SecurityUserDetailServiceImpl implements UserDetailsService{

	private static final Logger logger = LoggerFactory.getLogger(SecurityUserDetailServiceImpl.class);
	
	@Autowired
	UserService userService;
    
    @SuppressWarnings("unchecked")
	@Override
    public UserDetails loadUserByUsername(String username){
    	try{
    	logger.info("Login using username : " +username);
        com.spring.example.persistence.model.User user = userService.getUserById(username);
	    return new User(  
	            user.getEmail(),   
	            user.getPassword(),   
	            user.isEnabled(),   
	            user.isAccountNonExpired(),   
	            user.isCredentialsNonExpired(),   
	            user.isAccountNonLocked(),  
	            getAuthorities(user.getRole())  
	    ); 
    	}catch(Exception e){
    		e.printStackTrace();
    		return  null;
    	}
    }

    @SuppressWarnings("rawtypes")
    private Collection getAuthorities(Role role) {  
	    List<GrantedAuthority> authList = getGrantedAuthorities(getRoles(role));  
	    return authList;  
	}
    
    public List<String> getRoles(Role role) {  
	    List<String> roleList = new ArrayList<String>();  
	    roleList.add(role.getRole());
	    return roleList;  
	}  
    
    public static List<GrantedAuthority> getGrantedAuthorities(List<String> roles) {  
	    List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();  
	      
	    for (String role : roles) {  
	        authorities.add(new SimpleGrantedAuthority(role));  
	    }  
	    return authorities;  
	} 
}