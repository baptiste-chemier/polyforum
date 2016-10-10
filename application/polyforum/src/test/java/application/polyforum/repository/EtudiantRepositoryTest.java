package application.polyforum.repository;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import application.polyforum.config.ContextConfig;
import application.polyforum.model.Etudiant;

/**
 * The Class EtudiantRepositoryTest.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { ContextConfig.class })
public class EtudiantRepositoryTest {

    /** The etudiant repository. */
    @Resource
    private EtudiantRepository etudiantRepository;

    /**
     * Gets the etudiant.
     *
     * @return the etudiant
     */
    @Test
    public void getEtudiant() {
        final Long id = 1L;
        final Etudiant etudiant = this.etudiantRepository.getEtudiant(id);
        Assert.assertNotNull(etudiant);
        Assert.assertEquals(id, etudiant.getEtudiantId());
    }

    /**
     * Gets the all.
     *
     * @return the all
     */
    @Test
    public void getAll() {
        final List<Etudiant> listEtudiants = this.etudiantRepository.getAll();
        Assert.assertNotNull(listEtudiants);
        Assert.assertTrue(listEtudiants.size() > 0);
    }
}
