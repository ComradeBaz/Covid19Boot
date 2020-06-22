package com.domrade.services.cache;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.domrade.interfaces.cache.ICachedLocations;
import com.domrade.interfaces.local.GlobalLocationLocal;
import com.domrade.interfaces.local.UsLocationsLocal;
import com.domrade.interfaces.local.UsStatesLocal;

@Service
public class CachedLocationsService implements ICachedLocations {

	@Autowired
	private GlobalLocationLocal globalLocation;

	@Autowired
	private UsLocationsLocal usLocations;

	@Autowired
	private UsStatesLocal usStates;

	public CachedLocationsService() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<String> getGlobalLocations() {
		return globalLocation.findAllGlobalLocationNames();
	}

	@Override
	public List<Long> getGlobalLocationIds() {
		return globalLocation.findAllGlobalLocationIds();
	}

	@Override
	public List<String> getUsStates() {
		return usStates.findAllStates();
	}

	@Override
	public List<Long> getUsLocationIds() {
		return usLocations.getUsLocationIds();
	}

	// First String is usState.state
	// Second String is usLocations.county
	// Long is usLocations.id
	@Override
	public LinkedHashMap<String, LinkedHashMap<String, Long>> getUsStatesAndCounties() {

		LinkedHashMap<String, LinkedHashMap<String, Long>> returnMap = new LinkedHashMap<>();

		List<Long> stateIds = usStates.findAllStateIds();
		for (Long l : stateIds) {
			// Get the state - Key
			String state = usStates.getStateNameById(l);
			// Get the list of countyIds for the state
			List<Long> countyIds = usLocations.getCountiesByStateId(l);
			LinkedHashMap<String, Long> countyAndId = new LinkedHashMap<>();
			for (Long countyId : countyIds) {
				// Get the county String for the county Id
				String county = usLocations.getCountyNameByLocationId(countyId);
				if (county.length() == 0) {
					county = state;
				}
				countyAndId.put(county, countyId);
			}
			returnMap.put(state, countyAndId);
		}
		return returnMap;
	}

	@Override
	public LinkedHashMap<String, ArrayList<String>> getStatesAndCountiesNoId() {
		LinkedHashMap<String, ArrayList<String>> returnMap = new LinkedHashMap<>();
		List<Long> stateIds = usStates.findAllStateIds();
		for (Long stateId : stateIds) {
			String state = usStates.getStateNameById(stateId);
			ArrayList<String> counties = usLocations.getCountyNamesByStateId(stateId);
			if (counties.size() == 1) {
				counties.clear();
				counties.add(state);
			}
			returnMap.put(state, counties);
		}
		return returnMap;
	}

}
