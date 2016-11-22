package com.application.polytech.services;

import java.util.List;

import com.application.polytech.model.Utilisateur;

/**
 * The Interface UtilisateurService.
 */
public interface UtilisateurService {

    /**
     * Adds the utilisateur.
     *
     * @param utilisateur the utilisateur
     */
    public void addUtilisateur(final Utilisateur utilisateur);

    /**
     * Update utilisateur.
     *
     * @param id the id
     * @param utilisateur the utilisateur
     */
    public void updateUtilisateur(final Long id, final Utilisateur utilisateur);

    /**
     * Gets the utilisateur by id.
     *
     * @param id the id
     * @return the utilisateur by id
     */
    public Utilisateur getUtilisateurById(final Long id);

    /**
     * Gets the all.
     *
     * @return the all
     */
    public List<Utilisateur> getAll();

    /**
     * Delete utilisateur.
     *
     * @param id the id
     */
    public void deleteUtilisateur(final Long id);

    /**
     * Connecter.
     *
     * @param login the login
     * @param password the password
     * @return the utilisateur
     */
    public Utilisateur connecter(String login, String password);

    /**
     * Enregistrer choix etudiant.
     *
     * @param idEtudiant the id etudiant
     * @param idEntreprise the id entreprise
     */
    public void enregistrerChoixEtudiant(final Long idEtudiant, final Long idEntreprise);

    /**
     * Enregistrer choix entreprise.
     *
     * @param idEntreprise the id entreprise
     * @param idEtudiant the id etudiant
     */
    public void enregistrerChoixEntreprise(Long idEntreprise, Long idEtudiant);
}
