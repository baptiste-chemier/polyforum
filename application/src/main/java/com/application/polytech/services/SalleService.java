package com.application.polytech.services;

import java.util.List;

import com.application.polytech.model.Salle;

/**
 * The Interface SalleService.
 */
public interface SalleService {

    /**
     * Adds the salle.
     *
     * @param salle the salle
     */
    public void addSalle(final Salle salle);

    /**
     * Update salle.
     *
     * @param id the id
     * @param salle the salle
     */
    public void updateSalle(final Long id, final Salle salle);

    /**
     * Gets the salle by id.
     *
     * @param id the id
     * @return the salle by id
     */
    public Salle getSalleById(final Long id);

    /**
     * Gets the all.
     *
     * @return the all
     */
    public List<Salle> getAll();

    /**
     * Delete salle.
     *
     * @param id the id
     */
    public void deleteSalle(Long id);
}
