package com.spring.example.service.common;

import java.io.Serializable;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.spring.example.persistence.dao.common.IOperations;

/**
 *
 * @author ajay
 */

@Transactional
public abstract class AbstractService<T extends Serializable> implements IOperations<T> {

    @Override
    public T findOne(final long id) {
        return getDao().findOne(id);
    }
    
    @Override
    public T findOne(final String id) {
        return getDao().findOne(id);
    }

    @Override
    public List<T> findAll() {
        return getDao().findAll();
    }

    @Override
    public void create(final T entity) {
        getDao().create(entity);
    }

    @Override
    public T update(final T entity) {
        return getDao().update(entity);
    }

    @Override
    public void delete(final T entity) {
        getDao().delete(entity);
    }

    @Override
    public void deleteById(final long entityId) {
        getDao().deleteById(entityId);
    }
    
    @Override
    public void deleteById(final String entityId) {
        getDao().deleteById(entityId);
    }

    @Override
    public long findRecordsCount() {
        return getDao().findRecordsCount();
    }
    protected abstract IOperations<T> getDao();

}
