package com.application.polytech.dao;

import java.util.List;

import com.application.polytech.model.Utilisateur;

/**
 * The Interface UtilisateurDao.
 */
public interface UtilisateurDao {

    /**
     * Adds the utilisateur.
     *
     * @param utilisateur the utilisateur
     */
    public void addUtilisateur(Utilisateur utilisateur);

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
}