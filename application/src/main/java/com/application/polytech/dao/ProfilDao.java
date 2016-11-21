package com.application.polytech.dao;

import java.util.List;

import com.application.polytech.model.Profil;

/**
 * The Interface ProfilDao.
 */
public interface ProfilDao {

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
}
