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

import com.domrade.chartjs.chart.data.LocationCombinedCountryAndState;
import com.domrade.interfaces.data.FormatDataServiceLocal;
import com.domrade.interfaces.local.CachedCovidDataLocal;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 *
 * @author David
 */
@Service
public class FormatDataService implements FormatDataServiceLocal {

	private final ObjectMapper mapper = new ObjectMapper();

	@Autowired
	private CachedCovidDataLocal cachedCovidData;

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

	// Normalise the length of the data set for each location in listOfCountries
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
					formattedData.add(cachedCovidData.getEmptyDataSet());
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
