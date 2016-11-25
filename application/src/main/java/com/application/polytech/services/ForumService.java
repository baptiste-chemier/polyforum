package com.application.polytech.services;

import java.util.Date;
import java.util.List;

import com.application.polytech.model.Forum;

/**
 * The Interface ForumService.
 */
public interface ForumService {

    /**
     * Adds the forum.
     *
     * @param forum the forum
     */
    public void addForum(final Forum forum);

    /**
     * Gets the forum by id.
     *
     * @param id the id
     * @return the forum by id
     */
    public Forum getForumById(final Long id);

    /**
     * Gets the all.
     *
     * @return the all
     */
    public List<Forum> getAll();

    /**
     * Update forum.
     *
     * @param id the id
     * @param dateDebutForum the date debut forum
     * @param dateFinForum the date fin forum
     * @param email the email
     */
    public void updateForum(final Long id, final Date dateDebutForum, final Date dateFinForum, final String email);
}
