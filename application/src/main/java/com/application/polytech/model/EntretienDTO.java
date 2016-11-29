package com.application.polytech.model;

import java.io.Serializable;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

/**
 * The Class EntretienDTO.
 */
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class EntretienDTO implements Serializable {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 1L;

    /** The id entreprise. */
    private Long id_entreprise;

    /** The id etudiant. */
    private Long id_etudiant;

    /** The ordre. */
    private int ordre;

    /** The duree. */
    private int duree;

    /**
     * Instantiates a new entretien DTO.
     */
    public EntretienDTO() {
        super();
    }

    /**
     * Instantiates a new entretien DTO.
     *
     * @param id_entreprise the id entreprise
     * @param id_etudiant the id etudiant
     * @param ordre the ordre
     */
    public EntretienDTO(final Long id_entreprise, final Long id_etudiant, final int ordre) {
        super();
        this.id_entreprise = id_entreprise;
        this.id_etudiant = id_etudiant;
        this.ordre = ordre;
    }

    /**
     * Gets the id entreprise.
     *
     * @return the id entreprise
     */
    public final Long getId_entreprise() {
        return this.id_entreprise;
    }

    /**
     * Sets the id entreprise.
     *
     * @param id_entreprise the new id entreprise
     */
    public final void setId_entreprise(final Long id_entreprise) {
        this.id_entreprise = id_entreprise;
    }

    /**
     * Gets the id etudiant.
     *
     * @return the id etudiant
     */
    public final Long getId_etudiant() {
        return this.id_etudiant;
    }

    /**
     * Sets the id etudiant.
     *
     * @param id_etudiant the new id etudiant
     */
    public final void setId_etudiant(final Long id_etudiant) {
        this.id_etudiant = id_etudiant;
    }

    /**
     * Gets the ordre.
     *
     * @return the ordre
     */
    public final int getOrdre() {
        return this.ordre;
    }

    /**
     * Sets the ordre.
     *
     * @param ordre the new ordre
     */
    public final void setOrdre(final int ordre) {
        this.ordre = ordre;
    }

    /**
     * Gets the duree.
     *
     * @return the duree
     */
    public final int getDuree() {
        return this.duree;
    }

    /**
     * Sets the duree.
     *
     * @param duree the new duree
     */
    public final void setDuree(final int duree) {
        this.duree = duree;
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
