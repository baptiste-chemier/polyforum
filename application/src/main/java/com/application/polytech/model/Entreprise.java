package com.application.polytech.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

/**
 * The Class Entreprise.
 */
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Entreprise implements Serializable {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 1L;

    /** The id entreprise. */
    private Long idEntreprise;

    /** The liste etudiants. */
    private List<Utilisateur> listeEtudiants = new ArrayList<Utilisateur>();

    /** The a une salle. */
    private boolean aUneSalle;

    /** The id salle. */
    private Long idSalle;

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
     * Gets the liste etudiants.
     *
     * @return the liste etudiants
     */
    public final List<Utilisateur> getListeEtudiants() {
        return this.listeEtudiants;
    }

    /**
     * Sets the liste etudiants.
     *
     * @param listeEtudiants the new liste etudiants
     */
    public final void setListeEtudiants(final List<Utilisateur> listeEtudiants) {
        this.listeEtudiants = listeEtudiants;
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
     * A une salle.
     *
     * @return true, if successful
     */
    public final boolean aUneSalle() {
        return this.aUneSalle;
    }

    /**
     * Sets the a une salle.
     *
     * @param aUneSalle the new a une salle
     */
    public final void setaUneSalle(final boolean aUneSalle) {
        this.aUneSalle = aUneSalle;
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
}
