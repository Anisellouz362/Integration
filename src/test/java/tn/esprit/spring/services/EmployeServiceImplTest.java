package tn.esprit.spring.services;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.util.Arrays;
import java.util.Date;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import tn.esprit.spring.entities.Contrat;
import tn.esprit.spring.entities.Employe;
import tn.esprit.spring.entities.Role;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = EmployeServiceImplTest.class)
public class EmployeServiceImplTest {
	
	@Autowired
	IEmployeService iemployeservice;

	String NAME = "alex";
	String LAST = "bernar";
	String EMAIL = "alex.bernar@gmail.com";

	
	@Test
	public void testAjouterEmploye() {
	Employe employe = new Employe(NAME, LAST, EMAIL,true,Role.INGENIEUR);
	 int i = iemployeservice.ajouterEmploye(employe);
	 assertEquals(16, i);
	}
	
	
	@Test
	public void testAjouterEmploye2() {
		Employe employe = new Employe(NAME, LAST, EMAIL,true,Role.INGENIEUR);
	 int i = iemployeservice.ajouterEmploye(employe);
	 assertNotEquals(20, i);
	}
	
	
	@Test
	public void testajouterContrat() {
	Contrat contrat = new Contrat(new Date() ,"svp",1500);
	int i = iemployeservice.ajouterContrat(contrat);
	assertEquals(1, i);
	}
	
	@Test
	public void testajouterContrat2() {
	Contrat contrat = new Contrat(new Date() ,"svp",1500);
	int i = iemployeservice.ajouterContrat(contrat);
	assertNotEquals(3, i);
	}
	
	@Test
	public void getEmployePrenomById() {
		assertEquals("bernar", iemployeservice.getEmployePrenomById(15));
	}
	
	
	@Test
	public void getEmployePrenomById2() {
		assertNotEquals("bernar2", iemployeservice.getEmployePrenomById(1));
	}
	
	@Test
	public void getNombreEmployeJPQL() {
		assertEquals(20, iemployeservice.getNombreEmployeJPQL());
	}
	
	
	@Test
	public void getNombreEmployeJPQL2() {
		assertNotEquals(17, iemployeservice.getNombreEmployeJPQL());
	}
	
	@Test
	public void getAllEmployeNamesJPQL() {
	
		assertEquals(Arrays.asList("alex", "alex").toArray(), iemployeservice.getAllEmployeNamesJPQL());
	}
	
	
}
