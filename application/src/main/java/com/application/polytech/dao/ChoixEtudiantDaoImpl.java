package com.application.polytech.dao;

import org.springframework.stereotype.Repository;

import com.application.polytech.model.ChoixEtudiant;

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

}
