package application.polyforum.web.controller;

import javax.annotation.Resource;

import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import application.polyforum.config.ContextConfig;
import application.polyforum.config.WebMvcConfig;
import application.polyforum.repository.EtudiantRepository;

/**
 * The Class EtudiantControllerTest.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { ContextConfig.class, WebMvcConfig.class })
@WebAppConfiguration
public class EtudiantControllerTest {

    /** The wac. */
    @Resource
    private WebApplicationContext wac;

    /** The etudiant repository mock. */
    @Resource
    private EtudiantRepository etudiantRepositoryMock;

    /** The mock mvc. */
    private MockMvc mockMvc;

    /**
     * Inits the.
     */
    @Before
    public void init() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
    }

    /**
     * Check get etudiant by id url.
     *
     * @throws Exception the exception
     */
    @Test
    public void checkGetEtudiantByIdUrl() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/api/etudiant/1")).andExpect(MockMvcResultMatchers.status().isOk());

    }

    /**
     * Check get list etudiants url.
     *
     * @throws Exception the exception
     */
    @Test
    public void checkGetListEtudiantsUrl() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/api/listEtudiants")).andExpect(MockMvcResultMatchers.status().isOk());
    }

    /**
     * Gets the list etudiants.
     *
     * @return the list etudiants
     * @throws Exception the exception
     */
    @Test
    public void getListEtudiants() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/api/listEtudiants")).andExpect(MockMvcResultMatchers.status().isOk()).andExpect(MockMvcResultMatchers.jsonPath("$", Matchers.hasSize(11)));
    }
}
