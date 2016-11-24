package com.application.polytech.dao;

import java.util.List;

import com.application.polytech.model.Forum;

/**
 * The Interface ForumDao.
 */
public interface ForumDao {

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
     * @param forum the forum
     */
    public void updateForum(final Forum forum);
}
