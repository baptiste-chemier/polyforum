package com.application.polytech.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

/**
 * The Class Salle.
 */
@Entity
@Table(name = "salle")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Salle implements Serializable {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 1L;

    /** The id. */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    /** The libelle. */
    @Column(name = "libelle", nullable = false)
    private String libelle;

    /** The capacite. */
    @Column(name = "capacite", nullable = false)
    private int capacite;

    /** The entreprises. */
    @Transient
    private final List<Entreprise> entreprises = new ArrayList<Entreprise>();

    /** The entretiens. */
    @Transient
    private final List<Entretien> entretiens = new ArrayList<Entretien>();

    /** The dernier entretien. */
    @Transient
    private Date dernierEntretien = new Date();

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
     * Gets the libelle.
     *
     * @return the libelle
     */
    public final String getLibelle() {
        return this.libelle;
    }

    /**
     * Sets the libelle.
     *
     * @param libelle the new libelle
     */
    public final void setLibelle(final String libelle) {
        this.libelle = libelle;
    }

    /**
     * Gets the capacite.
     *
     * @return the capacite
     */
    public final int getCapacite() {
        return this.capacite;
    }

    /**
     * Sets the capacite.
     *
     * @param capacite the new capacite
     */
    public final void setCapacite(final int capacite) {
        this.capacite = capacite;
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
     * Gets the entreprises.
     *
     * @return the entreprises
     */
    public final List<Entreprise> getEntreprises() {
        return this.entreprises;
    }

    /**
     * Gets the entretiens.
     *
     * @return the entretiens
     */
    public final List<Entretien> getEntretiens() {
        return this.entretiens;
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
     * @param nouvelEntretien the new dernier entretien
     */
    public final void setDernierEntretien(final Date nouvelEntretien) {
        this.dernierEntretien = nouvelEntretien;
    }
}
