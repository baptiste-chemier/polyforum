package application.polyforum.web.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import application.polyforum.model.Etudiant;
import application.polyforum.repository.EtudiantRepository;

@RestController
@RequestMapping(value = "/api")
public class EtudiantController {

	@Resource
	private EtudiantRepository etudiantRepository;
	
	@RequestMapping(value = "/etudiant/{etudiantId}", method = RequestMethod.GET)
	public Etudiant getEtudiant(@PathVariable Long etudiantId) {
		return etudiantRepository.getEtudiant(etudiantId);
	}
	
	@RequestMapping(value = "/listEtudiants", method = RequestMethod.GET)
	public List<Etudiant> getListEtudiants() {
		return etudiantRepository.getAll();
	}
}
