package com.application.polytech.dao;

import java.util.List;

import com.application.polytech.model.Entretien;
import com.application.polytech.model.EntretienDTO;

/**
 * The Interface EntretienDao.
 */
public interface EntretienDao {

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
     * Recuperer matrice.
     *
     * @return the list
     */
    public List<EntretienDTO> recupererMatrice();

    /**
     * Delete all.
     */
    public void deleteAll();

    /**
     * Recuperer entretien etudiant avec rdv.
     *
     * @param idEtudiant the id etudiant
     * @return the list
     */
    public List<Entretien> recupererEntretienEtudiantAvecRdv(Long idEtudiant);
}
