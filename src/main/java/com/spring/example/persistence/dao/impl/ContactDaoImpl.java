package com.spring.example.persistence.dao.impl;

import org.springframework.stereotype.Repository;

import com.spring.example.persistence.dao.common.AbstractHibernateDao;
import com.spring.example.persistence.model.Contact;

/**
 *
 * @author ajay
 */

@Repository
public class ContactDaoImpl extends AbstractHibernateDao<Contact> implements com.spring.example.persistence.dao.ContactDao {

	public ContactDaoImpl() {
        super();
        setClazz(Contact.class);
    }
	
}