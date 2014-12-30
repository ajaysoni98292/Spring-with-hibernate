package com.spring.example.service;

import com.spring.example.model.Records;
import com.spring.example.persistence.dao.common.IOperations;
import com.spring.example.persistence.model.User;

/**
 *
 * @author ajay
 */

public interface UserService extends IOperations<User>{
	Records listPaginatedUsers(int startIndex , int numberOfRecordsToFetch);
	User getUserById(String id);
	User setUserAccountAccessControl(User user);
}
