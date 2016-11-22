package com.application.polytech.dao;

import java.io.File;
import java.io.FileInputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.application.polytech.model.Utilisateur;

/**
 * The Class UtilisateurDaoImpl.
 */
@Repository("utilisateurDao")
public class UtilisateurDaoImpl extends AbstractDao implements UtilisateurDao {

    /*
     * (non-Javadoc)
     * @see com.application.polytech.dao.UtilisateurDao#addUtilisateur(com.application.polytech.model.Utilisateur)
     */
    @Override
    public void addUtilisateur(final Utilisateur utilisateur) {
        this.persist(utilisateur);
    }

    /*
     * (non-Javadoc)
     * @see com.application.polytech.dao.UtilisateurDao#updateUtilisateur(com.application.polytech.model.Utilisateur)
     */
    @Override
    public void updateUtilisateur(final Long id, final Utilisateur utilisateur) {
        final Utilisateur utilisateurModifie = this.getUtilisateurById(id);

        if (utilisateurModifie != null) {
            if (utilisateur.getNom() != null) {
                utilisateurModifie.setNom(utilisateur.getNom());
            }

            if (utilisateur.getPrenom() != null) {
                utilisateurModifie.setPrenom(utilisateur.getPrenom());
            }

            if (utilisateur.getPassword() != null) {
                utilisateurModifie.setPassword(utilisateur.getPassword());
            }

            if (utilisateur.getIdProfil() != null) {
                utilisateurModifie.setIdProfil(utilisateur.getIdProfil());
            }

            if (utilisateur.getEmail() != null) {
                utilisateurModifie.setEmail(utilisateur.getEmail());
            }

            utilisateurModifie.setTelephone(utilisateur.getTelephone());
            utilisateurModifie.setDateDebutDispo(utilisateur.getDateDebutDispo());
            utilisateurModifie.setDateFinDispo(utilisateur.getDateFinDispo());
        }
        this.getSession().update(utilisateurModifie);
    }

    /*
     * (non-Javadoc)
     * @see com.application.polytech.dao.UtilisateurDao#getUtilisateurById(java.lang.Long)
     */
    @Override
    public Utilisateur getUtilisateurById(final Long id) {
        final Criteria criteria = this.getSession().createCriteria(Utilisateur.class);
        criteria.add(Restrictions.eq("id", id));
        return (Utilisateur) criteria.uniqueResult();
    }

    /*
     * (non-Javadoc)
     * @see com.application.polytech.dao.UtilisateurDao#getAll()
     */
    @Override
    public List<Utilisateur> getAll() {
        final Criteria criteria = this.getSession().createCriteria(Utilisateur.class);
        return criteria.list();
    }

    /*
     * (non-Javadoc)
     * @see com.application.polytech.dao.UtilisateurDao#deleteUtilisateur(java.lang.Long)
     */
    @Override
    public void deleteUtilisateur(final Long id) {
        final Query query = this.getSession().createSQLQuery("DELETE FROM Utilisateur WHERE id = :id");
        query.setLong("id", id);
        query.executeUpdate();
    }

    /*
     * (non-Javadoc)
     * @see com.application.polytech.dao.UtilisateurDao#connecter(java.lang.String, java.lang.String)
     */
    @Override
    public Utilisateur connecter(final String login, final String password) {
        final Query query = this.getSession().createQuery("SELECT FROM Utilisateur WHERE email = :login AND password = :password");
        query.setString("email", login);
        query.setString("password", password);

        if (!query.list().isEmpty()) {
            return (Utilisateur) query.list().get(0);

        } else {
            return null;
        }
    }

    /*
     * (non-Javadoc)
     * @see com.application.polytech.dao.UtilisateurDao#lireFichierExcel(java.lang.String)
     */
    @Override
    public List<Utilisateur> lireFichierExcel(final String filePath) {
        final List<Utilisateur> utilisateurs = new ArrayList<>();
        try {
            final FileInputStream fis = new FileInputStream(new File(filePath));
            final XSSFWorkbook workbook = new XSSFWorkbook(fis);
            final XSSFSheet sheet = workbook.getSheetAt(0);
            final Iterator ite = sheet.rowIterator();
            final Row beginRow = (Row) ite.next();
            while (ite.hasNext()) {
                final Row row = (Row) ite.next();
                final Utilisateur utilisateur = importerUtilisateur(row);
                utilisateurs.add(utilisateur);
            }
            fis.close();
        } catch (final Exception e) {

        }
        return utilisateurs;
    }

    /**
     * Importer utilisateur.
     *
     * @param row the row
     * @return the utilisateur
     */
    private static Utilisateur importerUtilisateur(final Row row) {
        final Utilisateur utilisateur = new Utilisateur();
        final SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

        final String nom = row.getCell(0).getStringCellValue();
        utilisateur.setNom(nom);

        final String prenom = row.getCell(1).getStringCellValue();
        utilisateur.setPrenom(prenom);

        final String password = row.getCell(2).getStringCellValue();
        utilisateur.setPassword(password);

        final String idProfil = row.getCell(3).getStringCellValue();
        utilisateur.setIdProfil(Long.parseLong(idProfil));

        final String email = row.getCell(4).getStringCellValue();
        utilisateur.setEmail(email);

        final String telephone = row.getCell(5).getStringCellValue();
        utilisateur.setTelephone(telephone);

        try {
            final String dateDebutDispo = row.getCell(6).getStringCellValue();
            utilisateur.setDateDebutDispo(formatter.parse(dateDebutDispo));

            final String dateFinDispo = row.getCell(7).getStringCellValue();
            utilisateur.setDateFinDispo(formatter.parse(dateFinDispo));
        } catch (final ParseException e) {
            e.printStackTrace();
        }

        return utilisateur;
    }
}
