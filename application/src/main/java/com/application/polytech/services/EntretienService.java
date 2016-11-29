package com.application.polytech.services;

import java.util.List;

import com.application.polytech.model.Entretien;

/**
 * The Interface EntretienService.
 */
public interface EntretienService {

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

}
