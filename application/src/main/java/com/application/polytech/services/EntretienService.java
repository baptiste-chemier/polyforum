package com.application.polytech.services;

import java.util.List;

import com.application.polytech.model.Entretien;

/**
 * The Interface EntretienService.
 */
public interface EntretienService {

    /**
     * Adds the entretien.
     *
     * @param entretien the entretien
     */
    public void addEntretien(final Entretien entretien);

    /**
     * Gets the all.
     *
     * @return the all
     */
    public List<Entretien> getAll();

    /**
     * Generer planning.
     *
     * @param idForum the id forum
     */
    public void genererPlanning(final Long idForum);

    /**
     * Delete all.
     */
    public void deleteAll();

}
