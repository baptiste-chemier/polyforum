package com.application.polytech.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.application.polytech.dao.ChoixEntrepriseDao;
import com.application.polytech.model.ChoixEntreprise;
import com.application.polytech.model.Utilisateur;

/**
 * The Class ChoixEntrepriseServiceImpl.
 */
@Service("choixEntrepriseService")
@Transactional
public class ChoixEntrepriseServiceImpl implements ChoixEntrepriseService {

    /** The choix entreprise dao. */
    @Autowired
    ChoixEntrepriseDao choixEntrepriseDao;

    /*
     * (non-Javadoc)
     * @see com.application.polytech.services.UtilisateurService#enregistrerChoixEntreprise(java.lang.Long, java.lang.Long)
     */
    @Override
    public void enregistrerChoixEntreprise(final ChoixEntreprise choixEntreprise) {
        final Long idEnt = this.choixEntrepriseDao.getIdEntrepriseById(choixEntreprise.getId_entreprise());
        final Long idEtu = this.choixEntrepriseDao.getIdEtudiantById(choixEntreprise.getId_etudiant());

        if (idEnt != null && idEtu != null) {
            this.choixEntrepriseDao.addChoixEntreprise(new ChoixEntreprise(idEnt, idEtu, choixEntreprise.getOrdre(), choixEntreprise.getDuree()));
        }
    }

    /*
     * (non-Javadoc)
     * @see com.application.polytech.services.ChoixEntrepriseService#getListEtudiantByIdEntreprise(java.lang.Long)
     */
    @Override
    public List<Utilisateur> getListEtudiantByIdEntreprise(final Long id) {
        return this.choixEntrepriseDao.getListEtudiantByIdEntreprise(id);
    }

    /*
     * (non-Javadoc)
     * @see com.application.polytech.services.ChoixEntrepriseService#getListEtudiant()
     */
    @Override
    public List<Utilisateur> getListEtudiant() {
        return this.choixEntrepriseDao.getListEtudiant();
    }

    /*
     * (non-Javadoc)
     * @see com.application.polytech.services.ChoixEntrepriseService#listerEtudiantNonAjoutee(java.lang.Long)
     */
    @Override
    public List<Utilisateur> listerEtudiantNonAjoutee(final Long id) {
        return this.choixEntrepriseDao.listerEtudiantNonAjoutee(id);
    }

    /*
     * (non-Javadoc)
     * @see com.application.polytech.services.ChoixEntrepriseService#deleteChoixEntreprise(java.lang.Long, java.lang.Long)
     */
    @Override
    public void deleteChoixEntreprise(final Long idEntreprise, final Long idEtudiant) {
        this.choixEntrepriseDao.deleteChoixEntreprise(idEntreprise, idEtudiant);
    }
}
