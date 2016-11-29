package com.application.polytech.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.application.polytech.model.Entretien;
import com.application.polytech.services.EntretienService;

/**
 * The Class EntretienController.
 */
@Controller
@RequestMapping("/entretien")
public class EntretienController {

    /** The entretien service. */
    @Autowired
    EntretienService entretienService;

    /** The Constant logger. */
    static final Logger logger = Logger.getLogger(EntretienController.class);

    /**
     * Gets the all.
     *
     * @return the all
     */
    @RequestMapping(value = "/lister", method = RequestMethod.GET)
    public @ResponseBody List<Entretien> getAll() {
        return this.entretienService.getAll();
    }

    /**
     * Generer planning.
     *
     * @param id the id
     */
    @RequestMapping(value = "/genererPlanning/{id}", method = RequestMethod.GET)
    public @ResponseBody void genererPlanning(@PathVariable("id") final Long id) {
        this.entretienService.genererPlanning(id);
    }
}
