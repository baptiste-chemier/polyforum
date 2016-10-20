package application.polyforum.repository;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import application.polyforum.model.Etudiant;

@Repository
public class EtudiantRepositoryImpl implements EtudiantRepository {

	@Resource
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<Etudiant> getAll() {
		String GET_ALL_ETUDIANTS = "select * from etudiant";
		
		return jdbcTemplate.query(GET_ALL_ETUDIANTS, BeanPropertyRowMapper.newInstance(Etudiant.class));
	}

	@Override
	public Etudiant getEtudiant(Long etudiantId) {
		String GET_ETUDIANT_BY_ID = "select * from etudiant where etudiant_id=?";
		
		return jdbcTemplate.queryForObject(GET_ETUDIANT_BY_ID, BeanPropertyRowMapper.newInstance(Etudiant.class), etudiantId);
	}

	@Override
	public void ajouterEtudiant(Etudiant etudiant) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void supprimerEtudiant(Long etudiantId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modifierEtudiant(Long etudiantId) {
		// TODO Auto-generated method stub
		
	}
	
}
