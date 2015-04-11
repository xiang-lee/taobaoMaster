package com.master.core.dao;

import java.io.Serializable;
import java.util.List;

public interface GeneralDAO<T, PK extends Serializable> {
	public void save(T entity);
    public void delete(T entity);
    public void delete(PK id);
    public List<T> findAll();
    public T findById(final PK id);
    
    /**
     * Press the HQL Query object list .
     * 
     * @param hql
     *            hqlStatement 
     * @param values
     *            Number of variable parameters 
     */
    public List find(String hql, Object... values);
}
