package com.application.polytech.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;
import org.hibernate.type.LongType;
import org.hibernate.type.StringType;
import org.springframework.stereotype.Repository;

import com.application.polytech.model.ChoixEntreprise;
import com.application.polytech.model.Utilisateur;

/**
 * The Class ChoixEntrepriseDaoImpl.
 */
@Repository("choixEntrepriseDao")
public class ChoixEntrepriseDaoImpl extends AbstractDao implements ChoixEntrepriseDao {

    /*
     * (non-Javadoc)
     * @see com.application.polytech.dao.ChoixEtudiantDao#addChoixEtudiant(com.application.polytech.model.ChoixEtudiant)
     */
    @Override
    public void addChoixEntreprise(final ChoixEntreprise choixEntreprise) {
        this.persist(choixEntreprise);
    }

    /*
     * (non-Javadoc)
     * @see com.application.polytech.dao.ChoixEntrepriseDao#getIdEtudiantById(java.lang.Long)
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
     * @see com.application.polytech.dao.ChoixEntrepriseDao#getListEtudiantByIdEntreprise(java.lang.Long)
     */
    @Override
    public List<Utilisateur> getListEtudiantByIdEntreprise(final Long id) {
        final Query query = this.getSession()
                .createSQLQuery("SELECT id, nom, prenom, email, telephone, id_profil as idProfil FROM choix_entreprise e INNER JOIN utilisateur u ON u.id = e.id_etudiant WHERE e.id_entreprise = :id")
                .addScalar("id", LongType.INSTANCE).addScalar("nom", StringType.INSTANCE).addScalar("prenom", StringType.INSTANCE).addScalar("email", StringType.INSTANCE)
                .addScalar("telephone", StringType.INSTANCE).addScalar("idProfil", LongType.INSTANCE);
        query.setLong("id", id);
        query.setResultTransformer(Transformers.aliasToBean(Utilisateur.class));
        return query.list();
    }

    /*
     * (non-Javadoc)
     * @see com.application.polytech.dao.ChoixEntrepriseDao#getListEtudiant()
     */
    @Override
    public List<Utilisateur> getListEtudiant() {
        final Criteria criteria = this.getSession().createCriteria(Utilisateur.class);
        criteria.add(Restrictions.eq("idProfil", 1L));
        return criteria.list();
    }

    /*
     * (non-Javadoc)
     * @see com.application.polytech.dao.ChoixEntrepriseDao#getListEntreprise()
     */
    @Override
    public List<ChoixEntreprise> getListEntreprise() {
        final Criteria criteria = this.getSession().createCriteria(ChoixEntreprise.class);
        return criteria.list();
    }

    /*
     * (non-Javadoc)
     * @see com.application.polytech.dao.ChoixEntrepriseDao#listerEtudiantNonAjoutee(java.lang.Long)
     */
    @Override
    public List<Utilisateur> listerEtudiantNonAjoutee(final Long id) {
        final Query query = this.getSession()
                .createSQLQuery("SELECT id, nom, prenom, email, telephone, id_profil as idProfil FROM Utilisateur WHERE id NOT IN ( "
                        + "SELECT id_etudiant FROM choix_entreprise WHERE id_entreprise = :id ) AND id_profil = '1'")
                .addScalar("id", LongType.INSTANCE).addScalar("nom", StringType.INSTANCE).addScalar("prenom", StringType.INSTANCE).addScalar("email", StringType.INSTANCE)
                .addScalar("telephone", StringType.INSTANCE).addScalar("idProfil", LongType.INSTANCE);
        query.setLong("id", id);
        query.setResultTransformer(Transformers.aliasToBean(Utilisateur.class));
        return query.list();
    }

    /*
     * (non-Javadoc)
     * @see com.application.polytech.dao.ChoixEntrepriseDao#deleteChoixEntreprise(java.lang.Long, java.lang.Long)
     */
    @Override
    public void deleteChoixEntreprise(final Long idEntreprise, final Long idEtudiant) {
        final Query query = this.getSession().createSQLQuery("DELETE FROM choix_entreprise WHERE id_entreprise = :idEntreprise AND id_etudiant = :idEtudiant");
        query.setLong("idEntreprise", idEntreprise);
        query.setLong("idEtudiant", idEtudiant);
        query.executeUpdate();
    }
}
