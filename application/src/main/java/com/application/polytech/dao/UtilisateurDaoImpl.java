package com.application.polytech.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import com.application.polytech.model.Utilisateur;

/**
 * The Class UtilisateurDaoImpl.
 */
public class UtilisateurDaoImpl implements UtilisateurDao {

    /** The session factory. */
    @Autowired
    SessionFactory sessionFactory;

    /** The session. */
    Session session = null;

    /** The tx. */
    Transaction tx = null;

    /*
     * (non-Javadoc)
     * @see com.application.polytech.dao.UtilisateurDao#addUtilisateur(com.application.polytech.model.Utilisateur)
     */
    @Override
    public void addUtilisateur(final Utilisateur utilisateur) {
        this.session = this.sessionFactory.openSession();
        this.tx = this.session.beginTransaction();
        this.session.save(utilisateur);
        this.tx.commit();
        this.session.close();

    }

    /*
     * (non-Javadoc)
     * @see com.application.polytech.dao.UtilisateurDao#getUtilisateurById(java.lang.Long)
     */
    @Override
    public Utilisateur getUtilisateurById(final Long id) {
        this.session = this.sessionFactory.openSession();
        final Utilisateur utilisateur = (Utilisateur) this.session.load(Utilisateur.class, new Long(id));
        this.tx = this.session.getTransaction();
        this.session.beginTransaction();
        this.tx.commit();
        return utilisateur;
    }

    /*
     * (non-Javadoc)
     * @see com.application.polytech.dao.UtilisateurDao#getAll()
     */
    @Override
    public List<Utilisateur> getAll() {
        this.session = this.sessionFactory.openSession();
        this.tx = this.session.beginTransaction();
        final List<Utilisateur> utilisateurList = this.session.createCriteria(Utilisateur.class).list();
        this.tx.commit();
        this.session.close();
        return utilisateurList;
    }

    /**
     * Delete utilisateur.
     *
     * @param id the id
     */
    @Override
    public void deleteUtilisateur(final Long id) {
        this.session = this.sessionFactory.openSession();
        final Object o = this.session.load(Utilisateur.class, id);
        this.tx = this.session.getTransaction();
        this.session.beginTransaction();
        this.session.delete(o);
        this.tx.commit();
    }

}
