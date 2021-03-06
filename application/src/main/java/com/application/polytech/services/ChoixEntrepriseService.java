package com.application.polytech.services;

import java.util.List;

import com.application.polytech.model.ChoixEntreprise;
import com.application.polytech.model.Utilisateur;

/**
 * The Interface ChoixEntrepriseService.
 */
public interface ChoixEntrepriseService {

    /**
     * Enregistrer choix entreprise.
     *
     * @param choixEntreprise the choix entreprise
     */
    public void enregistrerChoixEntreprise(final ChoixEntreprise choixEntreprise);

    /**
     * Gets the list etudiant by id entreprise.
     *
     * @param id the id
     * @return the list etudiant by id entreprise
     */
    public List<Utilisateur> getListEtudiantByIdEntreprise(final Long id);

    /**
     * Gets the list etudiant.
     *
     * @return the list etudiant
     */
    public List<Utilisateur> getListEtudiant();

    /**
     * Lister etudiant non ajoutee.
     *
     * @param id the id
     * @return the list
     */
    public List<Utilisateur> listerEtudiantNonAjoutee(Long id);

    /**
     * Delete choix entreprise.
     *
     * @param idEntreprise the id entreprise
     * @param idEtudiant the id etudiant
     */
    public void deleteChoixEntreprise(Long idEntreprise, Long idEtudiant);
}
