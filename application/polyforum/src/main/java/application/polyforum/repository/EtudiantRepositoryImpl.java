package application.polyforum.repository;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import application.polyforum.model.Etudiant;

/**
 * The Class EtudiantRepositoryImpl.
 */
@Repository
public class EtudiantRepositoryImpl implements EtudiantRepository {

    /** The jdbc template. */
    @Resource
    private JdbcTemplate jdbcTemplate;

    /*
     * (non-Javadoc)
     * @see application.polyforum.repository.EtudiantRepository#getAll()
     */
    @Override
    public List<Etudiant> getAll() {
        final String GET_ALL_ETUDIANTS = "select * from etudiant";

        return this.jdbcTemplate.query(GET_ALL_ETUDIANTS, BeanPropertyRowMapper.newInstance(Etudiant.class));
    }

    /*
     * (non-Javadoc)
     * @see application.polyforum.repository.EtudiantRepository#getEtudiant(java.lang.Long)
     */
    @Override
    public Etudiant getEtudiant(final Long etudiantId) {
        final String GET_ETUDIANT_BY_ID = "select * from etudiant where etudiant_id=?";

        return this.jdbcTemplate.queryForObject(GET_ETUDIANT_BY_ID, BeanPropertyRowMapper.newInstance(Etudiant.class), etudiantId);
    }

    /*
     * (non-Javadoc)
     * @see application.polyforum.repository.EtudiantRepository#ajouterEtudiant(application.polyforum.model.Etudiant)
     */
    @Override
    public void ajouterEtudiant(final Etudiant etudiant) {
        // TODO Auto-generated method stub

    }

    /*
     * (non-Javadoc)
     * @see application.polyforum.repository.EtudiantRepository#supprimerEtudiant(java.lang.Long)
     */
    @Override
    public void supprimerEtudiant(final Long etudiantId) {
        // TODO Auto-generated method stub

    }

    /*
     * (non-Javadoc)
     * @see application.polyforum.repository.EtudiantRepository#modifierEtudiant(java.lang.Long)
     */
    @Override
    public void modifierEtudiant(final Long etudiantId) {
        // TODO Auto-generated method stub

    }

}
