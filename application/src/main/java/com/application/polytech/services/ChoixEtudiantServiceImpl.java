package com.application.polytech.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.application.polytech.dao.ChoixEtudiantDao;
import com.application.polytech.model.ChoixEtudiant;
import com.application.polytech.model.Utilisateur;

/**
 * The Class ChoixEtudiantServiceImpl.
 */
@Service("choixEtudiantService")
@Transactional
public class ChoixEtudiantServiceImpl implements ChoixEtudiantService {

    /** The choix etudiant dao. */
    @Autowired
    ChoixEtudiantDao choixEtudiantDao;

    /*
     * (non-Javadoc)
     * @see com.application.polytech.services.UtilisateurService#enregistrerChoixEtudiant(java.lang.Long, java.lang.Long)
     */
    @Override
    public void enregistrerChoixEtudiant(final ChoixEtudiant choixEtudiant) {
        // On teste si l'id correspond bien à un étudiant
        final Long idEtu = this.choixEtudiantDao.getIdEtudiantById(choixEtudiant.getId_etudiant());

        // On teste si l'id correspond bien à une entreprise
        final Long idEnt = this.choixEtudiantDao.getIdEntrepriseById(choixEtudiant.getId_entreprise());

        // Si l'étudiant et l'entreprise existent
        if (idEnt != null && idEtu != null) {
            this.choixEtudiantDao.addChoixEtudiant(new ChoixEtudiant(idEtu, idEnt, choixEtudiant.getOrdre(), choixEtudiant.getDuree()));
        }
    }

    /*
     * (non-Javadoc)
     * @see com.application.polytech.services.ChoixEtudiantService#getListEntrepriseByIdEtudiant(java.lang.Long)
     */
    @Override
    public List<Utilisateur> getListEntrepriseByIdEtudiant(final Long id) {
        return this.choixEtudiantDao.getListEntrepriseByIdEtudiant(id);
    }

    /*
     * (non-Javadoc)
     * @see com.application.polytech.services.ChoixEtudiantService#getListEntreprise()
     */
    @Override
    public List<Utilisateur> getListEntreprise() {
        return this.choixEtudiantDao.getListEntreprise();
    }

    /*
     * (non-Javadoc)
     * @see com.application.polytech.services.ChoixEtudiantService#listerEntrepriseNonAjoutee(java.lang.Long)
     */
    @Override
    public List<Utilisateur> listerEntrepriseNonAjoutee(final Long id) {
        return this.choixEtudiantDao.listerEntrepriseNonAjoutee(id);
    }

    /*
     * (non-Javadoc)
     * @see com.application.polytech.services.ChoixEtudiantService#deleteChoixEtudiant(java.lang.Long, java.lang.Long)
     */
    @Override
    public void deleteChoixEtudiant(final Long idEtudiant, final Long idEntreprise) {
        this.choixEtudiantDao.deleteChoixEtudiant(idEtudiant, idEntreprise);
    }

}
