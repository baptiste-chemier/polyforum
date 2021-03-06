package com.application.polytech.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.application.polytech.model.Forum;

/**
 * The Class ForumDaoImpl.
 */
@Repository("forumDao")
public class ForumDaoImpl extends AbstractDao implements ForumDao {

    /*
     * (non-Javadoc)
     * @see com.application.polytech.dao.UtilisateurDao#addUtilisateur(com.application.polytech.model.Utilisateur)
     */
    @Override
    public void addForum(final Forum forum) {
        this.persist(forum);
    }

    /*
     * (non-Javadoc)
     * @see com.application.polytech.dao.ForumDao#getForumById(java.lang.Long)
     */
    @Override
    public Forum getForumById(final Long id) {
        final Criteria criteria = this.getSession().createCriteria(Forum.class);
        criteria.add(Restrictions.eq("id", id));
        return (Forum) criteria.uniqueResult();
    }

    /*
     * (non-Javadoc)
     * @see com.application.polytech.dao.UtilisateurDao#updateUtilisateur(com.application.polytech.model.Utilisateur)
     */
    @Override
    public void updateForum(final Forum forum) {
        final Forum forumModifie = this.getForumById(forum.getId());
        forumModifie.setDateDebutForum(forum.getDateDebutForum());
        forumModifie.setDateFinForum(forumModifie.getDateFinForum());

        this.getSession().update(forumModifie);
    }

    /*
     * (non-Javadoc)
     * @see com.application.polytech.dao.ForumDao#getAll()
     */
    @Override
    public List<Forum> getAll() {
        final Criteria criteria = this.getSession().createCriteria(Forum.class);
        return criteria.list();
    }
}
