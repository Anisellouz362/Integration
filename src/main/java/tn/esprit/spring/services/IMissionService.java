package tn.esprit.spring.services;

import java.util.List;

import tn.esprit.spring.entities.Mission;

public interface IMissionService {
	Mission addMission(Mission mission);
	List<Mission> retrieveAllMissions();
	void deleteMission(int id);
}
