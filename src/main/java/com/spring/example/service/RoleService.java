package com.spring.example.service;

import java.util.Map;

import com.spring.example.persistence.dao.common.IOperations;
import com.spring.example.persistence.model.Role;

/**
 *
 * @author ajay
 */

public interface RoleService extends IOperations<Role>{
	Map<String,String> getAllRole();
}
