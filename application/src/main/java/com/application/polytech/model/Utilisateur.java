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
 * The Class Utilisateur.
 */
@Entity
@Table(name = "utilisateur")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Utilisateur implements Serializable {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 1L;

    /** The id. */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    /** The nom. */
    @Column(name = "nom", nullable = false)
    private String nom;

    /** The prenom. */
    @Column(name = "prenom", nullable = false)
    private String prenom;

    /** The email. */
    @Column(name = "email", nullable = false)
    private String email;

    /** The telephone. */
    @Column(name = "telephone")
    private String telephone;

    /** The id profil. */
    @Column(name = "id_profil", nullable = false)
    private Long idProfil;

    /** The password. */
    @Column(name = "password", nullable = false)
    private String password;

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
     * Gets the nom.
     *
     * @return the nom
     */
    public final String getNom() {
        return this.nom;
    }

    /**
     * Sets the nom.
     *
     * @param nom the new nom
     */
    public final void setNom(final String nom) {
        this.nom = nom;
    }

    /**
     * Gets the prenom.
     *
     * @return the prenom
     */
    public final String getPrenom() {
        return this.prenom;
    }

    /**
     * Sets the prenom.
     *
     * @param prenom the new prenom
     */
    public final void setPrenom(final String prenom) {
        this.prenom = prenom;
    }

    /**
     * Gets the email.
     *
     * @return the email
     */
    public final String getEmail() {
        return this.email;
    }

    /**
     * Sets the email.
     *
     * @param email the new email
     */
    public final void setEmail(final String email) {
        this.email = email;
    }

    /**
     * Gets the telephone.
     *
     * @return the telephone
     */
    public final String getTelephone() {
        return this.telephone;
    }

    /**
     * Sets the telephone.
     *
     * @param telephone the new telephone
     */
    public final void setTelephone(final String telephone) {
        this.telephone = telephone;
    }

    /**
     * Gets the id profil.
     *
     * @return the id profil
     */
    public final Long getIdProfil() {
        return this.idProfil;
    }

    /**
     * Sets the id profil.
     *
     * @param idProfil the new id profil
     */
    public final void setIdProfil(final Long idProfil) {
        this.idProfil = idProfil;
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
     * Gets the password.
     *
     * @return the password
     */
    public final String getPassword() {
        return this.password;
    }

    /**
     * Sets the password.
     *
     * @param password the new password
     */
    public final void setPassword(final String password) {
        this.password = password;
    }
}
