package com.application.polytech.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

/**
 * The Class ChoixEtudiant.
 */
@Entity
@Table(name = "choix_etudiant")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class ChoixEtudiant implements Serializable {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 1L;

    /** The id etudiant. */
    @Id
    @Column(name = "id_etudiant", nullable = false)
    private Long id_etudiant;

    /** The id entreprise. */
    @Id
    @Column(name = "id_entreprise", nullable = false)
    private Long id_entreprise;

    /** The ordre. */
    @Column(name = "ordre", nullable = false)
    private int ordre;

    /** The duree. */
    @Column(name = "duree", nullable = false)
    private int duree;

    /**
     * Instantiates a new choix etudiant.
     */
    public ChoixEtudiant() {

    }

    /**
     * Instantiates a new choix etudiant.
     *
     * @param id_etudiant the id etudiant
     * @param id_entreprise the id entreprise
     * @param ordre the ordre
     * @param duree the duree
     */
    public ChoixEtudiant(final Long id_etudiant, final Long id_entreprise, final int ordre, final int duree) {
        this.id_etudiant = id_etudiant;
        this.id_entreprise = id_entreprise;
        this.ordre = ordre;
        this.duree = duree;
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
