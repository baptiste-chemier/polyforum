package com.application.polytech.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

/**
 * The Class ChoixEntreprise.
 */
@Entity
@Table(name = "choix_entreprise")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class ChoixEntreprise implements Serializable {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 1L;

    /** The id entreprise. */
    @Id
    @Column(name = "id_entreprise", nullable = false)
    private Long idEntreprise;

    /** The id etudiant. */
    @Id
    @Column(name = "id_etudiant", nullable = false)
    private Long idEtudiant;

    /** The ordre. */
    @Column(name = "ordre", nullable = false)
    private int ordre;

    /**
     * Instantiates a new choix entreprise.
     */
    public ChoixEntreprise() {

    }

    /**
     * Instantiates a new choix entreprise.
     *
     * @param idEntreprise the id entreprise
     * @param idEtudiant the id etudiant
     * @param ordre the ordre
     */
    public ChoixEntreprise(final Long idEntreprise, final Long idEtudiant, final int ordre) {
        this.idEntreprise = idEntreprise;
        this.idEtudiant = idEtudiant;
        this.ordre = ordre;
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
     * Gets the serialversionuid.
     *
     * @return the serialversionuid
     */
    public static final long getSerialversionuid() {
        return serialVersionUID;
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
}
