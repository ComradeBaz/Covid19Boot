package com.domrade.beans.singleton;

import java.util.ArrayList;
import java.util.LinkedHashMap;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.domrade.entity.EntityType;
import com.domrade.interfaces.cache.CachedUsMonthlyDataServiceLocal;
import com.domrade.interfaces.local.CachedDataLocal;
import com.domrade.interfaces.local.CachedUsMonthlyDataLocal;
import com.domrade.rest.request.UsStateAndCounty;

@Component
@Scope("application")
public class CachedUsMonthlyData implements CachedUsMonthlyDataLocal {

	@Autowired
	private CachedUsMonthlyDataServiceLocal usCachedMonthlyDataService;

	@Autowired
	private CachedDataLocal cachedData;

	// Confirmed
	LinkedHashMap<String, LinkedHashMap<String, Integer>> usStateData = new LinkedHashMap<>();
	LinkedHashMap<String, LinkedHashMap<String, Integer>> usCountyData = new LinkedHashMap<>();
	// Deaths
	LinkedHashMap<String, LinkedHashMap<String, Integer>> usStateDeathsData = new LinkedHashMap<>();
	LinkedHashMap<String, LinkedHashMap<String, Integer>> usCountyDeathsData = new LinkedHashMap<>();

	public CachedUsMonthlyData() {
		// TODO Auto-generated constructor stub
	}

	@PostConstruct
	public void init() {
		usStateData = usCachedMonthlyDataService.getUsDataConfirmed("state");
		usCountyData = usCachedMonthlyDataService.getUsDataConfirmed("county");

		usStateDeathsData = usCachedMonthlyDataService.getUsDataDeaths("state");
		usCountyDeathsData = usCachedMonthlyDataService.getUsDataDeaths("county");
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
					returnList.add(this.getUsDataByState(state));
				} else {
					String countyId = cachedData.getCountyIdByStateAndCounty(state, county);
					returnList.add(this.getConfirmedCountyDataByCountyId(countyId));
				}
			} else { // EntityType.US_DEATHS
				if (level.equalsIgnoreCase("state")) {
					returnList.add(this.getUsDeathsByState(state));
				} else {
					String countyId = cachedData.getCountyIdByStateAndCounty(state, county);
					returnList.add(this.getDeathsCountyDataByCountyId(countyId));
				}
			}

		}
		return returnList;
	}

}
