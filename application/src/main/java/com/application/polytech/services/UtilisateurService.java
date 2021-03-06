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
     * Importer utilisateur excel.
     *
     * @param filePath the file path
     */
    public void importerUtilisateurExcel(final String filePath);

    /**
     * Compter nombre entreprise.
     *
     * @return the long
     */
    public Long compterNombreEntreprise();

    /**
     * Gets the all etudiant.
     *
     * @return the all etudiant
     */
    public List<Utilisateur> getAllEtudiant();

    /**
     * Gets the all entreprise.
     *
     * @return the all entreprise
     */
    public List<Utilisateur> getAllEntreprise();

}
