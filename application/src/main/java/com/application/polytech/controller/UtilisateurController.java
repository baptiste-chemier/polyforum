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

    /** The utilisateur service. */
    @Autowired
    UtilisateurService utilisateurService;

    /** The Constant logger. */
    static final Logger logger = Logger.getLogger(UtilisateurController.class);

    /**
     * Adds the utilisateur.
     *
     * @param utilisateur the utilisateur
     */
    @RequestMapping(value = "/ajouter", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody void addUtilisateur(@RequestBody final Utilisateur utilisateur) {
        this.utilisateurService.addUtilisateur(utilisateur);
    }

    /**
     * Update utilisateur.
     *
     * @param utilisateur the utilisateur
     */
    @RequestMapping(value = "/modifier", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody void updateUtilisateur(@RequestBody final Utilisateur utilisateur) {
        this.utilisateurService.updateUtilisateur(utilisateur);
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
            utilisateur = this.utilisateurService.getUtilisateurById(id);

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
            listUtilisateur = this.utilisateurService.getAll();

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
    @RequestMapping(value = "/supprimer/{id}", method = RequestMethod.GET)
    public @ResponseBody void deleteUtilisateur(@PathVariable("id") final Long id) {
        this.utilisateurService.deleteUtilisateur(id);
    }

    /**
     * Connecter.
     *
     * @param login the login
     * @param password the password
     * @return the boolean
     */
    @RequestMapping(value = "/connecter", method = RequestMethod.POST)
    public @ResponseBody Boolean connecter(@PathVariable("login") final String login, @PathVariable("password") final String password) {
        if (this.utilisateurService.connecter(login, password) != null) {
            return true;
        } else {
            return false;
        }
    }
}
