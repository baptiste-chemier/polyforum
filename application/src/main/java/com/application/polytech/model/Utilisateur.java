package com.application.polytech.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
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
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    /** The nom. */
    @Column(name = "nom")
    private String nom;

    /** The prenom. */
    @Column(name = "prenom")
    private String prenom;

    /** The email. */
    @Column(name = "email")
    private String email;

    /** The telephone. */
    @Column(name = "telephone")
    private String telephone;

    /** The id profil. */
    @Column(name = "id_profil")
    private Long idProfil;

    /** The date debut dispo. */
    @Column(name = "date_debut_dispo")
    private Date date_debut_dispo;

    /** The date fin dispo. */
    @Column(name = "date_fin_dispo")
    private Date date_fin_dispo;

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
     * Gets the nom.
     *
     * @return the nom
     */
    public String getNom() {
        return this.nom;
    }

    /**
     * Sets the nom.
     *
     * @param nom the new nom
     */
    public void setNom(final String nom) {
        this.nom = nom;
    }

    /**
     * Gets the prenom.
     *
     * @return the prenom
     */
    public String getPrenom() {
        return this.prenom;
    }

    /**
     * Sets the prenom.
     *
     * @param prenom the new prenom
     */
    public void setPrenom(final String prenom) {
        this.prenom = prenom;
    }

    /**
     * Gets the email.
     *
     * @return the email
     */
    public String getEmail() {
        return this.email;
    }

    /**
     * Sets the email.
     *
     * @param email the new email
     */
    public void setEmail(final String email) {
        this.email = email;
    }

    /**
     * Gets the telephone.
     *
     * @return the telephone
     */
    public String getTelephone() {
        return this.telephone;
    }

    /**
     * Sets the telephone.
     *
     * @param telephone the new telephone
     */
    public void setTelephone(final String telephone) {
        this.telephone = telephone;
    }

    /**
     * Gets the id profil.
     *
     * @return the id profil
     */
    public Long getIdProfil() {
        return this.idProfil;
    }

    /**
     * Sets the id profil.
     *
     * @param idProfil the new id profil
     */
    public void setIdProfil(final Long idProfil) {
        this.idProfil = idProfil;
    }

    /**
     * Gets the date debut dispo.
     *
     * @return the date debut dispo
     */
    public Date getDate_debut_dispo() {
        return this.date_debut_dispo;
    }

    /**
     * Sets the date debut dispo.
     *
     * @param date_debut_dispo the new date debut dispo
     */
    public void setDate_debut_dispo(final Date date_debut_dispo) {
        this.date_debut_dispo = date_debut_dispo;
    }

    /**
     * Gets the date fin dispo.
     *
     * @return the date fin dispo
     */
    public Date getDate_fin_dispo() {
        return this.date_fin_dispo;
    }

    /**
     * Sets the date fin dispo.
     *
     * @param date_fin_dispo the new date fin dispo
     */
    public void setDate_fin_dispo(final Date date_fin_dispo) {
        this.date_fin_dispo = date_fin_dispo;
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
