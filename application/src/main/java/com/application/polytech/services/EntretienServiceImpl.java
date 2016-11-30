package com.application.polytech.services;

import java.sql.Timestamp;
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
        final List<Entretien> entretiens = this.decouperMatrice(listEntretienDTO, idForum);

        this.deleteAll();

        for (final Entretien entretien : entretiens) {
            this.entretienDao.addEntretien(entretien);
        }

    }

    /**
     * Decouper matrice.
     *
     * @param listEntretienDTO the list entretien DTO
     * @param idForum the id forum
     * @return the list
     */
    private List<Entretien> decouperMatrice(final List<EntretienDTO> listEntretienDTO, final Long idForum) {
        final List<Entreprise> entreprises = new ArrayList<>();
        Entreprise entreprise = new Entreprise();
        final List<Entretien> entretiens = new ArrayList<>();
        Long idTemp = null;
        final Forum forum = this.forumService.getForumById(idForum);

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
                    if (entretien != null) {
                        if (!entretien.getDateDebut().equals(forum.getDateFinForum())) {
                            entretiens.add(entretien);
                        }
                    }
                }
            } else {
                Utilisateur etudiant = new Utilisateur();
                etudiant = this.utilisateurService.getUtilisateurById(entretienDTO.getId_etudiant());
                if (etudiant != null) {
                    entreprise.getListeEtudiants().add(etudiant);
                    final Entretien entretien = this.creerEntretien(entreprise, salles, entretienDTO, etudiant, idForum);
                    if (entretien != null) {
                        if (!entretien.getDateDebut().equals(forum.getDateFinForum())) {
                            entretiens.add(entretien);
                        }
                    }
                }
                if (listEntretienDTO.get(listEntretienDTO.size() - 1).equals(entretienDTO)) {
                    entreprises.add(entreprise);
                }
            }
        }

        return entretiens;
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
        final Date dateFin = forum.getDateFinForum();

        if (!entreprise.aUneSalle()) {
            for (final Salle salle : salles) {
                if (salle.getEntreprises().size() < salle.getCapacite()) {
                    salle.getEntreprises().add(entreprise);
                    entreprise.setaUneSalle(true);
                    entreprise.setIdSalle(salle.getId());
                    final long tempsEnMilliseconde = forum.getDateDebutForum().getTime();
                    Date finEntretien = new Date(tempsEnMilliseconde + entretienDTO.getDuree() * this.ONE_MINUTE_IN_MILLIS);
                    if (finEntretien.after(dateFin)) {
                        finEntretien = dateFin;
                        salle.setDernierEntretien(finEntretien);
                        return new Entretien(entreprise.getIdEntreprise(), etudiant.getId(), entreprise.getIdSalle(), forum.getDateDebutForum(), new Timestamp(finEntretien.getTime()));
                    } else {
                        salle.setDernierEntretien(finEntretien);
                        return new Entretien(entreprise.getIdEntreprise(), etudiant.getId(), entreprise.getIdSalle(), forum.getDateDebutForum(), new Timestamp(finEntretien.getTime()));
                    }
                } else if (salle.getEntreprises().size() == salle.getCapacite()) {
                    if (entreprise.aUneSalle()) {
                        final long tempsEnMilliseconde = salle.getDernierEntretien().getTime();
                        Date finEntretien = new Date(tempsEnMilliseconde + entretienDTO.getDuree() * this.ONE_MINUTE_IN_MILLIS);
                        if (finEntretien.after(dateFin)) {
                            finEntretien = dateFin;
                            salle.setDernierEntretien(finEntretien);
                            return new Entretien(entreprise.getIdEntreprise(), etudiant.getId(), entreprise.getIdSalle(), new Timestamp(tempsEnMilliseconde), new Timestamp(finEntretien.getTime()));
                        } else {
                            salle.setDernierEntretien(finEntretien);
                            return new Entretien(entreprise.getIdEntreprise(), etudiant.getId(), entreprise.getIdSalle(), new Timestamp(tempsEnMilliseconde), new Timestamp(finEntretien.getTime()));
                        }
                    }
                }
            }
        } else {
            final Salle s = this.salleService.getSalleById(entreprise.getIdSalle());
            final long tempsEnMilliseconde = s.getDernierEntretien().getTime();
            Date finEntretien = new Date(tempsEnMilliseconde + entretienDTO.getDuree() * this.ONE_MINUTE_IN_MILLIS);
            s.setDernierEntretien(finEntretien);
            if (finEntretien.after(dateFin)) {
                finEntretien = dateFin;
                s.setDernierEntretien(finEntretien);
                return new Entretien(entreprise.getIdEntreprise(), etudiant.getId(), entreprise.getIdSalle(), new Timestamp(tempsEnMilliseconde), new Timestamp(finEntretien.getTime()));
            } else {
                s.setDernierEntretien(finEntretien);
                return new Entretien(entreprise.getIdEntreprise(), etudiant.getId(), entreprise.getIdSalle(), new Timestamp(tempsEnMilliseconde), new Timestamp(finEntretien.getTime()));
            }
        }
        return null;
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
}
