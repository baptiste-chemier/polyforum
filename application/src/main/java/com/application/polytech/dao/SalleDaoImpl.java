package com.application.polytech.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.application.polytech.model.Salle;

/**
 * The Class SalleDaoImpl.
 */
@Repository("salleDao")
public class SalleDaoImpl extends AbstractDao implements SalleDao {

    /*
     * (non-Javadoc)
     * @see com.application.polytech.dao.SalleDao#addSalle(com.application.polytech.model.Salle)
     */
    @Override
    public void addSalle(final Salle salle) {
        this.persist(salle);
    }

    /*
     * (non-Javadoc)
     * @see com.application.polytech.dao.SalleDao#updateSalle(com.application.polytech.model.Salle)
     */
    @Override
    public void updateSalle(final Long id, final Salle salle) {
        final Salle salleModifie = this.getSalleById(id);

        if (salleModifie != null) {
            if (salle.getLibelle() != null) {
                salleModifie.setLibelle(salle.getLibelle());
            }

            salleModifie.setCapacite(salle.getCapacite());

            this.getSession().update(salle);

        }

    }

    /*
     * (non-Javadoc)
     * @see com.application.polytech.dao.SalleDao#getSalleById(java.lang.Long)
     */
    @Override
    public Salle getSalleById(final Long id) {
        final Criteria criteria = this.getSession().createCriteria(Salle.class);
        criteria.add(Restrictions.eq("id", id));
        return (Salle) criteria.uniqueResult();
    }

    /*
     * (non-Javadoc)
     * @see com.application.polytech.dao.SalleDao#getAll()
     */
    @Override
    public List<Salle> getAll() {
        final Criteria criteria = this.getSession().createCriteria(Salle.class);
        return criteria.list();
    }

    /*
     * (non-Javadoc)
     * @see com.application.polytech.dao.SalleDao#deleteSalle(java.lang.Long)
     */
    @Override
    public void deleteSalle(final Long id) {
        final Query query = this.getSession().createSQLQuery("DELETE FROM Salle WHERE id = :id");
        query.setLong("id", id);
        query.executeUpdate();
    }

}
