/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.domrade.interfaces.data;

import java.util.ArrayList;
import java.util.LinkedHashMap;

import org.springframework.stereotype.Service;

import com.domrade.chartjs.chart.data.Location;
import com.domrade.chartjs.chart.data.LocationCombinedCountryAndState;
import com.domrade.entity.EntityType;

/**
 *
 * @author David
 */
@Service
public interface FormatDataServiceLocal {

	public ArrayList<LinkedHashMap<String, Integer>> formatDataForListOfCountriesDataSet(
			ArrayList<LinkedHashMap<String, Integer>> listOfCountriesDataSet, int indexOfLongestMap);

	public ArrayList<LinkedHashMap<String, Integer>> formatDataForMultipleCountriesAndStates(Location[] locations,
			EntityType entityType);

	public LinkedHashMap<String, Integer> getDataForAllMonths(ArrayList<LinkedHashMap<String, Integer>> data);

	public LinkedHashMap<String, Integer> formatDataForCountryAndState(String country, String state,
			EntityType entityType);

	public <T> LinkedHashMap<String, Integer> removeLocationDetails(T type);

	public <T> ArrayList<Integer> getDataArrayList(T type);

	public Location[] getReorderedListOfCountries(Location[] locations, int indexOfLongestMap);

	public int getIndexOfLongestMap(ArrayList<LinkedHashMap<String, Integer>> listOfCountriesDataSet);

	public LinkedHashMap<String, Integer> formatDataForLocation(String location, EntityType entityType);

	public ArrayList<LinkedHashMap<String, Integer>> formatDataForMultipleLocations(
			LocationCombinedCountryAndState[] locations, EntityType entityType);

	public LocationCombinedCountryAndState[] getReorderedListOfLocations(LocationCombinedCountryAndState[] locations,
			int indexOfLongestMap);

	public <T> LinkedHashMap<String, Integer> removePlaceholderData(LinkedHashMap<String, Integer> map);
}
