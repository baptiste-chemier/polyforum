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
 * The Class Profil.
 */
@Entity
@Table(name = "profil")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Profil implements Serializable {

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
     * Gets the serialversionuid.
     *
     * @return the serialversionuid
     */
    public static final long getSerialversionuid() {
        return serialVersionUID;
    }
}
