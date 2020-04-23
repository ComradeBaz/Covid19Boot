package com.domrade.services.data;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.domrade.entity.EntityType;
import com.domrade.entity.implementation.USApril;
import com.domrade.entity.implementation.USFebruary;
import com.domrade.entity.implementation.USJanuary;
import com.domrade.entity.implementation.USMarch;
import com.domrade.interfaces.data.FormatUsDataServiceLocal;
import com.domrade.interfaces.months.confirmed.USAprilServiceLocal;
import com.domrade.interfaces.months.confirmed.USFebruaryServiceLocal;
import com.domrade.interfaces.months.confirmed.USJanuaryServiceLocal;
import com.domrade.interfaces.months.confirmed.USMarchServiceLocal;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class FormatUsDataService implements FormatUsDataServiceLocal {

	private final ObjectMapper mapper = new ObjectMapper();

	@Autowired
	private USJanuaryServiceLocal januaryService;

	@Autowired
	private USFebruaryServiceLocal februaryService;

	@Autowired
	private USMarchServiceLocal marchService;

	@Autowired
	private USAprilServiceLocal aprilService;

	public FormatUsDataService() {
		// TODO Auto-generated constructor stub
	}

	// Get data for states by combining the county level data to a map for each
	// state
	// Return value is a map of maps - key is the state, map of maps is a <String,
	// Integer> where key is the date and value is the data for that date

	public Map<String, Map<String, Integer>> getUsStateLevelData() {

		List<String> states = januaryService.getAllStates();
		Map<String, Map<String, Integer>> mapOfMaps = new LinkedHashMap<>();
		Map<String, Integer> refMap = new LinkedHashMap<>();
		Map<String, Integer> janEntityMap = new LinkedHashMap<>();
		Map<String, Integer> febEntityMap = new LinkedHashMap<>();
		Map<String, Integer> marEntityMap = new LinkedHashMap<>();
		Map<String, Integer> aprEntityMap = new LinkedHashMap<>();

		Map<String, Integer> combinedLocation = new LinkedHashMap<>();
		String currentState = "";

		for (String s : states) {
			currentState = s;
			// stateMap = new LinkedHashMap<>();
			// stateMap.put(s, new LinkedHashMap<String, Integer>());
			// Get all the January entries for the state
			List<USJanuary> usJanuary = januaryService.getEntryByProvenceState(s);
			List<USFebruary> usFebruary = februaryService.getEntryByProvenceState(s);
			List<USMarch> usMarch = marchService.getEntryByProvenceState(s);
			List<USApril> usApril = aprilService.getEntryByProvenceState(s);

			for (USJanuary usj : usJanuary) {
				long id = usj.getId();
				janEntityMap = this.removeLocationDetails(usj, EntityType.US_CONFIRMED);
				for (Map.Entry<String, Integer> entry : janEntityMap.entrySet()) {
					// int value = entry.getValue();
					combinedLocation.put(entry.getKey(), entry.getValue());
					// break;
				}
				for (USFebruary usf : usFebruary) {
					if (usf.getId() == id) {
						febEntityMap = this.removeLocationDetails(usf, EntityType.US_CONFIRMED);
						for (Map.Entry<String, Integer> entry : febEntityMap.entrySet()) {
							// int value = entry.getValue();
							combinedLocation.put(entry.getKey(), entry.getValue());
						}
						// break;
					}
				}
				for (USMarch usm : usMarch) {
					if (usm.getId() == id) {
						marEntityMap = this.removeLocationDetails(usm, EntityType.US_CONFIRMED);
						for (Map.Entry<String, Integer> entry : marEntityMap.entrySet()) {
							// int value = entry.getValue();
							combinedLocation.put(entry.getKey(), entry.getValue());
						}
						// break;
					}
				}
				for (USApril usa : usApril) {
					if (usa.getId() == id) {
						aprEntityMap = this.removeLocationDetails(usa, EntityType.US_CONFIRMED);
						for (Map.Entry<String, Integer> entry : aprEntityMap.entrySet()) {
							// int value = entry.getValue();
							combinedLocation.put(entry.getKey(), entry.getValue());
						}
						// break;
					}
				}

				if (refMap.size() == 0) {
					// If it's the first time through the for loop copy the entity returned from
					for (Map.Entry<String, Integer> entry : combinedLocation.entrySet()) {
						int value = entry.getValue();
						if (value < 0) {
							value = -1;
						}
						refMap.put(entry.getKey(), value);
					}
				} else {
					// If there is an entry in refMap get an iterator for the current Map and add
					// the values for the entries together
					for (Map.Entry<String, Integer> entry : combinedLocation.entrySet()) {
						int value = entry.getValue();
						int refMapValue = refMap.get(entry.getKey());
						if (value >= 0) {
							refMap.put(entry.getKey(), (value + refMapValue));
						} else {
							refMap.put(entry.getKey(), -1);
						}
					}
				}

			} // end of entity loop
			Map<String, Integer> mapToAdd = new LinkedHashMap<>();
			for (Map.Entry<String, Integer> entry : refMap.entrySet()) {
				mapToAdd.put(entry.getKey(), entry.getValue());
			}
			mapOfMaps.put(currentState, mapToAdd);
			refMap.clear();

		} // end of state loop

		return mapOfMaps;

	}

	@Override
	public <T> LinkedHashMap<String, Integer> removeLocationDetails(T type, EntityType entityType) {
		LinkedHashMap<String, Integer> map = mapper.convertValue(type, LinkedHashMap.class);
		// Remove id and location details
		map.remove("id");
		map.remove("provenceState");
		map.remove("countryRegion");
		map.remove("latitude");
		map.remove("longitude");
		map.remove("admin2");

		if (entityType == EntityType.US_DEATHS) {
			map.remove("population");
		}

		return map;
	}

	// Gets a Map of maps - key is the UID identifying the entity, value is a map of
	// <String, Integer> with dates and totals for each day

	public LinkedHashMap<String, LinkedHashMap<String, Integer>> getUsData(String level, EntityType entityType) {

		List<String> states = januaryService.getAllStates();
		LinkedHashMap<String, LinkedHashMap<String, Integer>> mapOfMaps = new LinkedHashMap<>();
		Map<String, Integer> refMap = new LinkedHashMap<>();
		Map<String, Integer> janEntityMap = new LinkedHashMap<>();
		Map<String, Integer> febEntityMap = new LinkedHashMap<>();
		Map<String, Integer> marEntityMap = new LinkedHashMap<>();
		Map<String, Integer> aprEntityMap = new LinkedHashMap<>();

		Map<String, Map<String, Integer>> combinedUs = new LinkedHashMap<>();
		Map<String, Integer> combinedLocation = new LinkedHashMap<>();
		String currentState = "";

		boolean countyLevel;
		if (level.equalsIgnoreCase("county")) {
			countyLevel = true;
		} else {
			countyLevel = false;
		}

		for (String s : states) {
			currentState = s;
			List<USJanuary> usJanuary = januaryService.getEntryByProvenceState(s);
			List<USFebruary> usFebruary = februaryService.getEntryByProvenceState(s);
			List<USMarch> usMarch = marchService.getEntryByProvenceState(s);
			List<USApril> usApril = aprilService.getEntryByProvenceState(s);

			for (USJanuary usj : usJanuary) {
				long id = usj.getId();
				janEntityMap = this.removeLocationDetails(usj, entityType);
				for (Map.Entry<String, Integer> entry : janEntityMap.entrySet()) {
					combinedLocation.put(entry.getKey(), entry.getValue());
					// break;
				}
				for (USFebruary usf : usFebruary) {
					if (usf.getId() == id) {
						febEntityMap = this.removeLocationDetails(usf, entityType);
						for (Map.Entry<String, Integer> entry : febEntityMap.entrySet()) {
							combinedLocation.put(entry.getKey(), entry.getValue());
						}
					}
				}
				for (USMarch usm : usMarch) {
					if (usm.getId() == id) {
						marEntityMap = this.removeLocationDetails(usm, entityType);
						for (Map.Entry<String, Integer> entry : marEntityMap.entrySet()) {
							combinedLocation.put(entry.getKey(), entry.getValue());
						}
					}
				}
				for (USApril usa : usApril) {
					if (usa.getId() == id) {
						aprEntityMap = this.removeLocationDetails(usa, entityType);
						for (Map.Entry<String, Integer> entry : aprEntityMap.entrySet()) {
							combinedLocation.put(entry.getKey(), entry.getValue());
						}
					}
				}
				String sid = Long.toString(usj.getId());
				combinedUs.put(Long.toString(usj.getId()), combinedLocation);
				if (refMap.size() == 0) {
					// If it's the first time through the for loop copy the entity returned from
					for (Map.Entry<String, Integer> entry : combinedLocation.entrySet()) {
						int value = entry.getValue();
						if (value < 0) {
							value = -1;
						}
						refMap.put(entry.getKey(), value);
					}
				} else {
					// If there is an entry in refMap get an iterator for the current Map and add
					// the values for the entries together
					for (Map.Entry<String, Integer> entry : combinedLocation.entrySet()) {
						int value = entry.getValue();
						int refMapValue = refMap.get(entry.getKey());
						if (value >= 0) {
							refMap.put(entry.getKey(), (value + refMapValue));
						} else {
							refMap.put(entry.getKey(), -1);
						}
					}
				}

				LinkedHashMap<String, Integer> mapToAdd = new LinkedHashMap<>();
				for (Map.Entry<String, Integer> entry : refMap.entrySet()) {
					mapToAdd.put(entry.getKey(), entry.getValue());
				}
				if (countyLevel) {
					mapOfMaps.put(sid, mapToAdd);
					refMap.clear();
				}
			} // end of entity loop
			if (!countyLevel) {
				LinkedHashMap<String, Integer> mapToAdd = new LinkedHashMap<>();
				for (Map.Entry<String, Integer> entry : refMap.entrySet()) {
					mapToAdd.put(entry.getKey(), entry.getValue());
				}
				mapOfMaps.put(currentState, mapToAdd);
				refMap.clear();
			}
		} // end of state loop

		return mapOfMaps;

	}

}
