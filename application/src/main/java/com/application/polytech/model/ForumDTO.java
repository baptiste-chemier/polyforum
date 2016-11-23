package com.application.polytech.model;

import java.io.Serializable;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

/**
 * The Class ForumDTO.
 */
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class ForumDTO implements Serializable {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 1L;

    /** The id. */
    private Long id;

    /** The date. */
    private String date;

    /** The heure debut. */
    private Integer heureDebut;

    /** The heure fin. */
    private Integer heureFin;

    /** The min debut. */
    private Integer minDebut;

    /** The min fin. */
    private Integer minFin;

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
     * Gets the date.
     *
     * @return the date
     */
    public final String getDate() {
        return this.date;
    }

    /**
     * Sets the date.
     *
     * @param date the new date
     */
    public final void setDate(final String date) {
        this.date = date;
    }

    /**
     * Gets the heure debut.
     *
     * @return the heure debut
     */
    public final Integer getHeureDebut() {
        return this.heureDebut;
    }

    /**
     * Sets the heure debut.
     *
     * @param heureDebut the new heure debut
     */
    public final void setHeureDebut(final Integer heureDebut) {
        this.heureDebut = heureDebut;
    }

    /**
     * Gets the heure fin.
     *
     * @return the heure fin
     */
    public final Integer getHeureFin() {
        return this.heureFin;
    }

    /**
     * Sets the heure fin.
     *
     * @param heureFin the new heure fin
     */
    public final void setHeureFin(final Integer heureFin) {
        this.heureFin = heureFin;
    }

    /**
     * Gets the min debut.
     *
     * @return the min debut
     */
    public final Integer getMinDebut() {
        return this.minDebut;
    }

    /**
     * Sets the min debut.
     *
     * @param minDebut the new min debut
     */
    public final void setMinDebut(final Integer minDebut) {
        this.minDebut = minDebut;
    }

    /**
     * Gets the min fin.
     *
     * @return the min fin
     */
    public final Integer getMinFin() {
        return this.minFin;
    }

    /**
     * Sets the min fin.
     *
     * @param minFin the new min fin
     */
    public final void setMinFin(final Integer minFin) {
        this.minFin = minFin;
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
