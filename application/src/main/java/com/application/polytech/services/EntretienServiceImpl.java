package com.application.polytech.services;

import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.application.polytech.dao.EntretienDao;
import com.application.polytech.model.Entreprise;
import com.application.polytech.model.Entretien;
import com.application.polytech.model.EntretienDTO;
import com.application.polytech.model.Etudiant;
import com.application.polytech.model.Forum;
import com.application.polytech.model.Salle;

/**
 * The Class EntretienServiceImpl.
 */
@Service("entretienService")
@Transactional
public class EntretienServiceImpl implements EntretienService {

    /** The entretien dao. */
    @Autowired
    EntretienDao entretienDao;

    /** The utilisateur service. */
    @Autowired
    UtilisateurService utilisateurService;

    /** The choix etudiant service. */
    @Autowired
    ChoixEtudiantService choixEtudiantService;

    /** The choix entreprise service. */
    @Autowired
    ChoixEntrepriseService choixEntrepriseService;

    /** The forum service. */
    @Autowired
    ForumService forumService;

    /** The salle service. */
    @Autowired
    SalleService salleService;

    /** The one minute in millis. */
    final long ONE_MINUTE_IN_MILLIS = 60000;

    /*
     * (non-Javadoc)
     * @see com.application.polytech.services.UtilisateurService#getAll()
     */
    @Override
    public List<Entretien> getAll() {
        return this.entretienDao.getAll();
    }

    /*
     * (non-Javadoc)
     * @see com.application.polytech.services.EntretienService#genererPlanning()
     */
    @Override
    public void genererPlanning(final Long idForum) {

        final Forum forum = this.forumService.getForumById(idForum);

        final List<Salle> listSalles = this.salleService.getAll();
        final HashMap<Long, Salle> salles = new HashMap<Long, Salle>();
        for (final Salle salle : listSalles) {
            salles.put(salle.getId(), salle);
        }

        // On vide la table entretien avant de générer le nouveau planning
        this.deleteAll();

        // On récupère la table de corrélation des choix
        final List<EntretienDTO> listeEntretienDTO = this.entretienDao.recupererMatrice();

        // On sépare chaque entreprise avec ses étudiants
        final HashMap<Long, Entreprise> entreprises = this.decouperMatriceParEntreprise(listeEntretienDTO, forum);
        // La map d'entreprise possède une liste d'entreprise avec leur liste d'étudiants

        // Si la map d'entreprise et la liste de salles existent
        if (!entreprises.isEmpty() && !salles.isEmpty()) {
            this.salleService.affecterSalle(salles, entreprises);
        }
        // La map d'enterprise possède une liste d'entreprise avec leur liste d'étudiants et l'id de leur salle

        this.accorderEntretien(listeEntretienDTO, entreprises, salles, forum);
    }

    /**
     * Creer entretien.
     *
     * @param listeEntretienDTO the liste entretien DTO
     * @param entreprises the entreprises
     * @param salles the salles
     * @param forum the forum
     */
    private void accorderEntretien(final List<EntretienDTO> listeEntretienDTO, final HashMap<Long, Entreprise> entreprises, final HashMap<Long, Salle> salles, final Forum forum) {
        // On parcourt la liste d'entretienDTO
        for (final EntretienDTO entretienDTO : listeEntretienDTO) {
            // Si la map d'entreprise contient l'idEntreprise de l'entretienDTO
            if (entreprises.containsKey(entretienDTO.getId_entreprise())) {
                final Entreprise entreprise = entreprises.get(entretienDTO.getId_entreprise());
                // Si la liste d'étudiants de l'entreprise contient l'idEtudiant de l'entretien DTO
                if (entreprise.getListeEtudiants().containsKey(entretienDTO.getId_etudiant())) {
                    final Etudiant etudiant = entreprise.getListeEtudiants().get(entretienDTO.getId_etudiant());
                    // Si l'étudiant existe
                    if (etudiant != null) {
                        final List<Entretien> entretienEtudiant = this.recupererEntretienEtudiantAvecRdv(etudiant.getIdEtudiant());

                        // On parcourt la liste des entretiens de l'étudiant
                        for (final Entretien entretien : entretienEtudiant) {
                            // Si la dateDebutDispo est inférieur a une des dateFin d'entretien
                            if (etudiant.getDateDebutDispo().before(entretien.getDateFin())) {
                                etudiant.setDateDebutDispo(entretien.getDateFin());
                            }
                        }
                    }
                    // Si la salle n'a pas d'entretien : on peut ajouter l'entretien
                    if (entreprise.getDernierEntretien() == null || etudiant.getDateDebutDispo().after(entreprise.getDernierEntretien())) {
                        this.creerEntretien(forum, entretienDTO, entreprise, etudiant);
                    }
                    // Si l'étudiant a une dateDebutDispo inférieur à la dateFin de l'entretien : on doit modifier l'entretien
                    else {
                        etudiant.setDateDebutDispo(entreprise.getDernierEntretien());
                        this.creerEntretien(forum, entretienDTO, entreprise, etudiant);
                    }
                }
            }
        }
    }

    public void creerEntretien(final Forum forum, final EntretienDTO entretienDTO, final Entreprise entreprise, final Etudiant etudiant) {
        long tempsEnMilliseconde;
        Date finEntretien;
        tempsEnMilliseconde = etudiant.getDateDebutDispo().getTime();
        finEntretien = new Date(tempsEnMilliseconde + entretienDTO.getDuree() * this.ONE_MINUTE_IN_MILLIS);
        if (finEntretien.after(forum.getDateFinForum())) {
            finEntretien = forum.getDateFinForum();
        }
        etudiant.setDateFinDispo(finEntretien);
        if (!etudiant.getDateDebutDispo().equals(etudiant.getDateFinDispo())) {
            this.entretienDao.addEntretien(new Entretien(entreprise.getIdEntreprise(), etudiant.getIdEtudiant(), entreprise.getIdSalle(), new Timestamp(etudiant.getDateDebutDispo().getTime()),
                    new Timestamp(etudiant.getDateFinDispo().getTime())));
        }
        entreprise.setDernierEntretien(finEntretien);
    }

    /**
     * Decouper matrice par entreprise.
     *
     * @param listeEntretienDTO the liste entretien DTO
     * @param forum the forum
     * @return the hash map
     */
    private HashMap<Long, Entreprise> decouperMatriceParEntreprise(final List<EntretienDTO> listeEntretienDTO, final Forum forum) {
        final HashMap<Long, Entreprise> entreprises = new HashMap<Long, Entreprise>();

        // On parcourt la liste d'entretienDTO
        for (final EntretienDTO entretienDTO : listeEntretienDTO) {
            // Si l'entreprise n'existe pas dans la map d'entreprises
            if (!entreprises.containsKey(entretienDTO.getId_entreprise())) {
                entreprises.put(entretienDTO.getId_entreprise(), new Entreprise(entretienDTO.getId_entreprise()));
            }

            final Etudiant etudiant = new Etudiant(entretienDTO.getId_etudiant(), forum.getDateDebutForum(), forum.getDateDebutForum());
            final Entreprise entreprise = entreprises.get(entretienDTO.getId_entreprise());
            entreprise.getListeEtudiants().put(entretienDTO.getId_etudiant(), etudiant);
        }

        return entreprises;
    }

    /*
     * (non-Javadoc)
     * @see com.application.polytech.services.EntretienService#addEntretien(com.application.polytech.model.Entretien)
     */
    @Override
    public void addEntretien(final Entretien entretien) {
        this.entretienDao.addEntretien(entretien);
    }

    /*
     * (non-Javadoc)
     * @see com.application.polytech.services.EntretienService#deleteAll()
     */
    @Override
    public void deleteAll() {
        this.entretienDao.deleteAll();
    }

    /**
     * Recuperer entretien etudiant avec rdv.
     *
     * @param idEtudiant the id etudiant
     * @return the list
     */
    public List<Entretien> recupererEntretienEtudiantAvecRdv(final Long idEtudiant) {
        return this.entretienDao.recupererEntretienEtudiantAvecRdv(idEtudiant);
    }
}
