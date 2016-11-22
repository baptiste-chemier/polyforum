package com.application.polytech.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.application.polytech.model.Profil;

/**
 * The Class ProfilDaoImpl.
 */
@Repository("profilDao")
public class ProfilDaoImpl extends AbstractDao implements ProfilDao {

    /*
     * (non-Javadoc)
     * @see com.application.polytech.dao.ProfilDao#getProfilById(java.lang.Long)
     */
    @Override
    public Profil getProfilById(final Long id) {
        final Criteria criteria = this.getSession().createCriteria(Profil.class);
        criteria.add(Restrictions.eq("id", id));
        return (Profil) criteria.uniqueResult();
    }

    /*
     * (non-Javadoc)
     * @see com.application.polytech.dao.ProfilDao#getAll()
     */
    @Override
    public List<Profil> getAll() {
        final Criteria criteria = this.getSession().createCriteria(Profil.class);
        return criteria.list();
    }

    /*
     * (non-Javadoc)
     * @see com.application.polytech.dao.ProfilDao#getLibelleById(java.lang.Long)
     */
    @Override
    public String getLibelleById(final Long id) {
        final Query query = this.getSession().createSQLQuery("SELECT libelle FROM Profil WHERE id = :id");
        query.setLong("id", id);
        return (String) query.uniqueResult();
    }

}
