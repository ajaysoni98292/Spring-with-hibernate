package com.spring.example.persistence.dao;

import java.util.List;

import com.spring.example.model.Records;
import com.spring.example.persistence.dao.common.IOperations;
import com.spring.example.persistence.model.User;

/**
 *
 * @author ajay
 */

public interface UserDao extends IOperations<User>{
	Records listPaginatedUsers(int startIndex , int numberOfRecordsToFetch);
	List<User> getUserById(String id);
}

