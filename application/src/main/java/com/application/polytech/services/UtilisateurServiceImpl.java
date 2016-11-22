package com.application.polytech.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.application.polytech.dao.ChoixEtudiantDao;
import com.application.polytech.dao.UtilisateurDao;
import com.application.polytech.model.ChoixEtudiant;
import com.application.polytech.model.Utilisateur;

/**
 * The Class UtilisateurServiceImpl.
 */
@Service("utilisateurService")
@Transactional
public class UtilisateurServiceImpl implements UtilisateurService {

    /** The utilisateur dao. */
    @Autowired
    UtilisateurDao utilisateurDao;

    /** The choix etudiant dao. */
    @Autowired
    ChoixEtudiantDao choixEtudiantDao;

    /*
     * (non-Javadoc)
     * @see com.application.polytech.services.UtilisateurService#addUtilisateur(com.application.polytech.model.Utilisateur)
     */
    @Override
    public void addUtilisateur(final Utilisateur utilisateur) {
        this.utilisateurDao.addUtilisateur(utilisateur);
    }

    /*
     * (non-Javadoc)
     * @see com.application.polytech.services.UtilisateurService#updateUtilisateur(com.application.polytech.model.Utilisateur)
     */
    @Override
    public void updateUtilisateur(final Long id, final Utilisateur utilisateur) {
        this.utilisateurDao.updateUtilisateur(id, utilisateur);
    }

    /*
     * (non-Javadoc)
     * @see com.application.polytech.services.UtilisateurService#getUtilisateurById(java.lang.Long)
     */
    @Override
    public Utilisateur getUtilisateurById(final Long id) {
        return this.utilisateurDao.getUtilisateurById(id);
    }

    /*
     * (non-Javadoc)
     * @see com.application.polytech.services.UtilisateurService#getAll()
     */
    @Override
    public List<Utilisateur> getAll() {
        return this.utilisateurDao.getAll();
    }

    /*
     * (non-Javadoc)
     * @see com.application.polytech.services.UtilisateurService#deleteUtilisateur(java.lang.Long)
     */
    @Override
    public void deleteUtilisateur(final Long id) {
        this.utilisateurDao.deleteUtilisateur(id);
    }

    /*
     * (non-Javadoc)
     * @see com.application.polytech.services.UtilisateurService#connecter(java.lang.String, java.lang.String)
     */
    @Override
    public Utilisateur connecter(final String login, final String password) {
        return this.utilisateurDao.connecter(login, password);
    }

    /*
     * (non-Javadoc)
     * @see com.application.polytech.services.UtilisateurService#enregistrerChoixEtudiant(java.lang.Long, java.lang.Long)
     */
    @Override
    public void enregistrerChoixEtudiant(final Long idEtudiant, final Long idEntreprise) {
        this.choixEtudiantDao.addChoixEtudiant(new ChoixEtudiant(idEtudiant, idEntreprise));
    }
}
