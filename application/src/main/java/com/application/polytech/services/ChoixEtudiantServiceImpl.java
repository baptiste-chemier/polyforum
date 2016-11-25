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
        final Long idEtu = this.choixEtudiantDao.getIdEtudiantById(choixEtudiant.getIdEtudiant());
        final Long idEnt = this.choixEtudiantDao.getIdEntrepriseById(choixEtudiant.getIdEntreprise());

        if (idEnt != null && idEtu != null) {
            this.choixEtudiantDao.addChoixEtudiant(new ChoixEtudiant(idEtu, idEnt, choixEtudiant.getOrdre()));
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

    @Override
    public List<Utilisateur> getListEntreprise() {
        return this.choixEtudiantDao.getListEntreprise();
    }

}
