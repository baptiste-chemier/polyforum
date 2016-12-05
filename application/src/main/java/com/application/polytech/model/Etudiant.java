package com.application.polytech.model;

import java.io.Serializable;
import java.util.Date;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

/**
 * The Class Etudiant.
 */
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Etudiant implements Serializable {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 1L;

    /** The id etudiant. */
    private Long idEtudiant;

    /** The date debut dispo. */
    private Date dateDebutDispo;

    /** The date fin dispo. */
    private Date dateFinDispo;

    /**
     * Instantiates a new etudiant.
     *
     * @param idEtudiant the id etudiant
     * @param dateDebutForum the date debut forum
     * @param dateFinDispo the date fin dispo
     */
    public Etudiant(final Long idEtudiant, final Date dateDebutForum, final Date dateFinDispo) {
        this.idEtudiant = idEtudiant;
        this.dateDebutDispo = dateDebutForum;
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

    /**
     * Gets the id etudiant.
     *
     * @return the id etudiant
     */
    public final Long getIdEtudiant() {
        return this.idEtudiant;
    }

    /**
     * Sets the id etudiant.
     *
     * @param idEtudiant the new id etudiant
     */
    public final void setIdEtudiant(final Long idEtudiant) {
        this.idEtudiant = idEtudiant;
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

    /*
     * (non-Javadoc)
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(final Object obj) {
        if (this.idEtudiant == ((Etudiant) obj).idEtudiant) {
            return true;
        } else {
            return false;
        }
    }
}
