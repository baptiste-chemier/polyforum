package com.application.polytech.dao;

import com.application.polytech.model.ChoixEntreprise;

/**
 * The Interface ChoixEntrepriseDao.
 */
public interface ChoixEntrepriseDao {

    /**
     * Adds the choix entreprise.
     *
     * @param choixEntreprise the choix entreprise
     */
    public void addChoixEntreprise(final ChoixEntreprise choixEntreprise);

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
