package com.spring.example.service;

import com.spring.example.persistence.dao.common.IOperations;
import com.spring.example.persistence.model.Contact;

/**
 *
 * @author ajay
 */

public interface ContactService extends IOperations<Contact>{
	// Add method which are not common for other Service
}