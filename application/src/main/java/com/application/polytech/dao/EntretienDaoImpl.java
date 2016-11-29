package com.application.polytech.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.transform.Transformers;
import org.hibernate.type.IntegerType;
import org.hibernate.type.LongType;
import org.springframework.stereotype.Repository;

import com.application.polytech.model.Entretien;
import com.application.polytech.model.EntretienDTO;

/**
 * The Class EntretienDaoImpl.
 */
@Repository("entretienDao")
public class EntretienDaoImpl extends AbstractDao implements EntretienDao {

    /* (non-Javadoc)
     * @see com.application.polytech.dao.EntretienDao#getAll()
     */
    @Override
    public List<Entretien> getAll() {
        final Criteria criteria = this.getSession().createCriteria(Entretien.class);
        return criteria.list();
    }

    /* (non-Javadoc)
     * @see com.application.polytech.dao.EntretienDao#recupererMatrice()
     */
    @Override
    public List<EntretienDTO> recupererMatrice() {
        final Query query = this.getSession().createSQLQuery("SELECT id_entreprise, id_etudiant, SUM(ordre) as ordre, duree "
                + "FROM "
                + "(SELECT e.id_entreprise, e.id_etudiant, e.ordre, e.duree "
                + "FROM Choix_Entreprise e "
                + "UNION "
                + "SELECT etu.id_entreprise, etu.id_etudiant, etu.ordre, etu.duree "
                + "FROM Choix_Etudiant etu) temp "
                + "GROUP BY id_entreprise, id_etudiant "
                + "ORDER BY id_entreprise, ordre DESC")
                .addScalar("id_entreprise", LongType.INSTANCE)
                .addScalar("id_etudiant", LongType.INSTANCE)
                .addScalar("ordre", IntegerType.INSTANCE)
                .addScalar("duree", IntegerType.INSTANCE);

        query.setResultTransformer(Transformers.aliasToBean(EntretienDTO.class));
        return query.list();
    }
}
