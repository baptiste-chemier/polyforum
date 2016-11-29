package com.application.polytech.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
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
        final Query query = this.getSession().createSQLQuery("SELECT * " + "FROM Choix_Etudiant " + "INNER JOIN Utilisateur ON Choix_Etudiant.id_etudiant=Utilisateur.id " + "WHERE id_etudiant = :id");
        query.setLong("id", id);

        return query.list();
    }

    /*
     * (non-Javadoc)
     * @see com.application.polytech.dao.ChoixEtudiantDao#getListEntreprise()
     */
    @Override
    public List<Utilisateur> getListEntreprise() {
        final Criteria criteria = this.getSession().createCriteria(Utilisateur.class);
        criteria.add(Restrictions.eq("idProfil", 3L));
        return criteria.list();
    }

    /*
     * (non-Javadoc)
     * @see com.application.polytech.dao.ChoixEtudiantDao#getListEtudiant()
     */
    @Override
    public List<ChoixEtudiant> getListEtudiant() {
        final Criteria criteria = this.getSession().createCriteria(ChoixEtudiant.class);
        return criteria.list();
    }

    /*
     * (non-Javadoc)
     * @see com.application.polytech.dao.ChoixEtudiantDao#listerEntrepriseNonAjoutee(java.lang.Long)
     */
    @Override
    public List<Utilisateur> listerEntrepriseNonAjoutee(final Long id) {
        final Query query = this.getSession()
                .createSQLQuery("SELECT * FROM Utilisateur WHERE id NOT IN ( " + "SELECT id_entreprise FROM choix_etudiant WHERE id_etudiant = :id ) " + "AND id_profil = '3'");
        query.setLong("id", id);
        return query.list();
    }
}
