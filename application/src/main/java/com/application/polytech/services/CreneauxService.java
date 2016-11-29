package com.application.polytech.services;

import java.util.Date;

import com.application.polytech.model.Salle;

/**
 * The Interface CreneauxService.
 */
public interface CreneauxService {

    /**
     * Checks if is creneaux dispo.
     *
     * @param salle the salle
     * @param dateDebut the date debut
     * @return true, if is creneaux dispo
     */
    public boolean isCreneauxDispo(final Salle salle, Date dateDebut);

}
