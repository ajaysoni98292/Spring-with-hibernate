package com.spring.example.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.example.persistence.dao.ContactDao;
import com.spring.example.persistence.dao.common.IOperations;
import com.spring.example.persistence.model.Contact;
import com.spring.example.service.ContactService;
import com.spring.example.service.common.AbstractService;

@Service
public class ContactServiceImpl extends AbstractService<Contact> implements ContactService {

	@Autowired(required=true)
    private ContactDao dao;

    public ContactServiceImpl() {
        super();
    }

	@Override
	protected IOperations<Contact> getDao() {
		 return dao;
	}

}