package com.spring.example.service.impl;

import java.util.List;

import com.spring.example.model.ChangePassword;
import com.spring.example.model.Records;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.spring.example.persistence.dao.UserDao;
import com.spring.example.persistence.dao.common.IOperations;
import com.spring.example.persistence.model.User;
import com.spring.example.service.UserService;
import com.spring.example.service.common.AbstractService;

@Service
public class UserServiceImpl extends AbstractService<User> implements UserService {

	@Autowired(required=true)
    private UserDao dao;
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private ReloadableResourceBundleMessageSource messageSource;

    public UserServiceImpl() {
        super();
    }

	@Override
	protected IOperations<User> getDao() {
		 return dao;
	}

	@Override
    public void create(final User entity) {
		entity.setPassword(passwordEncoder.encode(entity.getPassword()));
        getDao().create(entity);
    }

	@Override
	public Records listPaginatedUsers(int startIndex,int numberOfRecordsToFetch) {
		return dao.listPaginatedUsers(startIndex, numberOfRecordsToFetch);
	}
	
	@Override
	public User getUserByEmailId(String id) {
		List<User> list = dao.getUserById(id);
		if(list != null && list.size() > 0){
			return list.get(0);
		}
		return null;
	}

	@Override
	public User setUserAccountAccessControl(User user) {
		user.setAccountNonExpired(true);
		user.setAccountNonLocked(true);
		user.setCredentialsNonExpired(true);
		user.setEnabled(true);
		return user;
	}

	@Override
	public String updatePassword(ChangePassword changePassword,User activeUser) {

		String oldPassword = changePassword.getOldPassword();
		String newPassword = changePassword.getNewPassword();
		String confirmPassword = changePassword.getConfirmPassword();

		boolean isOldPasswordCorrect = passwordEncoder.matches(oldPassword,
				getUserByEmailId(activeUser.getEmail()).getPassword());
		if (isOldPasswordCorrect) {
			if (newPassword.equals(confirmPassword)) {
				activeUser.setPassword(passwordEncoder.encode(newPassword));
				update(activeUser);
				return messageSource.getMessage("password.changed.successfully", null, null);
			} else {
				return messageSource.getMessage("new.password.and.confirm.password.should.be.same",null, null);
			}
		} else {
			return messageSource.getMessage("old.password.is.incorrect", null,null);
		}
	}
}
