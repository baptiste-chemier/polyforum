package application.polyforum.web.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import application.polyforum.model.Etudiant;
import application.polyforum.repository.EtudiantRepository;

/**
 * The Class EtudiantController.
 */
@RestController
@RequestMapping(value = "/api")
public class EtudiantController {

    /** The etudiant repository. */
    @Resource
    private EtudiantRepository etudiantRepository;

    /**
     * Gets the etudiant.
     *
     * @param etudiantId the etudiant id
     * @return the etudiant
     */
    @RequestMapping(value = "/etudiant/{etudiantId}", method = RequestMethod.GET)
    public Etudiant getEtudiant(@PathVariable final Long etudiantId) {
        return this.etudiantRepository.getEtudiant(etudiantId);
    }

    /**
     * Gets the list etudiants.
     *
     * @return the list etudiants
     */
    @RequestMapping(value = "/listEtudiants", method = RequestMethod.GET)
    public List<Etudiant> getListEtudiants() {
        return this.etudiantRepository.getAll();
    }
}
