package com.application.polytech.dao;

import com.application.polytech.model.ChoixEtudiant;

/**
 * The Interface ChoixEtudiantDao.
 */
public interface ChoixEtudiantDao {

    /**
     * Adds the choix etudiant.
     *
     * @param choixEtudiant the choix etudiant
     */
    public void addChoixEtudiant(final ChoixEtudiant choixEtudiant);

    /**
     * Gets the id etudiant by id.
     *
     * @param id the id
     * @return the id etudiant by id
     */
    public Long getIdEtudiantById(final Long id);

    /**
     * Gets the id entreprise by id.
     *
     * @param id the id
     * @return the id entreprise by id
     */
    public Long getIdEntrepriseById(final Long id);

}
