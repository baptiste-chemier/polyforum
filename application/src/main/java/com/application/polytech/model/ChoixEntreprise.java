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

    /**
     * Instantiates a new choix entreprise.
     *
     * @param idEntreprise the id entreprise
     * @param idEtudiant the id etudiant
     */
    public ChoixEntreprise(final Long idEntreprise, final Long idEtudiant) {
        this.idEntreprise = idEntreprise;
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
}
