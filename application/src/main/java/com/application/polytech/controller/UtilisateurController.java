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

import com.application.polytech.model.Connexion;
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
     * @param id the id
     * @param utilisateur the utilisateur
     */
    @RequestMapping(value = "/modifier/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody void updateUtilisateur(@PathVariable("id") final Long id, @RequestBody final Utilisateur utilisateur) {
        this.utilisateurService.updateUtilisateur(id, utilisateur);
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
        utilisateur = this.utilisateurService.getUtilisateurById(id);
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
        listUtilisateur = this.utilisateurService.getAll();
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
     * @param connexion the connexion
     * @return the boolean
     */
    @RequestMapping(value = "/connecter", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody Utilisateur connecter(@RequestBody final Connexion connexion) {
        final Utilisateur utilisateur = this.utilisateurService.connecter(connexion.getEmail(), connexion.getPassword());
        if (utilisateur != null) {
            return utilisateur;
        } else {
            return null;
        }
    }

    /**
     * Enregistrer choix etudiant.
     *
     * @param idEtudiant the id etudiant
     * @param idEntreprise the id entreprise
     */
    @RequestMapping(value = "/enregistrerChoixEtudiant/{idEtudiant}/{idEntreprise}", method = RequestMethod.POST)
    public @ResponseBody void enregistrerChoixEtudiant(@PathVariable("idEtudiant") final Long idEtudiant, @PathVariable("idEntreprise") final Long idEntreprise) {
        this.utilisateurService.enregistrerChoixEtudiant(idEtudiant, idEntreprise);
    }

    /**
     * Enregistrer choix entreprise.
     *
     * @param idEntreprise the id entreprise
     * @param idEtudiant the id etudiant
     */
    @RequestMapping(value = "/enregistrerChoixEntreprise/{idEntreprise}/{idEtudiant}", method = RequestMethod.POST)
    public @ResponseBody void enregistrerChoixEntreprise(@PathVariable("idEntreprise") final Long idEntreprise, @PathVariable("idEtudiant") final Long idEtudiant) {
        this.utilisateurService.enregistrerChoixEntreprise(idEntreprise, idEtudiant);
    }

    /**
     * Importer utilisateur excel.
     */
    @RequestMapping(value = "/importerUtilisateurExcel", method = RequestMethod.GET)
    public @ResponseBody void importerUtilisateurExcel() {
        this.utilisateurService.importerUtilisateurExcel("C:/fichePolyforum.xlsx");
    }
}
