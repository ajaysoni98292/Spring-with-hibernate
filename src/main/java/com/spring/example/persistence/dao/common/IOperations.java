package com.spring.example.persistence.dao.common;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author ajay
 */

public interface IOperations<T extends Serializable> {

    T findOne(final long id);
    
    T findOne(final String id);

    List<T> findAll();

    void create(final T entity);

    T update(final T entity);

    void delete(final T entity);

    void deleteById(final long entityId);
    
    void deleteById(final String entityId);

    long findRecordsCount();
}
