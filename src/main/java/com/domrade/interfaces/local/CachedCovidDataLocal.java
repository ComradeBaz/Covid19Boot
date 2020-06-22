package com.domrade.interfaces.local;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.domrade.chartjs.chart.data.LocationCombinedCountryAndState;
import com.domrade.entity.EntityType;
import com.domrade.rest.request.UsStateAndCounty;

@Service
public interface CachedCovidDataLocal {

	public LinkedHashMap<String, Integer> getUsDataByState(String state);

	public LinkedHashMap<String, Integer> getUsDataByCounty(String countyId);

	public LinkedHashMap<String, Integer> getUsDeathsByState(String state);

	public LinkedHashMap<String, Integer> getUsDeathsByCounty(String countyId);

	public Map<String, Integer> getConfirmedCountyDataByCountyId(long id);

	public Map<String, Integer> getDeathsCountyDataByCountyId(long id);

	public LinkedHashMap<String, Integer> getConfirmedGlobalDataByLocation(String location);

	public LinkedHashMap<String, Integer> getConfirmedGlobalDeathsDataByLocation(String location);

	public ArrayList<LinkedHashMap<String, Integer>> getDataForMultipleUsLocations(UsStateAndCounty[] statesAndCounties,
			String level, EntityType entityType);

	public ArrayList<LinkedHashMap<String, Integer>> getDataForMultipleGlobalLocations(
			LocationCombinedCountryAndState[] locations, EntityType entityType);

	public LinkedHashMap<String, Integer> getEmptyDataSet();

	public void updateCache();

}
