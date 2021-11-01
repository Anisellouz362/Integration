package tn.esprit.spring.service;
import static org.junit.Assert.assertEquals;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


import tn.esprit.spring.entities.Entreprise;
import tn.esprit.spring.repository.EntrepriseRepository;
import tn.esprit.spring.services.IEntrepriseService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EntrepriseServiceImplTest {
		
	@Autowired
	IEntrepriseService es;
	@Autowired
	EntrepriseRepository er;
	
	//Success
	@Test
	public void ajouterEntrepriseTest()  {
	Entreprise ent=new Entreprise(1,"SSII Consulting","Cite El Ghazela");
	int a=es.ajouterEntreprise(ent);
	assertEquals(ent.getId(),a);
	
	}
	//SUCESS
		@Test
		public void ajouterEntrepriseTest2()  {
		Entreprise ent=new Entreprise(1,null,null);
		int a=es.ajouterEntreprise(ent);
		assertEquals(0,a);
		
		}

	//Failure
	@Test
	public void ajouterEntrepriseTest1()  {
	Entreprise ent=new Entreprise(1,null,null);
	int a=es.ajouterEntreprise(ent);
	assertEquals(ent.getId(),a);
	
	}

		//Success
	@Test
	public void getEntrepriseByIdTest()  {
	Entreprise ent=es.getEntrepriseById(1);
	assertNotNull(ent);
	Entreprise entr=er.findById(1).get();
	assertEquals(entr.getName(),ent.getName());
	assertEquals(entr.getRaisonSocial(),ent.getRaisonSocial());
	}
	//Success
	@Test
	public void getEntrepriseByIdTest1()  {
	Entreprise ent=es.getEntrepriseById(1996);
	assertNull(ent);
	}
	
	//Failure
	@Test
	public void getEntrepriseByIdTest2()  {
	Entreprise ent=es.getEntrepriseById(1996);
	assertNotNull(ent);
	}
	//_______________________________________________________________________________________
	
	
	
	//FAILURE
	@Test
	public void getAllDepartementsNamesByEntrepriseTest1()  {
	List<String> names=es.getAllDepartementsNamesByEntreprise(7000);
	assertNotNull(names);
	}
	
	//SUCESS
	@Test
	public void getAllDepartementsNamesByEntrepriseTest2()  {
	List<String> names=es.getAllDepartementsNamesByEntreprise(7000);
	assertNull(names);
	}
	
	
	
	
}