package com.application.polytech.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

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

    /** The nom. */
    @Column(name = "libelle", nullable = false)
    private String libelle;

    /** The prenom. */
    @Column(name = "capacite", nullable = false)
    private int capacite;

    /**
     * Gets the id.
     *
     * @return the id
     */
    public Long getId() {
        return this.id;
    }

    /**
     * Sets the id.
     *
     * @param id the new id
     */
    public void setId(final Long id) {
        this.id = id;
    }

    /**
     * Gets the libelle.
     *
     * @return the libelle
     */
    public String getLibelle() {
        return this.libelle;
    }

    /**
     * Sets the libelle.
     *
     * @param libelle the new libelle
     */
    public void setLibelle(final String libelle) {
        this.libelle = libelle;
    }

    /**
     * Gets the capacite.
     *
     * @return the capacite
     */
    public int getCapacite() {
        return this.capacite;
    }

    /**
     * Sets the capacite.
     *
     * @param capacite the new capacite
     */
    public void setCapacite(final int capacite) {
        this.capacite = capacite;
    }

    /**
     * Gets the serialversionuid.
     *
     * @return the serialversionuid
     */
    public static long getSerialversionuid() {
        return serialVersionUID;
    }
}
