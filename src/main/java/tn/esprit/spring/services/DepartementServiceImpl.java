package tn.esprit.spring.services;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tn.esprit.spring.entities.Departement;
import tn.esprit.spring.repository.DepartementRepository;


@Service
public class DepartementServiceImpl implements IDepartementService {
  

	@Autowired
	DepartementRepository deptRepoistory;
	private static final Logger L =  LogManager.getLogger(DepartementServiceImpl.class);	
	

 public int ajouterDepartement(Departement dep) {
		L.info("lancer  la methode ajouter departement");
		L.debug("je vais lancer la methode save du departement");
		
		deptRepoistory.save(dep);
		
		L.debug("je viens de finir save de departement");
		L.info("fin de  la methode ajouter departement");
		return dep.getId();
	}
	
	
	


	@Transactional
	public void deleteDepartementById(int depId) {
		L.info("lancer  la methode delete department by id");
		L.debug("je vais lancer  la methode delete departement by id");
		Optional<Departement> value = deptRepoistory.findById(depId);
		if (value.isPresent()) {
			Departement dep=value.get();
		deptRepoistory.delete(dep);
		
		L.debug("je viens de finir la delete departement by id");
		L.info("fin de  la methode delete department by id");
		}
		else {
			L.debug("le departement n'existe pas");
			L.info("fin de  la methode delete department by id");
		}
	}


	public Departement getDepartementById(int depId) {
		L.info("lancer  la methode get departement by id");
		L.debug("je vais lancer  la recherche du departement par id");
		Optional < Departement > value = deptRepoistory.findById(depId);

		if (value.isPresent()) {
			Departement dep=value.get();
		
		L.debug("je viens de trouver departement par id"+dep);
		L.info("fin de   la methode get departement by id");
		 return dep;
		}
		else {L.debug("departement n'existe pas");
		L.info("fin de   la methode get departement by id"); 
		return null;}
		
		
		
		
		
	}

}