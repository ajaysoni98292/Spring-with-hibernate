package com.spring.example.persistence.dao;

import com.spring.example.persistence.dao.common.IOperations;
import com.spring.example.persistence.model.Contact;

/**
 *
 * @author ajay
 */

public interface ContactDao extends IOperations<Contact>{
	// Add method which are not common for other DAO
}
