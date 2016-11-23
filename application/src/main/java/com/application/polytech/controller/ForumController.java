package com.application.polytech.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.application.polytech.model.Forum;
import com.application.polytech.model.ForumDTO;
import com.application.polytech.services.ForumService;

/**
 * The Class ForumController.
 */
@Controller
@RequestMapping("/forum")
public class ForumController {

    /** The forum service. */
    @Autowired
    ForumService forumService;

    /** The Constant logger. */
    static final Logger logger = Logger.getLogger(ForumController.class);

    /**
     * Adds the forum.
     *
     * @param forum the forum
     */
    @RequestMapping(value = "/ajouter", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody void addForum(@RequestBody final Forum forum) {
        this.forumService.addForum(forum);
    }

    /**
     * Update utilisateur.
     *
     * @param id the id
     * @param forumDto the forum dto
     */
    @RequestMapping(value = "/modifier/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody void updateUtilisateur(@PathVariable("id") final Long id, @RequestBody final ForumDTO forumDto) {
        this.forumService.updateForum(id, forumDto.getDate(), forumDto.getHeureDebut(), forumDto.getHeureFin(), forumDto.getMinDebut(), forumDto.getMinFin());
    }

    /**
     * Gets the forum by id.
     *
     * @param id the id
     * @return the forum by id
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public @ResponseBody Forum getForumById(@PathVariable("id") final Long id) {
        Forum forum = null;
        forum = this.forumService.getForumById(id);
        return forum;
    }
}
