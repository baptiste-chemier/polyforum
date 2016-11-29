package com.application.polytech.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.application.polytech.dao.EntretienDao;
import com.application.polytech.model.Entreprise;
import com.application.polytech.model.Entretien;
import com.application.polytech.model.EntretienDTO;
import com.application.polytech.model.Forum;
import com.application.polytech.model.Salle;
import com.application.polytech.model.Utilisateur;

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

        final List<EntretienDTO> listEntretienDTO = this.entretienDao.recupererMatrice();
        this.decouperMatrice(listEntretienDTO, idForum);

    }

    /**
     * Decouper matrice.
     *
     * @param listEntretienDTO the list entretien DTO
     * @param idForum the id forum
     */
    private void decouperMatrice(final List<EntretienDTO> listEntretienDTO, final Long idForum) {
        final List<Entreprise> entreprises = new ArrayList<>();
        Entreprise entreprise = new Entreprise();
        final List<Entretien> entretiens = new ArrayList<>();
        Long idTemp = null;

        final List<Salle> salles = this.salleService.getAll();

        for (final EntretienDTO entretienDTO : listEntretienDTO) {
            if (idTemp == null || idTemp != entretienDTO.getId_entreprise()) {

                if (idTemp != null) {
                    entreprises.add(entreprise);
                }

                idTemp = entretienDTO.getId_entreprise();
                entreprise = new Entreprise();
                entreprise.setIdEntreprise(idTemp);
                Utilisateur etudiant = new Utilisateur();
                etudiant = this.utilisateurService.getUtilisateurById(entretienDTO.getId_etudiant());
                if (etudiant != null) {
                    entreprise.getListeEtudiants().add(etudiant);
                    final Entretien entretien = this.creerEntretien(entreprise, salles, entretienDTO, etudiant, idForum);
                    entretiens.add(entretien);
                }
            } else {
                Utilisateur etudiant = new Utilisateur();
                etudiant = this.utilisateurService.getUtilisateurById(entretienDTO.getId_etudiant());
                if (etudiant != null) {
                    entreprise.getListeEtudiants().add(etudiant);
                    final Entretien entretien = this.creerEntretien(entreprise, salles, entretienDTO, etudiant, idForum);
                    entretiens.add(entretien);
                }
                if (listEntretienDTO.get(listEntretienDTO.size() - 1).equals(entretienDTO)) {
                    entreprises.add(entreprise);
                }
            }
        }

        for (final Entretien entretien : entretiens) {
            System.out.println("Entretien : " + entretien.getId() + " | " + entretien.getIdEntreprise() + " | " + entretien.getIdUtilisateur() + " | " + entretien.getIdSalle() + " | "
                    + entretien.getDateDebut() + " | " + entretien.getDateFin());
        }
    }

    /**
     * Creer entretien.
     *
     * @param entreprise the entreprise
     * @param salles the salles
     * @param entretienDTO the entretien DTO
     * @param etudiant the etudiant
     * @param idForum the id forum
     * @return the entretien
     */
    private Entretien creerEntretien(final Entreprise entreprise, final List<Salle> salles, final EntretienDTO entretienDTO, final Utilisateur etudiant, final Long idForum) {
        final Forum forum = this.forumService.getForumById(idForum);

        for (final Salle salle : salles) {
            if (salle.getEntreprises().size() < salle.getCapacite()) {
                if (!entreprise.aUneSalle()) {
                    salle.getEntreprises().add(entreprise);
                    entreprise.setaUneSalle(true);
                    entreprise.setIdSalle(salle.getId());
                    final long tempsEnMilliseconde = forum.getDateDebutForum().getTime();
                    final Date finEntretien = new Date(tempsEnMilliseconde + entretienDTO.getDuree() * this.ONE_MINUTE_IN_MILLIS);
                    salle.setDernierEntretien(finEntretien);

                    return new Entretien(entreprise.getIdEntreprise(), etudiant.getId(), entreprise.getIdSalle(), forum.getDateDebutForum(), finEntretien);
                } else {
                    final long tempsEnMilliseconde = salle.getDernierEntretien().getTime();
                    final Date finEntretien = new Date(tempsEnMilliseconde + entretienDTO.getDuree() * this.ONE_MINUTE_IN_MILLIS);

                    return new Entretien(entreprise.getIdEntreprise(), etudiant.getId(), entreprise.getIdSalle(), forum.getDateDebutForum(), finEntretien);
                }
            }
        }
        return null;
    }
}
