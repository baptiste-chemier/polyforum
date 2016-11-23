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

    /** The date debut dispo. */
    @Column(name = "date_debut_dispo")
    private Date dateDebutDispo;

    /** The date fin dispo. */
    @Column(name = "date_fin_dispo")
    private Date dateFinDispo;

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
     * Gets the date debut dispo.
     *
     * @return the date debut dispo
     */
    public final Date getDateDebutDispo() {
        return this.dateDebutDispo;
    }

    /**
     * Sets the date debut dispo.
     *
     * @param dateDebutDispo the new date debut dispo
     */
    public final void setDateDebutDispo(final Date dateDebutDispo) {
        this.dateDebutDispo = dateDebutDispo;
    }

    /**
     * Gets the date fin dispo.
     *
     * @return the date fin dispo
     */
    public final Date getDateFinDispo() {
        return this.dateFinDispo;
    }

    /**
     * Sets the date fin dispo.
     *
     * @param dateFinDispo the new date fin dispo
     */
    public final void setDateFinDispo(final Date dateFinDispo) {
        this.dateFinDispo = dateFinDispo;
    }

    /**
     * Gets the serialversionuid.
     *
     * @return the serialversionuid
     */
    public static final long getSerialversionuid() {
        return serialVersionUID;
    }

}
