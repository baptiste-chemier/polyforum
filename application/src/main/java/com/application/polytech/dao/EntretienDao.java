package com.application.polytech.dao;

import java.util.List;

import com.application.polytech.model.Entretien;
import com.application.polytech.model.EntretienDTO;

/**
 * The Interface EntretienDao.
 */
public interface EntretienDao {

    /**
     * Gets the all.
     *
     * @return the all
     */
    public List<Entretien> getAll();

    /**
     * Recuperer matrice.
     *
     * @return the list
     */
    public List<EntretienDTO> recupererMatrice();
}