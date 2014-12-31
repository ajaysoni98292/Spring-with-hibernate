package com.spring.example.service;

import com.spring.example.model.ChangePassword;
import com.spring.example.model.Records;
import com.spring.example.persistence.dao.common.IOperations;
import com.spring.example.persistence.model.User;

/**
 *
 * @author ajay
 */

public interface UserService extends IOperations<User>{
	Records listPaginatedUsers(int startIndex , int numberOfRecordsToFetch);
	User getUserByEmailId(String id);
	User setUserAccountAccessControl(User user);
	String updatePassword(ChangePassword changePassword, User activeUser);
}
