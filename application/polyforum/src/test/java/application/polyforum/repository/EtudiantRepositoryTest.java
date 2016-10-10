package application.polyforum.repository;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import application.polyforum.config.ContextConfig;
import application.polyforum.model.Etudiant;
import org.junit.Assert;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={ContextConfig.class})
public class EtudiantRepositoryTest {

	@Resource
	private EtudiantRepository etudiantRepository;
	
	@Test
	public void getEtudiant() {
		Long id = 1L;
		Etudiant etudiant = etudiantRepository.getEtudiant(id);
		Assert.assertNotNull(etudiant);
		Assert.assertEquals(id, etudiant.getEtudiantId());
	}
	
	@Test
	public void getAll() {
		List<Etudiant> listEtudiants = etudiantRepository.getAll();
		Assert.assertNotNull(listEtudiants);
		Assert.assertTrue(listEtudiants.size() > 0);
	}
}
