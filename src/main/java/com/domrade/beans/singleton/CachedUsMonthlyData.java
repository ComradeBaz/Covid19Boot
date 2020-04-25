package com.domrade.beans.singleton;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.domrade.entity.EntityType;
import com.domrade.interfaces.cache.CachedUsMonthlyDataServiceLocal;
import com.domrade.interfaces.local.CachedDataLocal;
import com.domrade.interfaces.local.CachedGenericMonthlyDataLocal;
import com.domrade.interfaces.local.CachedUsMonthlyDataLocal;
import com.domrade.rest.request.UsStateAndCounty;

@Component
@Scope("application")
public class CachedUsMonthlyData implements CachedUsMonthlyDataLocal {

	@Autowired
	private CachedUsMonthlyDataServiceLocal usCachedMonthlyDataService;

	@Autowired
	private CachedGenericMonthlyDataLocal cachedGenericMonthlyData;

	@Autowired
	private CachedDataLocal cachedData;

	// Confirmed
	LinkedHashMap<String, LinkedHashMap<String, Integer>> usStateData = new LinkedHashMap<>();
	LinkedHashMap<String, LinkedHashMap<String, Integer>> usCountyData = new LinkedHashMap<>();
	// Deaths
	LinkedHashMap<String, LinkedHashMap<String, Integer>> usStateDeathsData = new LinkedHashMap<>();
	LinkedHashMap<String, LinkedHashMap<String, Integer>> usCountyDeathsData = new LinkedHashMap<>();
	LinkedHashMap<String, Integer> emptyDataSet = new LinkedHashMap<>();

	// Default DataSets
	private String lastKnownDate;

	public CachedUsMonthlyData() {
		// TODO Auto-generated constructor stub
	}

	@PostConstruct
	public void init() {
		usStateData = usCachedMonthlyDataService.getUsDataConfirmed("state");
		usCountyData = usCachedMonthlyDataService.getUsDataConfirmed("county");

		usStateDeathsData = usCachedMonthlyDataService.getUsDataDeaths("state");
		usCountyDeathsData = usCachedMonthlyDataService.getUsDataDeaths("county");

		this.setLastDateOfDataSets();
		this.setEmptyDataSet();
		cachedGenericMonthlyData.setLastKnownDate(lastKnownDate);
		cachedGenericMonthlyData.setEmptyDataSet(emptyDataSet);
	}

	public LinkedHashMap<String, LinkedHashMap<String, Integer>> getUsStateData() {
		return usStateData;
	}

	public void setUsStateData(LinkedHashMap<String, LinkedHashMap<String, Integer>> usStateData) {
		this.usStateData = usStateData;
	}

	public LinkedHashMap<String, LinkedHashMap<String, Integer>> getUsCountyData() {
		return usCountyData;
	}

	public void setUsCountyData(LinkedHashMap<String, LinkedHashMap<String, Integer>> usCountyData) {
		this.usCountyData = usCountyData;
	}

	public LinkedHashMap<String, LinkedHashMap<String, Integer>> getUsStateDeathsData() {
		return usStateDeathsData;
	}

	public void setUsStateDeathsData(LinkedHashMap<String, LinkedHashMap<String, Integer>> usStateDeathsData) {
		this.usStateDeathsData = usStateDeathsData;
	}

	public LinkedHashMap<String, LinkedHashMap<String, Integer>> getUsCountyDeathsData() {
		return usCountyDeathsData;
	}

	public void setUsCountyDeathsData(LinkedHashMap<String, LinkedHashMap<String, Integer>> usCountyDeathsData) {
		this.usCountyDeathsData = usCountyDeathsData;
	}

	@Override
	public LinkedHashMap<String, Integer> getUsDataByState(String state) {
		return usStateData.get(state);
	}

	@Override
	public LinkedHashMap<String, Integer> getUsDataByCounty(String countyId) {
		return usStateData.get(countyId);
	}

	@Override
	public LinkedHashMap<String, Integer> getUsDeathsByState(String state) {
		return usStateDeathsData.get(state);
	}

	@Override
	public LinkedHashMap<String, Integer> getUsDeathsByCounty(String countyId) {
		return usStateDeathsData.get(countyId);
	}

	@Override
	public LinkedHashMap<String, Integer> getConfirmedCountyDataByCountyId(String id) {
		return this.usCountyData.get(id);
	}

	@Override
	public LinkedHashMap<String, Integer> getDeathsCountyDataByCountyId(String id) {
		return this.usCountyDeathsData.get(id);
	}

	@Override
	public ArrayList<LinkedHashMap<String, Integer>> formatDataForMultipleUsLocations(
			UsStateAndCounty[] statesAndCounties, String level, EntityType entityType) {

		ArrayList<LinkedHashMap<String, Integer>> returnList = new ArrayList<>();
		for (UsStateAndCounty s : statesAndCounties) {
			String state = s.getState();
			String county = s.getCounty();

			if (entityType == EntityType.US_CONFIRMED) {
				if (level.equalsIgnoreCase("state")) {
					LinkedHashMap<String, Integer> dataSet = this.getUsDataByState(state);
					if (dataSet.size() > 0) {
						returnList.add(dataSet);
					} else {
						returnList.add(emptyDataSet);
					}
				} else {
					String countyId = cachedData.getCountyIdByStateAndCounty(state, county);
					LinkedHashMap<String, Integer> dataSet = this.getConfirmedCountyDataByCountyId(countyId);
					if (dataSet.size() > 0) {
						returnList.add(dataSet);
					} else {
						returnList.add(emptyDataSet);
					}
				}
			} else { // EntityType.US_DEATHS
				if (level.equalsIgnoreCase("state")) {
					LinkedHashMap<String, Integer> dataSet = this.getUsDeathsByState(state);
					if (dataSet.size() > 0) {
						returnList.add(dataSet);
					} else {
						returnList.add(emptyDataSet);
					}
				} else {
					String countyId = cachedData.getCountyIdByStateAndCounty(state, county);
					LinkedHashMap<String, Integer> dataSet = this.getDeathsCountyDataByCountyId(countyId);
					if (dataSet.size() > 0) {
						returnList.add(dataSet);
					} else {
						returnList.add(emptyDataSet);
					}
				}
			}

		}
		return returnList;
	}

	// Get the latest date for which there is data in the data base
	// This will be used to create empty datasets for locations which have no
	// cases/deaths
	// { date: date, value 0 }
	public void setLastDateOfDataSets() {
		Iterator<Map.Entry<String, LinkedHashMap<String, Integer>>> iterator = this.usStateData.entrySet().iterator();
		while (iterator.hasNext()) {
			Entry<String, LinkedHashMap<String, Integer>> entry = iterator.next();
			if (entry.getValue().size() > 0) {
				this.lastKnownDate = usCachedMonthlyDataService.getLastDateOfDataSets(entry.getValue());
				break;
			}
		}

	}

	public String getLastKnownDate() {
		return lastKnownDate;
	}

	public void setEmptyDataSet() {
		LinkedHashMap<String, Integer> dataSet = new LinkedHashMap<>();
		dataSet.put(this.lastKnownDate, 0);
		this.emptyDataSet = dataSet;
	}

	@Override
	public LinkedHashMap<String, Integer> getEmptyDataSet() {
		return emptyDataSet;
	}

}
