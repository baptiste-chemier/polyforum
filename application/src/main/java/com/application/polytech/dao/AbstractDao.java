package com.application.polytech.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * The Class AbstractDao.
 */
public abstract class AbstractDao {

    /** The session factory. */
    @Autowired
    private SessionFactory sessionFactory;

    /**
     * Gets the session.
     *
     * @return the session
     */
    protected Session getSession() {
        return this.sessionFactory.getCurrentSession();
    }

    /**
     * Persist.
     *
     * @param entity the entity
     */
    public void persist(final Object entity) {
        this.getSession().persist(entity);
    }

    /**
     * Delete.
     *
     * @param entity the entity
     */
    public void delete(final Object entity) {
        this.getSession().delete(entity);
    }
}