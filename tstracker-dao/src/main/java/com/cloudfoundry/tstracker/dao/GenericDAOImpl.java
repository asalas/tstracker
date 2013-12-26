package com.cloudfoundry.tstracker.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.hibernate.Hibernate;
import org.springframework.stereotype.Repository;

/**
 * Clase que implementa el patron de disenio DAO
 * @author asalas
 * @param <T>
 * @param <ID> 
 */
@Repository
public abstract class GenericDAOImpl<T, ID extends Serializable> implements GenericDAO<T, ID> {

    protected static Logger logger = Logger.getLogger(GenericDAOImpl.class);

    static {
        logger.setLevel(Level.DEBUG);
    }
    
    private Class<T> entityBeanType;
    
    @PersistenceContext(type = PersistenceContextType.TRANSACTION)
    EntityManager entityManager;
    
    EntityTransaction entityTransaction;

    public final void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @SuppressWarnings("unchecked")
    public GenericDAOImpl() {
        ParameterizedType genericSuperclass = (ParameterizedType) getClass().getGenericSuperclass();
		Type actualTypeArgs = genericSuperclass.getActualTypeArguments()[0];
		this.entityBeanType = (Class<T>) actualTypeArgs;
    }

    public EntityManager getEntityManager() {
        if (entityManager == null) {
            throw new IllegalStateException("EntityManager has not been set on DAO before usage");
        }
        return entityManager;
    }

    public Class<T> getEntityBeanType() {
        Hibernate.initialize(entityBeanType);
    	return entityBeanType;
    }

    @Override
    public T findById(ID id) {
        T entityResult = getEntityManager().find(entityBeanType, id);
        Hibernate.initialize(entityResult);
        return entityResult;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<T> findAll() {
        List resultList = getEntityManager().createQuery("from " + getEntityBeanType().getName()).getResultList();
        Hibernate.initialize(resultList);
		return resultList;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<T> findByExample(T exampleInstance, String... excludeProperty) {
        // Using Hibernate, more difficult with EntityManager and EJB-QL
        org.hibernate.Criteria crit = ((org.hibernate.ejb.HibernateEntityManager) getEntityManager())
                .getSession()
                .createCriteria(getEntityBeanType());
        org.hibernate.criterion.Example example =
                org.hibernate.criterion.Example.create(exampleInstance);
        for (String exclude : excludeProperty) {
            example.excludeProperty(exclude);
        }
        crit.add(example);
        return crit.list();
    }

    @Override
    public void persist(T entity) {
        getEntityManager().persist(entity);
    }

    @Override
    public void merge(T entity) {
        getEntityManager().merge(entity);
    }

    @Override
    public void remove(T entity) {
        getEntityManager().remove(entity);
    }

    @Override
    public void refresh(T oldEntity) {
        getEntityManager().refresh(oldEntity);
    }

    public static Logger getLogger() {
        return logger;
    }

    public static void setLogger(Logger logger) {
        GenericDAOImpl.logger = logger;
    }
}