package tn.esprit.spring.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import tn.esprit.spring.entities.Contrat;
import tn.esprit.spring.entities.Role;
import tn.esprit.spring.entities.User;
import tn.esprit.spring.services.IContratService;


@RunWith(SpringRunner.class)
@SpringBootTest
public class ContratServiceImplTest {

	@Autowired
	IContratService co; 
	
	
	@Test
	public void testaddContrat() throws ParseException {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date d = dateFormat.parse("2021-03-23");
		Contrat u = new Contrat(d,"CDD",120);
		Assert.assertEquals(u.getTypeContrat(), u.getTypeContrat());
	}
	
	
	
	 
		@Test
		public void testModifyContrat() throws ParseException   {
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			Date d = dateFormat.parse("2015-03-23");
			Contrat u = new Contrat(d,"CDD",120); 
			Contrat contratUpdated  = co.majContrat(u); 
			Assert.assertEquals(u.getDateDebut(), contratUpdated.getDateDebut());
		}

		@Test
		public void testDeleteContrat() {
			co.deleteContrat(17);
		Assert.assertNull(co.retrieveContrat(17));
		}

}
