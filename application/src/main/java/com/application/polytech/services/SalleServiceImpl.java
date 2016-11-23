package com.application.polytech.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.application.polytech.dao.SalleDao;
import com.application.polytech.model.Salle;

/**
 * The Class SalleServiceImpl.
 */
@Service("salleService")
@Transactional
public class SalleServiceImpl implements SalleService {

    /** The salle dao. */
    @Autowired
    SalleDao salleDao;

    /*
     * (non-Javadoc)
     * @see com.application.polytech.services.SalleService#addSalle(com.application.polytech.model.Salle)
     */
    @Override
    public void addSalle(final Salle salle) {
        this.salleDao.addSalle(salle);
    }

    /*
     * (non-Javadoc)
     * @see com.application.polytech.services.SalleService#updateSalle(com.application.polytech.model.Salle)
     */
    @Override
    public void updateSalle(final Long id, final Salle salle) {
        this.salleDao.updateSalle(id, salle);
    }

    /*
     * (non-Javadoc)
     * @see com.application.polytech.services.SalleService#getSalleById(java.lang.Long)
     */
    @Override
    public Salle getSalleById(final Long id) {
        return this.salleDao.getSalleById(id);
    }

    /*
     * (non-Javadoc)
     * @see com.application.polytech.services.SalleService#getAll()
     */
    @Override
    public List<Salle> getAll() {
        return this.salleDao.getAll();
    }

    /*
     * (non-Javadoc)
     * @see com.application.polytech.services.SalleService#deleteSalle(java.lang.Long)
     */
    @Override
    public void deleteSalle(final Long id) {
        this.salleDao.deleteSalle(id);
    }

}
