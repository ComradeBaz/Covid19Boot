package com.domrade.services.cache;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.domrade.entity.EntityType;
import com.domrade.entity.implementation.USApril;
import com.domrade.entity.implementation.USAprilDeaths;
import com.domrade.entity.implementation.USFebruary;
import com.domrade.entity.implementation.USFebruaryDeaths;
import com.domrade.entity.implementation.USJanuary;
import com.domrade.entity.implementation.USJanuaryDeaths;
import com.domrade.entity.implementation.USMarch;
import com.domrade.entity.implementation.USMarchDeaths;
import com.domrade.interfaces.cache.CachedUsMonthlyDataServiceLocal;
import com.domrade.interfaces.data.FormatDataServiceLocal;
import com.domrade.interfaces.data.FormatUsDataServiceLocal;
import com.domrade.interfaces.months.confirmed.USAprilServiceLocal;
import com.domrade.interfaces.months.confirmed.USFebruaryServiceLocal;
import com.domrade.interfaces.months.confirmed.USJanuaryServiceLocal;
import com.domrade.interfaces.months.confirmed.USMarchServiceLocal;
import com.domrade.interfaces.months.deaths.USAprilDeathsServiceLocal;
import com.domrade.interfaces.months.deaths.USFebruaryDeathsServiceLocal;
import com.domrade.interfaces.months.deaths.USJanuaryDeathsServiceLocal;
import com.domrade.interfaces.months.deaths.USMarchDeathsServiceLocal;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class CachedUsMonthlyDataService implements CachedUsMonthlyDataServiceLocal {

	private final ObjectMapper mapper = new ObjectMapper();

	@Autowired
	private USJanuaryServiceLocal januaryService;

	@Autowired
	private USFebruaryServiceLocal februaryService;

	@Autowired
	private USMarchServiceLocal marchService;

	@Autowired
	private USAprilServiceLocal aprilService;

	@Autowired
	private USJanuaryDeathsServiceLocal januaryDeathsService;

	@Autowired
	private USFebruaryDeathsServiceLocal februaryDeathsService;

	@Autowired
	private USMarchDeathsServiceLocal marchDeathsService;

	@Autowired
	private USAprilDeathsServiceLocal aprilDeathsService;

	@Autowired
	private FormatUsDataServiceLocal formatUsDataService;

	@Autowired
	private FormatDataServiceLocal formatDataService;

	public CachedUsMonthlyDataService() {
		// TODO Auto-generated constructor stub
	}

	// Gets a Map of maps - key is the UID identifying the entity, value is a map of
	// <String, Integer> with dates and totals for each day
	@Override
	public LinkedHashMap<String, LinkedHashMap<String, Integer>> getUsDataConfirmed(String level) {

		EntityType entityType = EntityType.US_CONFIRMED;

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
				janEntityMap = formatUsDataService.removeLocationDetails(usj, entityType);
				for (Map.Entry<String, Integer> entry : janEntityMap.entrySet()) {
					combinedLocation.put(entry.getKey(), entry.getValue());
					// break;
				}
				for (USFebruary usf : usFebruary) {
					if (usf.getId() == id) {
						febEntityMap = formatUsDataService.removeLocationDetails(usf, entityType);
						for (Map.Entry<String, Integer> entry : febEntityMap.entrySet()) {
							combinedLocation.put(entry.getKey(), entry.getValue());
						}
					}
				}
				for (USMarch usm : usMarch) {
					if (usm.getId() == id) {
						marEntityMap = formatUsDataService.removeLocationDetails(usm, entityType);
						for (Map.Entry<String, Integer> entry : marEntityMap.entrySet()) {
							combinedLocation.put(entry.getKey(), entry.getValue());
						}
					}
				}
				for (USApril usa : usApril) {
					if (usa.getId() == id) {
						aprEntityMap = formatUsDataService.removeLocationDetails(usa, entityType);
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
					mapOfMaps.put(sid, formatDataService.removePlaceholderData(mapToAdd));
					refMap.clear();
				}
			} // end of entity loop
			if (!countyLevel) {
				LinkedHashMap<String, Integer> mapToAdd = new LinkedHashMap<>();
				for (Map.Entry<String, Integer> entry : refMap.entrySet()) {
					mapToAdd.put(entry.getKey(), entry.getValue());
				}
				mapOfMaps.put(currentState, formatDataService.removePlaceholderData(mapToAdd));
				refMap.clear();
			}
		} // end of state loop

		return mapOfMaps;

	}

	// Gets a Map of maps - key is the UID identifying the entity, value is a map of
	// <String, Integer> with dates and totals for each day

	@Override
	public LinkedHashMap<String, LinkedHashMap<String, Integer>> getUsDataDeaths(String level) {

		EntityType entityType = EntityType.US_DEATHS;

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
			List<USJanuaryDeaths> usJanuary = januaryDeathsService.getEntryByProvenceState(s);
			List<USFebruaryDeaths> usFebruary = februaryDeathsService.getEntryByProvenceState(s);
			List<USMarchDeaths> usMarch = marchDeathsService.getEntryByProvenceState(s);
			List<USAprilDeaths> usApril = aprilDeathsService.getEntryByProvenceState(s);

			for (USJanuaryDeaths usj : usJanuary) {
				long id = usj.getId();
				janEntityMap = formatUsDataService.removeLocationDetails(usj, entityType);
				for (Map.Entry<String, Integer> entry : janEntityMap.entrySet()) {
					combinedLocation.put(entry.getKey(), entry.getValue());
					// break;
				}
				for (USFebruaryDeaths usf : usFebruary) {
					if (usf.getId() == id) {
						febEntityMap = formatUsDataService.removeLocationDetails(usf, entityType);
						for (Map.Entry<String, Integer> entry : febEntityMap.entrySet()) {
							combinedLocation.put(entry.getKey(), entry.getValue());
						}
					}
				}
				for (USMarchDeaths usm : usMarch) {
					if (usm.getId() == id) {
						marEntityMap = formatUsDataService.removeLocationDetails(usm, entityType);
						for (Map.Entry<String, Integer> entry : marEntityMap.entrySet()) {
							combinedLocation.put(entry.getKey(), entry.getValue());
						}
					}
				}
				for (USAprilDeaths usa : usApril) {
					if (usa.getId() == id) {
						aprEntityMap = formatUsDataService.removeLocationDetails(usa, entityType);
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
					mapOfMaps.put(sid, formatDataService.removePlaceholderData(mapToAdd));
					refMap.clear();
				}
			} // end of entity loop
			if (!countyLevel) {
				LinkedHashMap<String, Integer> mapToAdd = new LinkedHashMap<>();
				for (Map.Entry<String, Integer> entry : refMap.entrySet()) {
					mapToAdd.put(entry.getKey(), entry.getValue());
				}
				mapOfMaps.put(currentState, formatDataService.removePlaceholderData(mapToAdd));
				refMap.clear();
			}
		} // end of state loop

		return mapOfMaps;

	}

	@Override
	public LinkedHashMap<String, LinkedHashMap<String, String>> getStatesAndCounties() {

		List<String> states = januaryService.getAllStates();
		LinkedHashMap<String, LinkedHashMap<String, String>> mapOfMaps = new LinkedHashMap<>();
		LinkedHashMap<String, String> refMap = new LinkedHashMap<>();
		List<String> counties = new ArrayList<>();
		LinkedHashMap<String, List<String>> statesAndCounties = new LinkedHashMap<>();

		LinkedHashMap<String, String> countyAndId = new LinkedHashMap<>();
		String currentState = "";

		for (String s : states) {
			currentState = s;
			List<USJanuary> usJanuary = januaryService.getEntryByProvenceState(s);
			// statesAndCounties = new LinkedHashMap<>();

			for (USJanuary usj : usJanuary) {
				long id = usj.getId();
				String county = usj.getAdmin2();
				String sid = Long.toString(usj.getId());

				// Some state eg American Samoa don't have a county associated
				if (county.equalsIgnoreCase("")) {
					county = s;
				}
				countyAndId.put(county, sid);
				counties.add(county);
			} // end of entity loop
				// refMap.putAll(countyAndId);
			List<String> countiesToAdd = new ArrayList<>();
			for (String st : counties) {
				countiesToAdd.add(st);
			}
			counties.clear();
			statesAndCounties.put(s, countiesToAdd);
			LinkedHashMap<String, String> mapToAdd = new LinkedHashMap<>();
			for (Map.Entry<String, String> entry : countyAndId.entrySet()) {
				mapToAdd.put(entry.getKey(), entry.getValue());
			}
			mapOfMaps.put(currentState, mapToAdd);
			countyAndId.clear();
		} // end of state loop
		return mapOfMaps;
	}

	@Override
	public LinkedHashMap<String, ArrayList<String>> getCountiesByState(
			LinkedHashMap<String, LinkedHashMap<String, String>> statesAndCounties) {
		String state = "";
		String county = "";
		LinkedHashMap<String, ArrayList<String>> returnMap = new LinkedHashMap<>();
		ArrayList<String> counties = new ArrayList<>();
		for (Map.Entry<String, LinkedHashMap<String, String>> entry : statesAndCounties.entrySet()) {
			state = entry.getKey();
			for (Map.Entry<String, String> e : entry.getValue().entrySet()) {
				county = e.getKey();
				counties.add(county);
			}
			ArrayList<String> listToAdd = new ArrayList<>();
			for (String s : counties) {
				listToAdd.add(s);
			}
			returnMap.put(state, listToAdd);
			counties.clear();
		}
		return returnMap;
	}

	// Get the latest date for which there is data in the data base
	// This will be used to create empty datasets for locations which have no
	// cases/deaths
	// { date: date, value 0 }
	@Override
	public String getLastDateOfDataSets(LinkedHashMap<String, Integer> aDataSet) {
		String key = "";
		for (Map.Entry<String, Integer> mapEntry : aDataSet.entrySet()) {
			key = mapEntry.getKey();
		}
		return key;

	}
}
