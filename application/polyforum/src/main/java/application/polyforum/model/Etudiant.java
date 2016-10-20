package application.polyforum.model;

/**
 * The Class Etudiant.
 */
public class Etudiant {

    /** The etudiant id. */
    private Long etudiantId;

    /** The nom. */
    private String nom;

    /** The prenom. */
    private String prenom;

    /** The email. */
    private String email;

    /**
     * Gets the etudiant id.
     *
     * @return the etudiant id
     */
    public final Long getEtudiantId() {
        return this.etudiantId;
    }

    /**
     * Sets the etudiant id.
     *
     * @param etudiantId the new etudiant id
     */
    public final void setEtudiantId(final Long etudiantId) {
        this.etudiantId = etudiantId;
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

}
