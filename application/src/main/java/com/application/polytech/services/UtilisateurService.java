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
    public void addUtilisateur(Utilisateur utilisateur);

    /**
     * Update utilisateur.
     *
     * @param utilisateur the utilisateur
     */
    public void updateUtilisateur(Utilisateur utilisateur);

    /**
     * Gets the utilisateur by id.
     *
     * @param id the id
     * @return the utilisateur by id
     */
    public Utilisateur getUtilisateurById(Long id);

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
    public void deleteUtilisateur(Long id);

    /**
     * Connecter.
     *
     * @param login the login
     * @param password the password
     * @return the utilisateur
     */
    public Utilisateur connecter(String login, String password);
}
