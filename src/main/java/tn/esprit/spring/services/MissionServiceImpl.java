package tn.esprit.spring.services;

import java.util.List;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.Mission;
import tn.esprit.spring.repository.MissionRepository;
@Service
public class MissionServiceImpl implements IMissionService {
	@Autowired
	MissionRepository missionRepository;
	private static final Logger L =  LogManager.getLogger(MissionServiceImpl.class);
	@Override
	public Mission addMission(Mission mission) {
		return missionRepository.save(mission);
	}

	@Override
	public List<Mission> retrieveAllMissions() {

		List<Mission> missions = (List<Mission>) missionRepository.findAll();
		for (Mission mission : missions){
			
			L.log(Level.INFO, () ->"mission:+++"+ mission);
		
		}
		return missions;
	}

	@Override
	public void deleteMission(int id) {

		missionRepository.deleteById(id);
		
	}

}
