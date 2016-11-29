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

import com.application.polytech.model.ChoixEtudiant;
import com.application.polytech.model.Utilisateur;
import com.application.polytech.services.ChoixEtudiantService;

/**
 * The Class ChoixEtudiantController.
 */
@Controller
@RequestMapping("/choixEtudiant")
public class ChoixEtudiantController {

    /** The choix etudiant service. */
    @Autowired
    ChoixEtudiantService choixEtudiantService;

    /** The Constant logger. */
    static final Logger logger = Logger.getLogger(ChoixEtudiantController.class);

    /**
     * Enregistrer choix etudiant.
     *
     * @param choixEtudiant the choix etudiant
     */
    @RequestMapping(value = "/ajouter", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody void enregistrerChoixEtudiant(@RequestBody final ChoixEtudiant choixEtudiant) {
        this.choixEtudiantService.enregistrerChoixEtudiant(choixEtudiant);
    }

    /**
     * Delete choix etudiant.
     *
     * @param idEtudiant the id etudiant
     * @param idEntreprise the id entreprise
     */
    @RequestMapping(value = "/supprimer/{idEtudiant}/{idEntreprise}", method = RequestMethod.GET)
    public @ResponseBody void deleteChoixEtudiant(@PathVariable("idEtudiant") final Long idEtudiant, @PathVariable("idEntreprise") final Long idEntreprise) {
        this.choixEtudiantService.deleteChoixEtudiant(idEtudiant, idEntreprise);
    }

    /**
     * Gets the list entreprise by id etudiant.
     *
     * @param id the id
     * @return the list entreprise by id etudiant
     */
    @RequestMapping(value = "/lister/{idEtudiant}", method = RequestMethod.GET)
    public @ResponseBody List<Utilisateur> getListEntrepriseByIdEtudiant(@PathVariable("idEtudiant") final Long id) {
        return this.choixEtudiantService.getListEntrepriseByIdEtudiant(id);
    }

    /**
     * Gets the list entreprise.
     *
     * @return the list entreprise
     */
    @RequestMapping(value = "/lister", method = RequestMethod.GET)
    public @ResponseBody List<Utilisateur> getListEntreprise() {
        return this.choixEtudiantService.getListEntreprise();
    }

    /**
     * Lister entreprise non ajoutee.
     *
     * @param id the id
     * @return the list
     */
    @RequestMapping(value = "/listerEntrepriseNonAjoutee/{idEtudiant}", method = RequestMethod.GET)
    public @ResponseBody List<Utilisateur> listerEntrepriseNonAjoutee(@PathVariable("idEtudiant") final Long id) {
        return this.choixEtudiantService.listerEntrepriseNonAjoutee(id);
    }
}
