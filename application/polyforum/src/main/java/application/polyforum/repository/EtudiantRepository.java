package application.polyforum.repository;

import java.util.List;

import application.polyforum.model.Etudiant;

/**
 * The Interface EtudiantRepository.
 */
public interface EtudiantRepository {

    /**
     * Gets the all.
     *
     * @return the all
     */
    List<Etudiant> getAll();

    /**
     * Gets the etudiant.
     *
     * @param etudiantId the etudiant id
     * @return the etudiant
     */
    Etudiant getEtudiant(Long etudiantId);

    /**
     * Ajouter etudiant.
     *
     * @param etudiant the etudiant
     */
    void ajouterEtudiant(Etudiant etudiant);

    /**
     * Supprimer etudiant.
     *
     * @param etudiantId the etudiant id
     */
    void supprimerEtudiant(Long etudiantId);

    /**
     * Modifier etudiant.
     *
     * @param etudiantId the etudiant id
     */
    void modifierEtudiant(Long etudiantId);
}
