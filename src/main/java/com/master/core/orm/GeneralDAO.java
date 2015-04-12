package com.master.core.orm;

import java.io.Serializable;
import java.util.List;

import com.master.core.util.Page;


public interface GeneralDAO<T, PK extends Serializable> {
	public void save(T entity);
    public void delete(T entity);
    public void delete(PK id);
    public List<T> findAll();
    public T findById(final PK id);
    
    /**
     * Pass the HQL Query object list .
     * 
     * @param hql
     *            hqlStatement 
     * @param values
     *            Number of variable parameters 
     */
    public List find(String hql, Object... values);
    
    public Page<T> findAll(Page<T> page);
}
