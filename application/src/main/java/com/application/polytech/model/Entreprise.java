package com.application.polytech.model;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

/**
 * The Class Entreprise.
 */
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Entreprise implements Serializable {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 1L;

    /** The id entreprise. */
    private Long idEntreprise;

    /** The etudiants. */
    private HashMap<Long, Etudiant> etudiants = new HashMap<Long, Etudiant>();

    /** The id salle. */
    private Long idSalle;

    /** The dernier entretien. */
    private Date dernierEntretien = null;

    /**
     * Instantiates a new entreprise.
     *
     * @param idEntreprise the id entreprise
     */
    public Entreprise(final Long idEntreprise) {
        this.idEntreprise = idEntreprise;
    }

    /**
     * Gets the id entreprise.
     *
     * @return the id entreprise
     */
    public final Long getIdEntreprise() {
        return this.idEntreprise;
    }

    /**
     * Sets the id entreprise.
     *
     * @param idEntreprise the new id entreprise
     */
    public final void setIdEntreprise(final Long idEntreprise) {
        this.idEntreprise = idEntreprise;
    }

    /**
     * Gets the liste etudiants.
     *
     * @return the liste etudiants
     */
    public final HashMap<Long, Etudiant> getListeEtudiants() {
        return this.etudiants;
    }

    /**
     * Sets the liste etudiants.
     *
     * @param etudiants the etudiants
     */
    public final void setListeEtudiants(final HashMap<Long, Etudiant> etudiants) {
        this.etudiants = etudiants;
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
     * Gets the id salle.
     *
     * @return the id salle
     */
    public final Long getIdSalle() {
        return this.idSalle;
    }

    /**
     * Sets the id salle.
     *
     * @param idSalle the new id salle
     */
    public final void setIdSalle(final Long idSalle) {
        this.idSalle = idSalle;
    }

    /**
     * Gets the etudiants.
     *
     * @return the etudiants
     */
    public final HashMap<Long, Etudiant> getEtudiants() {
        return this.etudiants;
    }

    /**
     * Sets the etudiants.
     *
     * @param etudiants the etudiants
     */
    public final void setEtudiants(final HashMap<Long, Etudiant> etudiants) {
        this.etudiants = etudiants;
    }

    /**
     * Gets the dernier entretien.
     *
     * @return the dernier entretien
     */
    public final Date getDernierEntretien() {
        return this.dernierEntretien;
    }

    /**
     * Sets the dernier entretien.
     *
     * @param dernierEntretien the new dernier entretien
     */
    public final void setDernierEntretien(final Date dernierEntretien) {
        this.dernierEntretien = dernierEntretien;
    }
}
