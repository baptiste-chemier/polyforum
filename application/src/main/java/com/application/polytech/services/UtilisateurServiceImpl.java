package com.application.polytech.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.application.polytech.dao.UtilisateurDao;
import com.application.polytech.model.Utilisateur;

/**
 * The Class DataServicesImpl.
 */
public class UtilisateurServiceImpl implements UtilisateurService {

    /** The utilisateur dao. */
    @Autowired
    UtilisateurDao utilisateurDao;

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

}
