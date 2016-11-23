package com.application.polytech.services;

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
     * Update forum.
     *
     * @param id the id
     * @param date the date
     * @param heureDebut the heure debut
     * @param heureFin the heure fin
     * @param minDebut the min debut
     * @param minFin the min fin
     */
    public void updateForum(final Long id, final String date, final Integer heureDebut, final Integer heureFin, final Integer minDebut, final Integer minFin);
}
