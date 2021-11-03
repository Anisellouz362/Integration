package tn.esprit.spring.services;


import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.Departement;
import tn.esprit.spring.repository.DepartementRepository;

@Service
public class DepartementServiceImpl implements IDepartementService {
	
	@Autowired
	DepartementRepository dr;
	
private static final Logger l = LogManager.getLogger(DepartementServiceImpl.class);



	
	
	@Override
	public List<Departement> retrieveAllDepartements() { 
		List<Departement> departements = null; 
		try {
	
			l.info("In retrieveAllUsers() : ");
			departements = (List<Departement>) dr.findAll();  
			for (Departement departement : departements) {
				l.debug("departement +++ : " + departement);
			} 
			l.info("Out of retrieveAllDepartements() : ");
		}catch (Exception e) {
			l.error("Error in retrieveAllDepartements() : " + e);
		}

		return departements;
	}


	@Override
	public Departement addDepartement(Departement d) {
		return dr.save(d); 
	}

	@Override 
	public Departement updateDepartement (Departement d) { 
		return dr.save(d);
	}

	@Override
	public void remove(String id) {
		
		dr.deleteById(Integer.parseInt(id));
	}

	@Override
	public Departement retrieveDepartement(String id) {
		l.info("in  retrieveDepartement id = " + id);
		Departement d =  dr.findById(Integer.parseInt(id)).orElse(null);
		//NOSONARint i = 1/10; 
		//User u =  userRepository.findById(Long.parseLong(id)).get(); 
		l.info("departement returned : " + d);
		return d; 
	}


}
