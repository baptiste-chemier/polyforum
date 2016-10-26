package com.application.polytech.dao;

import java.util.List;

import com.application.polytech.model.Salle;

/**
 * The Class SalleDao.
 */
public interface SalleDao {

    /**
     * Adds the utilisateur.
     *
     * @param salle the salle
     */
    public void addSalle(Salle salle);

    /**
     * Update utilisateur.
     *
     * @param salle the salle
     */
    public void updateSalle(Salle salle);

    /**
     * Gets the utilisateur by id.
     *
     * @param id the id
     * @return the utilisateur by id
     */
    public Salle getSalleById(Long id);

    /**
     * Gets the all.
     *
     * @return the all
     */
    public List<Salle> getAll();

    /**
     * Delete utilisateur.
     *
     * @param id the id
     */
    public void deleteSalle(Long id);
}
