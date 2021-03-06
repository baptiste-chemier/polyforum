package com.application.polytech.dao;

import java.util.List;

import com.application.polytech.model.ChoixEtudiant;
import com.application.polytech.model.Utilisateur;

/**
 * The Interface ChoixEtudiantDao.
 */
public interface ChoixEtudiantDao {

    /**
     * Adds the choix etudiant.
     *
     * @param choixEtudiant the choix etudiant
     */
    public void addChoixEtudiant(final ChoixEtudiant choixEtudiant);

    /**
     * Gets the id etudiant by id.
     *
     * @param id the id
     * @return the id etudiant by id
     */
    public Long getIdEtudiantById(final Long id);

    /**
     * Gets the id entreprise by id.
     *
     * @param id the id
     * @return the id entreprise by id
     */
    public Long getIdEntrepriseById(final Long id);

    /**
     * Gets the list entreprise by id etudiant.
     *
     * @param id the id
     * @return the list entreprise by id etudiant
     */
    public List<Utilisateur> getListEntrepriseByIdEtudiant(Long id);

    /**
     * Gets the list entreprise.
     *
     * @return the list entreprise
     */
    public List<Utilisateur> getListEntreprise();

    /**
     * Gets the list etudiant.
     *
     * @return the list etudiant
     */
    public List<ChoixEtudiant> getListEtudiant();

    /**
     * Lister entreprise non ajoutee.
     *
     * @param id the id
     * @return the list
     */
    public List<Utilisateur> listerEntrepriseNonAjoutee(Long id);

    /**
     * Delete choix etudiant.
     *
     * @param idEtudiant the id etudiant
     * @param idEntreprise the id entreprise
     */
    public void deleteChoixEtudiant(Long idEtudiant, Long idEntreprise);
}
