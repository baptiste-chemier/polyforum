package com.application.polytech.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.application.polytech.model.ChoixEtudiant;
import com.application.polytech.model.Utilisateur;

/**
 * The Class ChoixEtudiantDaoImpl.
 */
@Repository("choixEtudiantDao")
public class ChoixEtudiantDaoImpl extends AbstractDao implements ChoixEtudiantDao {

    /*
     * (non-Javadoc)
     * @see com.application.polytech.dao.ChoixEtudiantDao#addChoixEtudiant(com.application.polytech.model.ChoixEtudiant)
     */
    @Override
    public void addChoixEtudiant(final ChoixEtudiant choixEtudiant) {
        this.persist(choixEtudiant);
    }

    /*
     * (non-Javadoc)
     * @see com.application.polytech.dao.ChoixEtudiantDao#getIdEtudiantById(java.lang.Long)
     */
    @Override
    public Long getIdEtudiantById(final Long id) {
        final Criteria criteria = this.getSession().createCriteria(Utilisateur.class);
        criteria.add(Restrictions.eq("id", id));
        criteria.add(Restrictions.eq("idProfil", 1L));
        final Utilisateur utilisateur = (Utilisateur) criteria.uniqueResult();

        return utilisateur.getId();

    }

    /*
     * (non-Javadoc)
     * @see com.application.polytech.dao.ChoixEtudiantDao#getIdEntrepriseById(java.lang.Long)
     */
    @Override
    public Long getIdEntrepriseById(final Long id) {
        final Criteria criteria = this.getSession().createCriteria(Utilisateur.class);
        criteria.add(Restrictions.eq("id", id));
        criteria.add(Restrictions.eq("idProfil", 3L));
        final Utilisateur utilisateur = (Utilisateur) criteria.uniqueResult();

        return utilisateur.getId();
    }

    /*
     * (non-Javadoc)
     * @see com.application.polytech.dao.ChoixEtudiantDao#getListEntrepriseByIdEtudiant(java.lang.Long)
     */
    @Override
    public List<Utilisateur> getListEntrepriseByIdEtudiant(final Long id) {
        final Criteria criteria = this.getSession().createCriteria(ChoixEtudiant.class);
        criteria.add(Restrictions.eq("idEtudiant", id));
        return criteria.list();
    }
}
