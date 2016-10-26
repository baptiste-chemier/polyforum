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

import com.application.polytech.model.Salle;
import com.application.polytech.services.SalleService;

@Controller
@RequestMapping("/salle")
public class SalleController {

    @Autowired
    SalleService salleService;

    /** The Constant logger. */
    static final Logger logger = Logger.getLogger(SalleController.class);

    /**
     * Adds the salle.
     *
     * @param salle the salle
     */
    @RequestMapping(value = "/ajouter", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody void addSalle(@RequestBody final Salle salle) {
        this.salleService.addSalle(salle);
    }

    /**
     * Update salle.
     *
     * @param salle the salle
     */
    @RequestMapping(value = "/modifier", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody void updateSalle(@RequestBody final Salle salle) {
        this.salleService.updateSalle(salle);
    }

    /**
     * Gets the salle by id.
     *
     * @param id the id
     * @return the salle by id
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public @ResponseBody Salle getSalleById(@PathVariable("id") final Long id) {
        Salle salle = null;
        try {
            salle = this.salleService.getSalleById(id);

        } catch (final Exception e) {
            e.printStackTrace();
        }
        return salle;
    }

    /**
     * Gets the all.
     *
     * @return the all
     */
    @RequestMapping(value = "/lister", method = RequestMethod.GET)
    public @ResponseBody List<Salle> getAll() {
        List<Salle> listSalle = null;
        try {
            listSalle = this.salleService.getAll();

        } catch (final Exception e) {
            e.printStackTrace();
        }
        return listSalle;
    }

    /**
     * Delete salle.
     *
     * @param id the id
     */
    @RequestMapping(value = "supprimer/{id}", method = RequestMethod.GET)
    public @ResponseBody void deleteSalle(@PathVariable("id") final Long id) {
        this.salleService.deleteSalle(id);
    }
}
