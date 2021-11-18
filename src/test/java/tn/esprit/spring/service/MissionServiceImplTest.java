package tn.esprit.spring.service;

import java.util.List;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import tn.esprit.spring.entities.Mission;
import tn.esprit.spring.repository.MissionRepository;
import tn.esprit.spring.services.MissionServiceImpl;

@SpringBootTest
@RunWith(SpringRunner.class)
public class MissionServiceImplTest {
	@Autowired 
	MissionServiceImpl missionServiceImpl;
	@Autowired 
	MissionRepository missionRepository; 
	private static final Logger L =  LogManager.getLogger(MissionServiceImplTest.class);
	@Test
	public void testAddMission() {
		
		
		Mission mission = new Mission("developement","backEnd");

		missionServiceImpl.addMission(mission);

		L.log(Level.INFO, () ->"la mission est ajoutée : " +mission);

		}
	
	
	@Test
	public void testRetrieveMission() {
		List<Mission> cres = missionServiceImpl.retrieveAllMissions();
		
		L.log(Level.INFO, () ->"retrieveAllMissions : " +cres);
	}
	
	
	@Test
	public void testdeleteMission(){
		missionServiceImpl.deleteMission(1);	
	}
	@Test
	public void testUpdateMission () {
		Mission p = missionRepository.findById(2).get();
		p.setName("test");
		missionRepository.save(p);
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
