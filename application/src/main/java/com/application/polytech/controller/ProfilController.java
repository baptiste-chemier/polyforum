package com.application.polytech.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.application.polytech.model.Profil;
import com.application.polytech.services.ProfilService;

/**
 * The Class ProfilController.
 */
@Controller
@RequestMapping("/profil")
public class ProfilController {

    /** The profil service. */
    @Autowired
    ProfilService profilService;

    /** The Constant logger. */
    static final Logger logger = Logger.getLogger(ProfilController.class);

    /**
     * Gets the profil by id.
     *
     * @param id the id
     * @return the profil by id
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public @ResponseBody Profil getProfilById(@PathVariable("id") final Long id) {
        return this.profilService.getProfilById(id);
    }

    /**
     * Gets the all.
     *
     * @return the all
     */
    @RequestMapping(value = "/lister", method = RequestMethod.GET)
    public @ResponseBody List<Profil> getAll() {
        return this.profilService.getAll();
    }

    /**
     * Gets the libelle by id.
     *
     * @param id the id
     * @return the libelle by id
     */
    @RequestMapping(value = "/recupererLibelle/{id}", method = RequestMethod.GET)
    public @ResponseBody String getLibelleById(@PathVariable("id") final Long id) {
        return this.profilService.getLibelleById(id);
    }
}
