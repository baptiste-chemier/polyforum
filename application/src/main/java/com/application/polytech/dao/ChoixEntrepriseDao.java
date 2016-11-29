package com.application.polytech.dao;

import java.util.List;

import com.application.polytech.model.ChoixEntreprise;
import com.application.polytech.model.Utilisateur;

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

    /**
     * Gets the list etudiant by id entreprise.
     *
     * @param id the id
     * @return the list etudiant by id entreprise
     */
    public List<Utilisateur> getListEtudiantByIdEntreprise(Long id);

    /**
     * Gets the list etudiant.
     *
     * @return the list etudiant
     */
    public List<Utilisateur> getListEtudiant();

    /**
     * Gets the list entreprise.
     *
     * @return the list entreprise
     */
    public List<ChoixEntreprise> getListEntreprise();

    /**
     * Lister etudiant non ajoutee.
     *
     * @param id the id
     * @return the list
     */
    public List<Utilisateur> listerEtudiantNonAjoutee(Long id);

}
