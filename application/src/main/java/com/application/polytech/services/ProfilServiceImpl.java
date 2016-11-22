package com.application.polytech.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.application.polytech.dao.ProfilDao;
import com.application.polytech.model.Profil;

/**
 * The Class ProfilServiceImpl.
 */
@Service("profilService")
@Transactional
public class ProfilServiceImpl implements ProfilService {

    /** The profil dao. */
    @Autowired
    ProfilDao profilDao;

    /*
     * (non-Javadoc)
     * @see com.application.polytech.services.ProfilService#getProfilById(java.lang.Long)
     */
    @Override
    public Profil getProfilById(final Long id) {
        return this.profilDao.getProfilById(id);
    }

    /*
     * (non-Javadoc)
     * @see com.application.polytech.services.ProfilService#getAll()
     */
    @Override
    public List<Profil> getAll() {
        return this.profilDao.getAll();
    }

    /*
     * (non-Javadoc)
     * @see com.application.polytech.services.ProfilService#getLibelleById(java.lang.Long)
     */
    @Override
    public String getLibelleById(final Long id) {
        return this.profilDao.getLibelleById(id);
    }

}
