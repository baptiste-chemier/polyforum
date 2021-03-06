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

import com.application.polytech.model.ChoixEntreprise;
import com.application.polytech.model.Utilisateur;
import com.application.polytech.services.ChoixEntrepriseService;

/**
 * The Class ChoixEntrepriseController.
 */
@Controller
@RequestMapping("/choixEntreprise")
public class ChoixEntrepriseController {

    /** The choix entreprise service. */
    @Autowired
    ChoixEntrepriseService choixEntrepriseService;

    /** The Constant logger. */
    static final Logger logger = Logger.getLogger(ChoixEntrepriseController.class);

    /**
     * Enregistrer choix entreprise.
     *
     * @param choixEntreprise the choix entreprise
     */
    @RequestMapping(value = "/ajouter", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody void enregistrerChoixEntreprise(@RequestBody final ChoixEntreprise choixEntreprise) {
        this.choixEntrepriseService.enregistrerChoixEntreprise(choixEntreprise);
    }

    /**
     * Delete choix entreprise.
     *
     * @param idEntreprise the id entreprise
     * @param idEtudiant the id etudiant
     */
    @RequestMapping(value = "/supprimer/{idEntreprise}/{idEtudiant}", method = RequestMethod.GET)
    public @ResponseBody void deleteChoixEntreprise(@PathVariable("idEntreprise") final Long idEntreprise, @PathVariable("idEtudiant") final Long idEtudiant) {
        this.choixEntrepriseService.deleteChoixEntreprise(idEntreprise, idEtudiant);
    }

    /**
     * Gets the list etudiant by id entreprise.
     *
     * @param id the id
     * @return the list etudiant by id entreprise
     */
    @RequestMapping(value = "/lister/{idEntreprise}", method = RequestMethod.GET)
    public @ResponseBody List<Utilisateur> getListEtudiantByIdEntreprise(@PathVariable("idEntreprise") final Long id) {
        return this.choixEntrepriseService.getListEtudiantByIdEntreprise(id);
    }

    /**
     * Gets the list etudiant.
     *
     * @return the list etudiant
     */
    @RequestMapping(value = "/lister", method = RequestMethod.GET)
    public @ResponseBody List<Utilisateur> getListEtudiant() {
        return this.choixEntrepriseService.getListEtudiant();
    }

    /**
     * Lister etudiant non ajoutee.
     *
     * @param id the id
     * @return the list
     */
    @RequestMapping(value = "/listerEtudiantNonAjoutee/{idEntreprise}", method = RequestMethod.GET)
    public @ResponseBody List<Utilisateur> listerEtudiantNonAjoutee(@PathVariable("idEntreprise") final Long id) {
        return this.choixEntrepriseService.listerEtudiantNonAjoutee(id);
    }
}
