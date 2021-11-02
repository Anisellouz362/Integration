package tn.esprit.spring.services;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.Contrat;
import tn.esprit.spring.entities.Employe;
import tn.esprit.spring.entities.User;
import tn.esprit.spring.repository.ContratRepository;
import tn.esprit.spring.repository.EmployeRepository;
@Service
public class ContratServiceImpl implements IContratService  {
	@Autowired
	ContratRepository contratRepository;

	@Autowired
	EmployeRepository employeRepository;
	private static final Logger l = LogManager.getLogger(UserServiceImpl.class);

	
	public Contrat addContrat(Contrat c) {
		l.info("lancer la methode ajouter contrat");
		l.debug("je vais lancer save du contrat");
		contratRepository.save(c);
		l.debug("je viens de finir save de contrat");
		l.info("fin de  la methode ajouter contrat");
		return contratRepository.save(c);
	}
	
	

	
	public void deleteContrat(int contratId) {
		l.info("lancer la methode delete contrat by id");
		l.debug("je vais effacer un contrat à travers son id");
		Contrat contratManagedEntity = contratRepository.findById(contratId).get();
		contratRepository.delete(contratManagedEntity);
		l.debug("je viens d'effacer un contrat à travers son id");
		l.info("fin de la methode delete contrat by id");

	}
	

	public Contrat majContrat(Contrat c) {
		return contratRepository.save(c);
		
	}
	
	public Contrat retrieveContrat(int id) {
		l.info("in  retrieveContrat id = " + id);

		Contrat c =  contratRepository.findById((id)).get(); 
		l.info("contrat returned : " + c);
		return c; 
	}
	public void deleteAllContratJPQL() {
		l.info("lancer la methode deleteAllContratJPQL");
		l.debug("je vais supprimer tous les contrats");
         employeRepository.deleteAllContratJPQL();
         l.debug("je viens de supprimer tous les contrats");
 		l.info("fin de  la methode  deleteAllContratJPQL");
	}




	@Override
	public List<Contrat> retrieveAllContrats() {
		// TODO Auto-generated method stub
		return null;
	}




	}


