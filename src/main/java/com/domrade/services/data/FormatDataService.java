/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.domrade.services.data;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.domrade.chartjs.chart.data.Location;
import com.domrade.chartjs.chart.data.LocationCombinedCountryAndState;
import com.domrade.entity.EntityType;
import com.domrade.entity.implementation.April;
import com.domrade.entity.implementation.AprilDeaths;
import com.domrade.entity.implementation.February;
import com.domrade.entity.implementation.FebruaryDeaths;
import com.domrade.entity.implementation.January;
import com.domrade.entity.implementation.JanuaryDeaths;
import com.domrade.entity.implementation.March;
import com.domrade.entity.implementation.MarchDeaths;
import com.domrade.entity.implementation.May;
import com.domrade.entity.implementation.MayDeaths;
import com.domrade.interfaces.cache.CachedGenericMonthlyDataServiceLocal;
import com.domrade.interfaces.cache.CachedMonthlyDataServiceLocal;
import com.domrade.interfaces.data.FormatDataServiceLocal;
import com.domrade.interfaces.months.confirmed.AprilServiceLocal;
import com.domrade.interfaces.months.confirmed.FebruaryServiceLocal;
import com.domrade.interfaces.months.confirmed.JanuaryServiceLocal;
import com.domrade.interfaces.months.confirmed.MarchServiceLocal;
import com.domrade.interfaces.months.confirmed.MayServiceLocal;
import com.domrade.interfaces.months.deaths.AprilDeathsServiceLocal;
import com.domrade.interfaces.months.deaths.FebruaryDeathsServiceLocal;
import com.domrade.interfaces.months.deaths.JanuaryDeathsServiceLocal;
import com.domrade.interfaces.months.deaths.MarchDeathsServiceLocal;
import com.domrade.interfaces.months.deaths.MayDeathsServiceLocal;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 *
 * @author David
 */
@Service
public class FormatDataService implements FormatDataServiceLocal {

	private final ObjectMapper mapper = new ObjectMapper();

	@Autowired
	private JanuaryServiceLocal januaryService;

	@Autowired
	private FebruaryServiceLocal februaryService;

	@Autowired
	private MarchServiceLocal marchService;

	@Autowired
	private AprilServiceLocal aprilService;

	@Autowired
	private MayServiceLocal mayService;

	@Autowired
	private JanuaryDeathsServiceLocal januaryDeathsService;

	@Autowired
	private FebruaryDeathsServiceLocal februaryDeathsService;

	@Autowired
	private MarchDeathsServiceLocal marchDeathsService;

	@Autowired
	private AprilDeathsServiceLocal aprilDeathsService;

	@Autowired
	private MayDeathsServiceLocal mayDeathsService;

	@Autowired
	private CachedMonthlyDataServiceLocal cachedMonthlyDataService;

	@Autowired
	private CachedGenericMonthlyDataServiceLocal genericMonthlyDataService;

	@Override
	public <T> LinkedHashMap<String, Integer> removeLocationDetails(T type) {
		LinkedHashMap<String, Integer> map = mapper.convertValue(type, LinkedHashMap.class);
		// Remove id and location details
		map.remove("id");
		map.remove("provenceState");
		map.remove("countryRegion");
		map.remove("latitude");
		map.remove("longitude");

		return removePlaceholderData(map);
	}

	@Override
	public <T> LinkedHashMap<String, Integer> removePlaceholderData(LinkedHashMap<String, Integer> map) {

		// Remove entries where the value = -1(placeholder value to populate a month
		// where the month is not yet complete
		// Also remove days where total is 0 - days prior to cases being reported
		Set<Map.Entry<String, Integer>> setOfEntries = map.entrySet();
		Iterator<Map.Entry<String, Integer>> iterator = setOfEntries.iterator();

		while (iterator.hasNext()) {
			Map.Entry<String, Integer> entry = iterator.next();
			Integer value = entry.getValue();
			if ((value.compareTo(-1) == 0) || (value.compareTo(0) == 0)) {
				iterator.remove();
			}
		}
		return map;
	}

	// Combine data from month entities to one hashMap
	@Override
	public LinkedHashMap<String, Integer> getDataForAllMonths(ArrayList<LinkedHashMap<String, Integer>> data) {

		LinkedHashMap<String, Integer> returnValue = new LinkedHashMap<>();

		for (LinkedHashMap<String, Integer> entry : data) {
			// Add the map key/value to the return hashMap
			for (Map.Entry<String, Integer> mapEntry : entry.entrySet()) {
				returnValue.put(mapEntry.getKey(), mapEntry.getValue());
			}
		}
		if (returnValue.size() > 0) {
			return returnValue;
		} else {
			return genericMonthlyDataService.getEmptyDataSet();
		}
	}

	// Get the values for the days of the month for a given entity
	// and store them in an array
	// The array will be passed in a constructor to a ChartsJSDataObject constructor
	@Override
	public <T> ArrayList<Integer> getDataArrayList(T type) {
		LinkedHashMap<String, Integer> map = mapper.convertValue(type, LinkedHashMap.class);
		ArrayList<Integer> returnList = new ArrayList<>();
		int[] dataArray = new int[map.size()];
		int index = 0;
		boolean nonZeroValueSet = false;
		for (Map.Entry<String, Integer> entry : map.entrySet()) {
			// Reset boolean
			try {
				dataArray[index] = entry.getValue();
				returnList.add(entry.getValue());
				if (entry.getValue() > 0) {
					nonZeroValueSet = true;
				}
				index++;
			} catch (NullPointerException npe) {
				// If null value the position indicates a 0 value inserted to make
				// the data array the correct length unless a nonZero value has
				// already been inserted in which case it represents no new cases
				// after a case had originally been reported
				if (nonZeroValueSet) {
					dataArray[index] = 0;
					returnList.add(0);
				}
				returnList.add(null);
				index++;
			}
		}
		return returnList;
	}

	// Get entity data from database
	@Override
	public LinkedHashMap<String, Integer> formatDataForCountryAndState(String country, String state,
			EntityType entityType) {

		LinkedHashMap<String, Integer> janData;
		LinkedHashMap<String, Integer> febData;
		LinkedHashMap<String, Integer> marchData;
		LinkedHashMap<String, Integer> aprilData;
		LinkedHashMap<String, Integer> mayData;

		if (entityType == EntityType.DEATHS) {
			JanuaryDeaths januaryDeaths = januaryDeathsService.findByCountryRegionProvinceState(country, state);
			FebruaryDeaths februaryDeaths = februaryDeathsService.findByCountryRegionProvinceState(country, state);
			MarchDeaths marchDeaths = marchDeathsService.findByCountryRegionProvinceState(country, state);
			AprilDeaths aprilDeaths = aprilDeathsService.findByCountryRegionProvinceState(country, state);
			MayDeaths mayDeaths = mayDeathsService.findByCountryRegionProvinceState(country, state);

			janData = this.removeLocationDetails(januaryDeaths);
			febData = this.removeLocationDetails(februaryDeaths);
			marchData = this.removeLocationDetails(marchDeaths);
			aprilData = this.removeLocationDetails(aprilDeaths);
			mayData = this.removeLocationDetails(mayDeaths);
		} else {
			January januaryConfirmed = januaryService.findByCountryRegionProvinceState(country, state);
			February februaryConfirmed = februaryService.findByCountryRegionProvinceState(country, state);
			March marchConfirmed = marchService.findByCountryRegionProvinceState(country, state);
			April aprilConfirmed = aprilService.findByCountryRegionProvinceState(country, state);
			May mayConfirmed = mayService.findByCountryRegionProvinceState(country, state);

			janData = this.removeLocationDetails(januaryConfirmed);
			febData = this.removeLocationDetails(februaryConfirmed);
			marchData = this.removeLocationDetails(marchConfirmed);
			aprilData = this.removeLocationDetails(aprilConfirmed);
			mayData = this.removeLocationDetails(mayConfirmed);
		}

		ArrayList<LinkedHashMap<String, Integer>> listOfMaps = new ArrayList<>();
		listOfMaps.add(janData);
		listOfMaps.add(febData);
		listOfMaps.add(marchData);
		listOfMaps.add(aprilData);
		listOfMaps.add(mayData);

		return getDataForAllMonths(listOfMaps);
	}

	// Get entity data from cache
	// Handle request with location as single string of combined
	// countryRegion/provinceState
	@Override
	public LinkedHashMap<String, Integer> formatDataForLocation(String location, EntityType entityType) {

		LinkedHashMap<String, Integer> janData;
		LinkedHashMap<String, Integer> febData;
		LinkedHashMap<String, Integer> marchData;
		LinkedHashMap<String, Integer> aprilData;
		LinkedHashMap<String, Integer> mayData;

		if (entityType == EntityType.DEATHS) {
			JanuaryDeaths januaryDeaths = cachedMonthlyDataService.getJanuaryDeathsByLocation(location);
			FebruaryDeaths februaryDeaths = cachedMonthlyDataService.getFebruaryDeathsByLocation(location);
			MarchDeaths marchDeaths = cachedMonthlyDataService.getMarchDeathsByLocation(location);
			AprilDeaths aprilDeaths = cachedMonthlyDataService.getAprilDeathsByLocation(location);
			MayDeaths mayDeaths = cachedMonthlyDataService.getMayDeathsByLocation(location);

			janData = this.removeLocationDetails(januaryDeaths);
			febData = this.removeLocationDetails(februaryDeaths);
			marchData = this.removeLocationDetails(marchDeaths);
			aprilData = this.removeLocationDetails(aprilDeaths);
			mayData = this.removeLocationDetails(mayDeaths);
		} else {
			January januaryConfirmed = cachedMonthlyDataService.getJanuaryEntityByLocation(location);
			February februaryConfirmed = cachedMonthlyDataService.getFebruaryEntityByLocation(location);
			March marchConfirmed = cachedMonthlyDataService.gettMarchEntityByLocation(location);
			April aprilConfirmed = cachedMonthlyDataService.getAprilEntityByLocation(location);
			May mayConfirmed = cachedMonthlyDataService.getMayEntityByLocation(location);

			janData = this.removeLocationDetails(januaryConfirmed);
			febData = this.removeLocationDetails(februaryConfirmed);
			marchData = this.removeLocationDetails(marchConfirmed);
			aprilData = this.removeLocationDetails(aprilConfirmed);
			mayData = this.removeLocationDetails(mayConfirmed);
		}

		ArrayList<LinkedHashMap<String, Integer>> listOfMaps = new ArrayList<>();
		listOfMaps.add(janData);
		listOfMaps.add(febData);
		listOfMaps.add(marchData);
		listOfMaps.add(aprilData);
		listOfMaps.add(mayData);

		return getDataForAllMonths(listOfMaps);
	}

	// Take in an array of Locations and return an ArrayList of dataSets
	@Override
	public ArrayList<LinkedHashMap<String, Integer>> formatDataForMultipleCountriesAndStates(Location[] locations,
			EntityType entityType) {
		ArrayList<LinkedHashMap<String, Integer>> returnList = new ArrayList<>();
		for (Location l : locations) {
			returnList.add(this.formatDataForCountryAndState(l.getCountryRegion(), l.getProvinceState(), entityType));
		}
		return returnList;
	}

	// Handle request with location as single string of combined
	// countryRegion/provinceState
	@Override
	public ArrayList<LinkedHashMap<String, Integer>> formatDataForMultipleLocations(
			LocationCombinedCountryAndState[] locations, EntityType entityType) {
		ArrayList<LinkedHashMap<String, Integer>> returnList = new ArrayList<>();
		for (LocationCombinedCountryAndState l : locations) {
			returnList.add(this.formatDataForLocation(l.getCombinedCountryAndState(), entityType));
		}
		return returnList;
	}

	// Param is a Map of data as returned by this.formatDataForCountryAndState(...)
	// This method normalises the data for all countries in the Map so they can be
	// displayed on the same chart
	// The data sets are set so all start at the same date
	@Override
	public ArrayList<LinkedHashMap<String, Integer>> formatDataForListOfCountriesDataSet(
			ArrayList<LinkedHashMap<String, Integer>> listOfCountriesDataSet, int indexOfLongestMap) {
		ArrayList<LinkedHashMap<String, Integer>> formattedData = new ArrayList<>();
		// Get the map (country) with the earliest start date
		int index = getIndexOfLongestMap(listOfCountriesDataSet);
		// Get the reference map
		LinkedHashMap<String, Integer> refMap = listOfCountriesDataSet.get(index);
		formattedData.add(refMap);
		// Get a set of entries for the reference map
		Set<Map.Entry<String, Integer>> refMapSetOfEntries = refMap.entrySet();

		for (int i = 0; i < listOfCountriesDataSet.size(); i++) {
			if (i != index) {
				// Get an iterator for the reference map
				Iterator<Map.Entry<String, Integer>> iteratorRef = refMapSetOfEntries.iterator();
				// Get the key for the first entry of the current map
				LinkedHashMap<String, Integer> currentMap = listOfCountriesDataSet.get(i);
				Set<Map.Entry<String, Integer>> currentMapSetOfEntries = currentMap.entrySet();
				Iterator<Map.Entry<String, Integer>> iteratorCurrent = currentMapSetOfEntries.iterator();
				String keyCurrent;
				try {
					Map.Entry<String, Integer> entryCurrent = iteratorCurrent.next();
					keyCurrent = entryCurrent.getKey();

					// Iterate through reference Map until it reaches the date of the start of the
					// current map
					// Add extra data to a new Map
					LinkedHashMap<String, Integer> newMap = new LinkedHashMap<>();
					while (iteratorRef.hasNext()) {
						Map.Entry<String, Integer> entryRef = iteratorRef.next();
						String keyRef = entryRef.getKey();
						if (!(keyCurrent.equalsIgnoreCase(keyRef))) {
							newMap.put(keyRef, null);
						} else {
							break;
						}
					}
					// Add original data to the new Map
					newMap.put(entryCurrent.getKey(), entryCurrent.getValue());
					while (iteratorCurrent.hasNext()) {
						entryCurrent = iteratorCurrent.next();
						newMap.put(entryCurrent.getKey(), entryCurrent.getValue());
					}
					formattedData.add(newMap);
				} catch (NoSuchElementException nse) {
					System.out.println("No data");
					formattedData.add(genericMonthlyDataService.getEmptyDataSet());
				}
			}
		}
		return formattedData;
	}

	@Override
	public int getIndexOfLongestMap(ArrayList<LinkedHashMap<String, Integer>> listOfCountriesDataSet) {
		int mapLength;
		int longestMapSize = 0;
		int indexOfLongestMap = 0;
		for (int i = 0; i < listOfCountriesDataSet.size() - 1; i++) {
			mapLength = listOfCountriesDataSet.get(i).size();
			if (mapLength > longestMapSize) {
				longestMapSize = mapLength;
				indexOfLongestMap = i;
			}
			if (longestMapSize < listOfCountriesDataSet.get(i + 1).size()) {
				longestMapSize = listOfCountriesDataSet.get(i + 1).size();
				indexOfLongestMap = i + 1;
			}
		}
		return indexOfLongestMap;
	}

	@Override
	public Location[] getReorderedListOfCountries(Location[] locations, int indexOfLongestMap) {
		Location[] returnArray = new Location[locations.length];
		returnArray[0] = locations[indexOfLongestMap];
		for (int i = 1, j = 0; j < locations.length; j++) {
			if (j != indexOfLongestMap) {
				returnArray[i] = locations[j];
				i++;
			}
		}
		return returnArray;
	}

	// Handle request with location as single string of combined
	// countryRegion/provinceState
	@Override
	public LocationCombinedCountryAndState[] getReorderedListOfLocations(LocationCombinedCountryAndState[] locations,
			int indexOfLongestMap) {
		LocationCombinedCountryAndState[] returnArray = new LocationCombinedCountryAndState[locations.length];
		returnArray[0] = locations[indexOfLongestMap];
		for (int i = 1, j = 0; j < locations.length; j++) {
			if (j != indexOfLongestMap) {
				returnArray[i] = locations[j];
				i++;
			}
		}
		return returnArray;
	}
}
