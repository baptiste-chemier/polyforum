package com.application.polytech.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.application.polytech.dao.ForumDao;
import com.application.polytech.model.Forum;

/**
 * The Class ForumServiceImpl.
 */
@Service("forumService")
@Transactional
public class ForumServiceImpl implements ForumService {

    /** The forum dao. */
    @Autowired
    ForumDao forumDao;

    /*
     * (non-Javadoc)
     * @see com.application.polytech.services.ForumService#addForum(com.application.polytech.model.Forum)
     */
    @Override
    public void addForum(final Forum forum) {
        this.forumDao.addForum(forum);
    }

    /*
     * (non-Javadoc)
     * @see com.application.polytech.services.ForumService#getForumById(java.lang.Long)
     */
    @Override
    public Forum getForumById(final Long id) {
        return this.forumDao.getForumById(id);
    }

    /*
     * (non-Javadoc)
     * @see com.application.polytech.services.ForumService#updateForum(java.lang.Long, java.lang.String, java.lang.Integer, java.lang.Integer, java.lang.Integer, java.lang.Integer)
     */
    @Override
    public void updateForum(final Long id, final Date dateDebutForum, final Date dateFinForum, final String email) {
        final Forum forumModifie = this.forumDao.getForumById(id);

        if (forumModifie != null) {
            // final SimpleDateFormat sdf = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");
            // final Date format = sdf.parse(date);
            // final Calendar dateDebut = Calendar.getInstance();
            //
            // dateDebut.setTime(format);
            // dateDebut.set(Calendar.HOUR, heureDebut);
            // dateDebut.set(Calendar.MINUTE, minDebut);
            // dateDebut.set(Calendar.SECOND, 0);
            // dateDebut.set(Calendar.MILLISECOND, 0);
            //
            // final Calendar dateFin = Calendar.getInstance();
            // dateFin.setTime(format);
            // dateFin.set(Calendar.HOUR, heureFin);
            // dateFin.set(Calendar.MINUTE, minFin);
            // dateFin.set(Calendar.SECOND, 0);
            // dateFin.set(Calendar.MILLISECOND, 0);

            forumModifie.setDateDebutForum(dateDebutForum);
            forumModifie.setDateDebutForum(dateFinForum);
            forumModifie.setEmail(email);

            this.forumDao.updateForum(forumModifie);
        }
    }

    /*
     * (non-Javadoc)
     * @see com.application.polytech.services.ForumService#getAll()
     */
    @Override
    public List<Forum> getAll() {
        return this.forumDao.getAll();
    }

}
