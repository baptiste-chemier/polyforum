package com.application.polytech.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

/**
 * The Class Entretien.
 */
@Entity
@Table(name = "entretien")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Entretien implements Serializable {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 1L;

    /** The id. */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    /** The id entreprise. */
    @Column(name = "id_entreprise", nullable = false)
    private Long idEntreprise;

    /** The id etudiant. */
    @Column(name = "id_etudiant", nullable = false)
    private Long idEtudiant;

    /** The id salle. */
    @Column(name = "id_salle", nullable = false)
    private Long idSalle;

    /** The date debut. */
    @Column(name = "date_debut")
    private Date dateDebut;

    /** The date fin. */
    @Column(name = "date_fin", nullable = false)
    private Date dateFin;

    /** The duree. */
    @Transient
    private int duree;

    /**
     * Instantiates a new entretien.
     */
    public Entretien() {}

    /**
     * Instantiates a new entretien.
     *
     * @param idEntreprise the id entreprise
     * @param idEtudiant the id etudiant
     * @param idSalle the id salle
     * @param dateDebut the date debut
     * @param dateFin the date fin
     */
    public Entretien(final Long idEntreprise, final Long idEtudiant, final Long idSalle, final Date dateDebut, final Date dateFin) {
        super();
        this.idEntreprise = idEntreprise;
        this.idEtudiant = idEtudiant;
        this.idSalle = idSalle;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
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
     * Gets the date debut.
     *
     * @return the date debut
     */
    public final Date getDateDebut() {
        return this.dateDebut;
    }

    /**
     * Sets the date debut.
     *
     * @param dateDebut the new date debut
     */
    public final void setDateDebut(final Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    /**
     * Gets the date fin.
     *
     * @return the date fin
     */
    public final Date getDateFin() {
        return this.dateFin;
    }

    /**
     * Sets the date fin.
     *
     * @param dateFin the new date fin
     */
    public final void setDateFin(final Date dateFin) {
        this.dateFin = dateFin;
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
}
