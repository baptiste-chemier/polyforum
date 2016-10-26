package com.application.polytech.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.application.polytech.model.Utilisateur;
import com.application.polytech.services.UtilisateurService;

/**
 * The Class UtilisateurController.
 */
@Controller
@RequestMapping("/utilisateur")
public class UtilisateurController {

    /** The data services. */
    @Autowired
    UtilisateurService dataServices;

    /** The Constant logger. */
    static final Logger logger = Logger.getLogger(UtilisateurController.class);

    /**
     * Adds the utilisateur.
     *
     * @param utilisateur the utilisateur
     */
    @RequestMapping(value = "/ajouter", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody void addUtilisateur(@RequestBody final Utilisateur utilisateur) {
        this.dataServices.addUtilisateur(utilisateur);
    }

    /**
     * Update utilisateur.
     *
     * @param utilisateur the utilisateur
     */
    @RequestMapping(value = "/modifier", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody void updateUtilisateur(@RequestBody final Utilisateur utilisateur) {
        this.dataServices.updateUtilisateur(utilisateur);
    }

    /**
     * Gets the utilisateur by id.
     *
     * @param id the id
     * @return the utilisateur by id
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public @ResponseBody Utilisateur getUtilisateurById(@PathVariable("id") final Long id) {
        Utilisateur utilisateur = null;
        try {
            utilisateur = this.dataServices.getUtilisateurById(id);

        } catch (final Exception e) {
            e.printStackTrace();
        }
        return utilisateur;
    }

    /**
     * Gets the all.
     *
     * @return the all
     */
    @RequestMapping(value = "/lister", method = RequestMethod.GET)
    public @ResponseBody List<Utilisateur> getAll() {
        List<Utilisateur> listUtilisateur = null;
        try {
            listUtilisateur = this.dataServices.getAll();

        } catch (final Exception e) {
            e.printStackTrace();
        }
        return listUtilisateur;
    }

    /**
     * Delete utilisateur.
     *
     * @param id the id
     */
    @RequestMapping(value = "supprimer/{id}", method = RequestMethod.GET)
    public @ResponseBody void deleteUtilisateur(@PathVariable("id") final Long id) {
        this.dataServices.deleteUtilisateur(id);
    }
}
