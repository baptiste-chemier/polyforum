package com.application.polytech.services;

import java.util.List;

import com.application.polytech.model.ChoixEtudiant;
import com.application.polytech.model.Utilisateur;

/**
 * The Interface ChoixEtudiantService.
 */
public interface ChoixEtudiantService {

    /**
     * Enregistrer choix etudiant.
     *
     * @param choixEtudiant the choix etudiant
     */
    public void enregistrerChoixEtudiant(final ChoixEtudiant choixEtudiant);

    /**
     * Gets the list entreprise by id etudiant.
     *
     * @param id the id
     * @return the list entreprise by id etudiant
     */
    public List<Utilisateur> getListEntrepriseByIdEtudiant(final Long id);

    /**
     * Gets the list entreprise.
     *
     * @return the list entreprise
     */
    public List<Utilisateur> getListEntreprise();

    /**
     * Lister entreprise non ajoutee.
     *
     * @param id the id
     * @return the list
     */
    public List<Utilisateur> listerEntrepriseNonAjoutee(Long id);

    /**
     * Delete choix etudiant.
     *
     * @param idEtudiant the id etudiant
     * @param idEntreprise the id entreprise
     */
    public void deleteChoixEtudiant(Long idEtudiant, Long idEntreprise);

}
