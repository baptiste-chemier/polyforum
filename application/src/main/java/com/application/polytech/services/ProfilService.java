package com.application.polytech.services;

import java.util.List;

import com.application.polytech.model.Profil;

/**
 * The Interface ProfilService.
 */
public interface ProfilService {

    /**
     * Gets the profil by id.
     *
     * @param id the id
     * @return the profil by id
     */
    public Profil getProfilById(final Long id);

    /**
     * Gets the all.
     *
     * @return the all
     */
    public List<Profil> getAll();

    /**
     * Gets the libelle by id.
     *
     * @param id the id
     * @return the libelle by id
     */
    public String getLibelleById(Long id);

}
