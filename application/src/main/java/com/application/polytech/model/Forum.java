package com.application.polytech.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

/**
 * The Class Forum.
 */
@Entity
@Table(name = "forum")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Forum implements Serializable {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 1L;

    /** The id. */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    /** The date debut forum. */
    @Column(name = "date_debut_forum")
    private Date dateDebutForum;

    /** The date fin forum. */
    @Column(name = "date_fin_forum")
    private Date dateFinForum;

    /** The email. */
    @Column(name = "email")
    private String email;

    /**
     * Gets the id.
     *
     * @return the id
     */
    public final Long getId() {
        return this.id;
    }

    /**
     * Sets the id.
     *
     * @param id the new id
     */
    public final void setId(final Long id) {
        this.id = id;
    }

    /**
     * Gets the date debut forum.
     *
     * @return the date debut forum
     */
    public final Date getDateDebutForum() {
        return this.dateDebutForum;
    }

    /**
     * Sets the date debut forum.
     *
     * @param dateDebutForum the new date debut forum
     */
    public final void setDateDebutForum(final Date dateDebutForum) {
        this.dateDebutForum = dateDebutForum;
    }

    /**
     * Gets the date fin forum.
     *
     * @return the date fin forum
     */
    public final Date getDateFinForum() {
        return this.dateFinForum;
    }

    /**
     * Sets the date fin forum.
     *
     * @param dateFinForum the new date fin forum
     */
    public final void setDateFinForum(final Date dateFinForum) {
        this.dateFinForum = dateFinForum;
    }

    /**
     * Gets the serialversionuid.
     *
     * @return the serialversionuid
     */
    public static final long getSerialversionuid() {
        return serialVersionUID;
    }

    /**
     * Gets the email.
     *
     * @return the email
     */
    public final String getEmail() {
        return this.email;
    }

    /**
     * Sets the email.
     *
     * @param email the new email
     */
    public final void setEmail(final String email) {
        this.email = email;
    }

}
