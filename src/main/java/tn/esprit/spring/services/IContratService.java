package tn.esprit.spring.services;

import java.util.List;

import tn.esprit.spring.entities.Contrat;

public interface IContratService {
   
	
	List<Contrat> retrieveAllContrats(); 
	Contrat addContrat(Contrat c);
	void deleteContrat(int id);
	Contrat majContrat(Contrat contrat); 
	public void deleteAllContratJPQL();
	public Contrat retrieveContrat(int id) ;
}
