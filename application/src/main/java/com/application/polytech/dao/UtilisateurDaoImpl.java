package com.application.polytech.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.application.polytech.model.Utilisateur;

/**
 * The Class UtilisateurDaoImpl.
 */
@Repository("utilisateurDao")
public class UtilisateurDaoImpl extends AbstractDao implements UtilisateurDao {

    /*
     * (non-Javadoc)
     * @see com.application.polytech.dao.UtilisateurDao#addUtilisateur(com.application.polytech.model.Utilisateur)
     */
    @Override
    public void addUtilisateur(final Utilisateur utilisateur) {
        this.persist(utilisateur);
    }

    /*
     * (non-Javadoc)
     * @see com.application.polytech.dao.UtilisateurDao#updateUtilisateur(com.application.polytech.model.Utilisateur)
     */
    @Override
    public void updateUtilisateur(final Utilisateur utilisateur) {
        this.getSession().update(utilisateur);
    }

    /*
     * (non-Javadoc)
     * @see com.application.polytech.dao.UtilisateurDao#getUtilisateurById(java.lang.Long)
     */
    @Override
    public Utilisateur getUtilisateurById(final Long id) {
        final Criteria criteria = this.getSession().createCriteria(Utilisateur.class);
        criteria.add(Restrictions.eq("id", id));
        return (Utilisateur) criteria.uniqueResult();
    }

    /*
     * (non-Javadoc)
     * @see com.application.polytech.dao.UtilisateurDao#getAll()
     */
    @Override
    public List<Utilisateur> getAll() {
        final Criteria criteria = this.getSession().createCriteria(Utilisateur.class);
        return criteria.list();
    }

    /*
     * (non-Javadoc)
     * @see com.application.polytech.dao.UtilisateurDao#deleteUtilisateur(java.lang.Long)
     */
    @Override
    public void deleteUtilisateur(final Long id) {
        final Query query = this.getSession().createSQLQuery("DELETE FROM Utilisateur WHERE id = :id");
        query.setLong("id", id);
        query.executeUpdate();
    }
}
