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

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {ContextConfig.class, WebMvcConfig.class})
@WebAppConfiguration
public class EtudiantControllerTest {

    @Resource 
    private WebApplicationContext wac;
    
    @Resource
    private EtudiantRepository etudiantRepositoryMock;
    
    private MockMvc mockMvc;
    
    @Before
    public void init() {
    	this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
   }
    
   @Test
   public void checkGetEtudiantByIdUrl() throws Exception {
	   mockMvc.perform(MockMvcRequestBuilders.get("/api/etudiant/1")).andExpect(MockMvcResultMatchers.status().isOk());

   }
   @Test
   public void checkGetListEtudiantsUrl() throws Exception{
       mockMvc.perform(MockMvcRequestBuilders.get("/api/listEtudiants")).andExpect(MockMvcResultMatchers.status().isOk());
   }
   
   @Test
   public void getListEtudiants() throws Exception{
       mockMvc.perform(MockMvcRequestBuilders.get("/api/listEtudiants")).andExpect(MockMvcResultMatchers.status().isOk()).andExpect(MockMvcResultMatchers.jsonPath("$", Matchers.hasSize(11)));
   }
}
