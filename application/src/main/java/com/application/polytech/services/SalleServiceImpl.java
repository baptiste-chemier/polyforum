package com.application.polytech.services;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.application.polytech.dao.SalleDao;
import com.application.polytech.model.Entreprise;
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

    /*
     * (non-Javadoc)
     * @see com.application.polytech.services.SalleService#affecterSalle(java.util.HashMap, java.util.HashMap)
     */
    @Override
    public void affecterSalle(final HashMap<Long, Salle> salles, final HashMap<Long, Entreprise> entreprises) {

        // On parcourt la liste de salles
        for (final Long idSalle : salles.keySet()) {
            final Salle salle = salles.get(idSalle);
            // On parcourt la map d'entreprises
            for (final Long idEntreprise : entreprises.keySet()) {
                final Entreprise entreprise = entreprises.get(idEntreprise);
                // Si le nombre d'entreprise dans la salle est inférieur à la capacité max : on peut ajouter des entreprises à la salle
                if (salle.getEntreprises().size() < salle.getCapacite()) {
                    // Si la salle n'a pas encore l'entreprise dans sa liste et que l'entreprise n'a pas de salle = on peut ajouter l'entreprise à la salle
                    if (salle.getEntreprises().get(idEntreprise) == null && entreprise.getIdSalle() == null) {
                        entreprises.get(idEntreprise).setIdSalle(salle.getId());
                        salle.getEntreprises().put(idEntreprise, entreprise);
                    }
                }
            }
        }
    }
}
