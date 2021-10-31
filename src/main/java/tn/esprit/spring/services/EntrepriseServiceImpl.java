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
import tn.esprit.spring.entities.Entreprise;
import tn.esprit.spring.repository.DepartementRepository;
import tn.esprit.spring.repository.EntrepriseRepository;

@Service
public class EntrepriseServiceImpl implements IEntrepriseService {
  
	@Autowired
    EntrepriseRepository entrepriseRepoistory;
	@Autowired
	DepartementRepository deptRepoistory;
	private static final Logger L =  LogManager.getLogger(EntrepriseServiceImpl.class);	
	
	public int ajouterEntreprise(Entreprise entreprise) {
		L.info("lancer la methode ajouter entreprise");
		L.debug("je vais lancer save de l'entreprise");
	if(entreprise.getName()==null || entreprise.getRaisonSocial()==null)	
	{
	L.debug("l'ajout n'apas pu etre effectué");
	L.info("fin de  la methode ajouter entreprise");
	return 0;
	}
	else{
		entrepriseRepoistory.save(entreprise);
		L.debug("je viens de finir save de l'entreprise");
		L.info("fin de  la methode ajouter entreprise");
		return entreprise.getId();
		}	
	}

	public int ajouterDepartement(Departement dep) {
		L.info("lancer  la methode ajouter departement");
		L.debug("je vais lancer la methode save du departement");
		
		deptRepoistory.save(dep);
		
		L.debug("je viens de finir save de departement");
		L.info("fin de  la methode ajouter departement");
		return dep.getId();
	}
	
	public void affecterDepartementAEntreprise(int depId, int entrepriseId) {
	
		L.info("lancer  la methode affectation departement a entreprise");
		L.debug("je vais lancer la recherche de l'entreprise par id ");
		Optional<Entreprise> value = entrepriseRepoistory.findById(entrepriseId);
		if(value.isPresent())
		{Entreprise entrepriseManagedEntity = value.get();
				
				
		L.debug("je viens de trouver l'entreprise" + entrepriseManagedEntity);
		L.debug("je vais lancer la recherche du departement par id ");
		Optional<Departement> value1 = deptRepoistory.findById(depId);
		if(value1.isPresent())
		{Departement depManagedEntity=value1.get();
			
			
			
		L.debug("je viens de trouver le departement" + depManagedEntity);
		L.debug("je vais lancer l'update de l'ntreprise et l'enregistré");	
		
				depManagedEntity.setEntreprise(entrepriseManagedEntity);
				deptRepoistory.save(depManagedEntity);
				
		L.debug("je viens de faire l'update l'update de l'ntreprise et l'enregistré");	
		L.info("fin de   la methode affectation departement a entreprise");
		
	}}
		else{L.debug("l'entreprise ou departement n'exite pas");	
		L.info("fin de   la methode affectation departement a entreprise");
			
		}
		}
	
	public List<String> getAllDepartementsNamesByEntreprise(int entrepriseId) {
		L.info("lancer  la methode get all department names by entreprise");
		L.debug("lancer  la recherche de l entreprise par id");
		Optional<Entreprise> value = entrepriseRepoistory.findById(entrepriseId);
		if (value.isPresent()) 
		
		{Entreprise entrepriseManagedEntity= value.get();
	
	
		L.debug("je viens de trouver l entreprise" +entrepriseManagedEntity);
		List<String> depNames = new ArrayList<>();
		L.debug("je vais lancer  la boucle sur tous les departements et ajouter le nom du departementt au tableau depNames");
		
		for(Departement dep : entrepriseManagedEntity.getDepartements()){
			depNames.add(dep.getName());
		}
		
		L.debug("je viens de remplir le tableau depNames");
		L.info("fin de   la methode get all department names by entreprise");
		return depNames;
		}
		else
		{L.debug("l'entreprise n'existe pass");
		L.info("fin de   la methode get all department names by entreprise");
			return Collections.emptyList();
		}
	}

	@Transactional
	public void deleteEntrepriseById(int entrepriseId) {
		L.info("lancer  la methode delete entreprise by id");
		L.debug("je vais lancer  la methode delete entreprise by id");
		Optional<Entreprise> value = entrepriseRepoistory.findById(entrepriseId);
		if (value.isPresent()) {
			Entreprise ent=value.get();
			entrepriseRepoistory.delete(ent);	
			
			L.debug("je viens de finir la delete entreprise by id");
			L.info("finb de   la methode delete entreprise by id");	
		}
		else {L.debug("l'entreprise n'existe passs");
		L.info("finb de   la methode delete entreprise by id");	
			
		}
		
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


	public Entreprise getEntrepriseById(int entrepriseId) {
		L.info("lancer  la methode get entreprise by id");
		L.debug("je vais lancer  la recherche de l'entreprise par id");
		Optional<Entreprise> value = entrepriseRepoistory.findById(entrepriseId);
		if (value.isPresent()) {
			Entreprise ent=value.get();
		
		L.debug("je viens de trouver l'entreprise par id"+ent);
		L.info("fin de   la methode get entreprise by id");
		 return ent;
		}
		else {L.debug("l'entreprise n'existe pas");
		L.info("fin de   la methode get entreprise by id"); 
		return null;}
		
		
		
		
		
	}

}