package com.spring.example.persistence.dao.impl;

import org.springframework.stereotype.Repository;

import com.spring.example.persistence.dao.RoleDao;
import com.spring.example.persistence.dao.common.AbstractHibernateDao;
import com.spring.example.persistence.model.Role;

/**
 *
 * @author ajay
 */

@Repository
public class RoleDaoImpl extends AbstractHibernateDao<Role> implements RoleDao {

	public RoleDaoImpl() {
        super();
        setClazz(Role.class);
    }
	
}