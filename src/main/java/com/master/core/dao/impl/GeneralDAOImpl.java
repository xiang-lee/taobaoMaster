package com.master.core.dao.impl;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.springframework.beans.factory.annotation.Autowired;
import com.master.core.dao.GeneralDAO;

public class GeneralDAOImpl<T, PK extends Serializable> implements GeneralDAO<T, PK>{

	private Class<T> type;
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	@Resource(name="sessionFactory")
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public Class<T> getPersistentClass() {
        return type;
    }
	
//	@SuppressWarnings("unchecked")  
//	public GeneralDAOImpl() {
//        this.type = (Class<?>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
//    }
 
	
	public GeneralDAOImpl(Class<T> type) {
        this.type = type;
    }
	
	
	@Override
	public void save(T entity) {
		sessionFactory.getCurrentSession().save(entity);
	}

	@Override
	public void delete(T entity) {
		sessionFactory.getCurrentSession().delete(entity);
	}

	@Override
	public void delete(Serializable id) {
		delete(findById(id));
	}

	@Override
	public List<T> findAll() {
		return findByCriteria();
	}

	@SuppressWarnings("unchecked")  
	@Override
	public T findById(Serializable id) {
        return (T) sessionFactory.getCurrentSession().get(getPersistentClass(), id);
	}
	
	@Override
	public List find(String hql, Object... values) {
        return createQuery(hql, values).list();
    }
	
	
	@SuppressWarnings("unchecked")  
    private List<T> findByCriteria(Criterion... criterion) {  
        Criteria crit = sessionFactory.getCurrentSession().createCriteria(getPersistentClass());  
        for (Criterion c : criterion) {  
            crit.add(c);  
        }  
        return crit.list();  
   }  
	
	public Query createQuery(String queryString, Object... values) {
       sessionFactory.getCurrentSession().createQuery(queryString);
       Query queryObject = sessionFactory.getCurrentSession().createQuery(queryString);
       if (values != null) {
           for (int i = 0; i < values.length; i++) {
               queryObject.setParameter(i, values[i]);
           }
       }
       return queryObject;
   }
}
