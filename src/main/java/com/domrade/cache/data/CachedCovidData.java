package com.domrade.cache.data;

import java.util.ArrayList;
import java.util.LinkedHashMap;

import javax.annotation.PostConstruct;

import org.jboss.logging.Logger;
import org.jboss.logging.Logger.Level;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.domrade.chartjs.chart.data.LocationCombinedCountryAndState;
import com.domrade.entity.EntityType;
import com.domrade.interfaces.cache.CachedLocationsLocal;
import com.domrade.interfaces.cache.ICachedCovidData;
import com.domrade.interfaces.local.CachedCovidDataLocal;
import com.domrade.interfaces.local.CovidDataLocal;
import com.domrade.rest.request.UsStateAndCounty;

@Component
@Scope("singleton")
public class CachedCovidData implements CachedCovidDataLocal {

	private static final Logger LOGGER = Logger.getLogger(CachedCovidData.class);

	@Autowired
	private ICachedCovidData cachedCovidDataService;

	@Autowired
	private CovidDataLocal covidDataService;

	@Autowired
	private CachedLocationsLocal cachedLocations;

	private boolean cacheOne = true;
	private boolean cacheTwo = false;

	// Confirmed CacheOne
	LinkedHashMap<String, LinkedHashMap<String, Integer>> usStateDataCacheOne = new LinkedHashMap<>();
	LinkedHashMap<Long, LinkedHashMap<String, Integer>> usCountyDataCacheOne = new LinkedHashMap<>();
	// Deaths
	LinkedHashMap<String, LinkedHashMap<String, Integer>> usStateDeathsDataCacheOne = new LinkedHashMap<>();
	LinkedHashMap<Long, LinkedHashMap<String, Integer>> usCountyDeathsDataCacheOne = new LinkedHashMap<>();

	// Confirmed CacheTwo
	LinkedHashMap<String, LinkedHashMap<String, Integer>> usStateDataCacheTwo = new LinkedHashMap<>();
	LinkedHashMap<Long, LinkedHashMap<String, Integer>> usCountyDataCacheTwo = new LinkedHashMap<>();
	// Deaths
	LinkedHashMap<String, LinkedHashMap<String, Integer>> usStateDeathsDataCacheTwo = new LinkedHashMap<>();
	LinkedHashMap<Long, LinkedHashMap<String, Integer>> usCountyDeathsDataCacheTwo = new LinkedHashMap<>();
	LinkedHashMap<String, Integer> emptyDataSet = new LinkedHashMap<>();

	// Default DataSets
	private String lastKnownDate;

	// Global Data
	LinkedHashMap<String, LinkedHashMap<String, Integer>> globalDataCacheOne = new LinkedHashMap<>();
	LinkedHashMap<String, LinkedHashMap<String, Integer>> globalDeathsDataCacheOne = new LinkedHashMap<>();

	LinkedHashMap<String, LinkedHashMap<String, Integer>> globalDataCacheTwo = new LinkedHashMap<>();
	LinkedHashMap<String, LinkedHashMap<String, Integer>> globalDeathsDataCacheTwo = new LinkedHashMap<>();

	public CachedCovidData() {
		// TODO Auto-generated constructor stub
	}

	@PostConstruct
	public void init() {
		LOGGER.log(Level.DEBUG, "Initialising CovidData cache");
		usStateDataCacheOne = cachedCovidDataService.getCachedUsStateData("us_confirmed");
		usStateDeathsDataCacheOne = cachedCovidDataService.getCachedUsStateData("us_deaths");
		usCountyDataCacheOne = cachedCovidDataService.getCachedUsCountyData("us_confirmed");
		usCountyDeathsDataCacheOne = cachedCovidDataService.getCachedUsCountyData("us_deaths");

		globalDataCacheOne = cachedCovidDataService.getGlobalData("global_confirmed");
		globalDeathsDataCacheOne = cachedCovidDataService.getGlobalData("global_deaths");
	}

	@Override
	public void updateCache() {
		if (!cacheOne) {
			LOGGER.log(Level.DEBUG, "Updating cacheOne");
			usStateDataCacheOne = cachedCovidDataService.getCachedUsStateData("us_confirmed");
			usCountyDataCacheOne = cachedCovidDataService.getCachedUsCountyData("us_confirmed");

			usStateDeathsDataCacheOne = cachedCovidDataService.getCachedUsStateData("us_deaths");
			usCountyDeathsDataCacheOne = cachedCovidDataService.getCachedUsCountyData("us_deaths");

			globalDataCacheOne = cachedCovidDataService.getGlobalData("global_confirmed");
			globalDeathsDataCacheOne = cachedCovidDataService.getGlobalData("global_deaths");

			this.setLastDateOfDataSets();
			this.setEmptyDataSet();
			cacheOne = true;
			cacheTwo = false;
		} else {
			LOGGER.log(Level.DEBUG, "Updating cacheTwo");
			usStateDataCacheTwo = cachedCovidDataService.getCachedUsStateData("us_confirmed");
			usCountyDataCacheTwo = cachedCovidDataService.getCachedUsCountyData("us_confirmed");

			usStateDeathsDataCacheTwo = cachedCovidDataService.getCachedUsStateData("us_deaths");
			usCountyDeathsDataCacheTwo = cachedCovidDataService.getCachedUsCountyData("us_deaths");

			globalDataCacheTwo = cachedCovidDataService.getGlobalData("global_confirmed");
			globalDeathsDataCacheTwo = cachedCovidDataService.getGlobalData("global_deaths");

			this.setLastDateOfDataSets();
			this.setEmptyDataSet();
			cacheOne = false;
			cacheTwo = true;
		}
	}

	/*
	 * public LinkedHashMap<String, LinkedHashMap<String, Integer>> getUsStateData()
	 * { if (cacheOne) { return usStateDataCacheOne; } else { return
	 * usStateDataCacheTwo; } }
	 * 
	 * public void setUsStateData(LinkedHashMap<String, LinkedHashMap<String,
	 * Integer>> usStateData) { this.usStateDataCacheOne = usStateData; }
	 * 
	 * public void setUsStateDataCacheTwo(LinkedHashMap<String,
	 * LinkedHashMap<String, Integer>> usStateData) { this.usStateDataCacheTwo =
	 * usStateData; }
	 * 
	 * public LinkedHashMap<Long, LinkedHashMap<String, Integer>> getUsCountyData()
	 * { if (cacheOne) { return usCountyDataCacheOne; } else { return
	 * usCountyDataCacheTwo; } }
	 * 
	 * public void setUsCountyDataCacheOne(LinkedHashMap<Long, LinkedHashMap<String,
	 * Integer>> usCountyData) { this.usCountyDataCacheOne = usCountyData; }
	 * 
	 * public void setUsCountyDataCacheTwo(LinkedHashMap<Long, LinkedHashMap<String,
	 * Integer>> usCountyData) { this.usCountyDataCacheTwo = usCountyData; }
	 * 
	 * public LinkedHashMap<String, LinkedHashMap<String, Integer>>
	 * getUsStateDeathsData() { if (cacheOne) { return usStateDeathsDataCacheOne; }
	 * else { return usStateDeathsDataCacheTwo; } }
	 * 
	 * public void setUsStateDeathsDataCacheOne(LinkedHashMap<String,
	 * LinkedHashMap<String, Integer>> usStateDeathsData) {
	 * this.usStateDeathsDataCacheOne = usStateDeathsData; }
	 * 
	 * public void setUsStateDeathsDataCacheTwo(LinkedHashMap<String,
	 * LinkedHashMap<String, Integer>> usStateDeathsData) {
	 * this.usStateDeathsDataCacheTwo = usStateDeathsData; }
	 * 
	 * public LinkedHashMap<Long, LinkedHashMap<String, Integer>>
	 * getUsCountyDeathsData() { if (cacheOne) { return usCountyDeathsDataCacheOne;
	 * } else { return usCountyDeathsDataCacheTwo; } }
	 * 
	 * public void setUsCountyDeathsDataCacheOne(LinkedHashMap<Long,
	 * LinkedHashMap<String, Integer>> usCountyDeathsData) {
	 * this.usCountyDeathsDataCacheOne = usCountyDeathsData; }
	 * 
	 * public void setUsCountyDeathsDataCacheTwo(LinkedHashMap<Long,
	 * LinkedHashMap<String, Integer>> usCountyDeathsData) {
	 * this.usCountyDeathsDataCacheTwo = usCountyDeathsData; }
	 * 
	 */

	@Override
	public LinkedHashMap<String, Integer> getUsDataByState(String state) {
		if (cacheOne) {
			return usStateDataCacheOne.get(state);
		} else {
			return usStateDataCacheTwo.get(state);
		}
	}

	@Override
	public LinkedHashMap<String, Integer> getUsDataByCounty(String countyId) {
		if (cacheOne) {
			return usStateDataCacheOne.get(countyId);
		} else {
			return usStateDataCacheTwo.get(countyId);
		}
	}

	@Override
	public LinkedHashMap<String, Integer> getUsDeathsByState(String state) {
		if (cacheOne) {
			return usStateDeathsDataCacheOne.get(state);
		} else {
			return usStateDeathsDataCacheTwo.get(state);
		}
	}

	@Override
	public LinkedHashMap<String, Integer> getUsDeathsByCounty(String countyId) {
		if (cacheOne) {
			return usStateDeathsDataCacheOne.get(countyId);
		} else {
			return usStateDeathsDataCacheTwo.get(countyId);
		}
	}

	@Override
	public LinkedHashMap<String, Integer> getConfirmedCountyDataByCountyId(long id) {
		if (cacheOne) {
			return this.usCountyDataCacheOne.get(id);
		} else {
			return this.usCountyDataCacheTwo.get(id);
		}
	}

	@Override
	public LinkedHashMap<String, Integer> getDeathsCountyDataByCountyId(long id) {
		if (cacheOne) {
			return this.usCountyDeathsDataCacheOne.get(id);
		} else {
			return this.usCountyDeathsDataCacheTwo.get(id);
		}
	}

	@Override
	public LinkedHashMap<String, Integer> getConfirmedGlobalDataByLocation(String location) {
		if (cacheOne) {
			return this.globalDataCacheOne.get(location);
		} else {
			return this.globalDataCacheTwo.get(location);
		}
	}

	@Override
	public LinkedHashMap<String, Integer> getConfirmedGlobalDeathsDataByLocation(String location) {
		if (cacheOne) {
			return this.globalDeathsDataCacheOne.get(location);
		} else {
			return this.globalDeathsDataCacheTwo.get(location);
		}
	}

	// Return Value is a list of names of locations with a map of key = date, value
	// = data for that date
	@Override
	public ArrayList<LinkedHashMap<String, Integer>> getDataForMultipleGlobalLocations(
			LocationCombinedCountryAndState[] locations, EntityType entityType) {

		ArrayList<LinkedHashMap<String, Integer>> returnList = new ArrayList<>();
		for (LocationCombinedCountryAndState l : locations) {
			String s = l.getCombinedCountryAndState();
			if (entityType == EntityType.CONFIRMED) {
				LinkedHashMap<String, Integer> dataSet = this.getConfirmedGlobalDataByLocation(s);
				if (dataSet.size() > 0) {
					returnList.add(dataSet);
				} else {
					returnList.add(emptyDataSet);
				}
			} else {
				LinkedHashMap<String, Integer> dataSet = this.getConfirmedGlobalDeathsDataByLocation(s);
				if (dataSet.size() > 0) {
					returnList.add(dataSet);
				} else {
					returnList.add(emptyDataSet);
				}
			}
		}

		return returnList;
	}

	// Return Value is a list of names of locations with a map of key = date, value
	// = data for that date
	@Override
	public ArrayList<LinkedHashMap<String, Integer>> getDataForMultipleUsLocations(UsStateAndCounty[] statesAndCounties,
			String level, EntityType entityType) {

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
					long countyId = cachedLocations.getCountyIdByStateAndCounty(state, county);
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
					long countyId = cachedLocations.getCountyIdByStateAndCounty(state, county);
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

	// Get the latest date for which there is data in the database
	// This will be used to create empty datasets for locations which have no
	// cases/deaths
	// { date: date, value 0 }
	public void setLastDateOfDataSets() {
		this.lastKnownDate = covidDataService.getMaxDate();
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
