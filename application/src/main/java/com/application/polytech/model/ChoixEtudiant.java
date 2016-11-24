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
    private Long idEtudiant;

    /** The id entreprise. */
    @Id
    @Column(name = "id_entreprise", nullable = false)
    private Long idEntreprise;

    /** The ordre. */
    @Column(name = "ordre", nullable = false)
    private int ordre;

    /**
     * Instantiates a new choix etudiant.
     */
    public ChoixEtudiant() {

    }

    /**
     * Instantiates a new choix etudiant.
     *
     * @param idEtudiant the id etudiant
     * @param idEntreprise the id entreprise
     * @param ordre the ordre
     */
    public ChoixEtudiant(final Long idEtudiant, final Long idEntreprise, final int ordre) {
        this.idEtudiant = idEtudiant;
        this.idEntreprise = idEntreprise;
        this.ordre = ordre;
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
