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

	private boolean cacheOne = true;
	private boolean cacheTwo = false;

	// Confirmed CacheOne
	LinkedHashMap<String, LinkedHashMap<String, Integer>> usStateDataCacheOne = new LinkedHashMap<>();
	LinkedHashMap<String, LinkedHashMap<String, Integer>> usCountyDataCacheOne = new LinkedHashMap<>();
	// Deaths
	LinkedHashMap<String, LinkedHashMap<String, Integer>> usStateDeathsDataCacheOne = new LinkedHashMap<>();
	LinkedHashMap<String, LinkedHashMap<String, Integer>> usCountyDeathsDataCacheOne = new LinkedHashMap<>();

	// Confirmed CacheTwo
	LinkedHashMap<String, LinkedHashMap<String, Integer>> usStateDataCacheTwo = new LinkedHashMap<>();
	LinkedHashMap<String, LinkedHashMap<String, Integer>> usCountyDataCacheTwo = new LinkedHashMap<>();
	// Deaths
	LinkedHashMap<String, LinkedHashMap<String, Integer>> usStateDeathsDataCacheTwo = new LinkedHashMap<>();
	LinkedHashMap<String, LinkedHashMap<String, Integer>> usCountyDeathsDataCacheTwo = new LinkedHashMap<>();
	LinkedHashMap<String, Integer> emptyDataSet = new LinkedHashMap<>();

	// Default DataSets
	private String lastKnownDate;

	public CachedUsMonthlyData() {
		// TODO Auto-generated constructor stub
	}

	@PostConstruct
	public void init() {
		usStateDataCacheOne = usCachedMonthlyDataService.getUsDataConfirmed("state");
		usCountyDataCacheOne = usCachedMonthlyDataService.getUsDataConfirmed("county");

		usStateDeathsDataCacheOne = usCachedMonthlyDataService.getUsDataDeaths("state");
		usCountyDeathsDataCacheOne = usCachedMonthlyDataService.getUsDataDeaths("county");

		this.setLastDateOfDataSets();
		this.setEmptyDataSet();
		cachedGenericMonthlyData.setLastKnownDate(lastKnownDate);
		cachedGenericMonthlyData.setEmptyDataSet(emptyDataSet);
		cacheOne = true;
		cacheTwo = false;
	}

	@Override
	public void updateCache() {
		if (!cacheOne) {
			usStateDataCacheOne = usCachedMonthlyDataService.getUsDataConfirmed("state");
			usCountyDataCacheOne = usCachedMonthlyDataService.getUsDataConfirmed("county");

			usStateDeathsDataCacheOne = usCachedMonthlyDataService.getUsDataDeaths("state");
			usCountyDeathsDataCacheOne = usCachedMonthlyDataService.getUsDataDeaths("county");

			this.setLastDateOfDataSets();
			this.setEmptyDataSet();
			cachedGenericMonthlyData.setLastKnownDate(lastKnownDate);
			cachedGenericMonthlyData.setEmptyDataSet(emptyDataSet);
			cacheOne = true;
			cacheTwo = false;
		} else {
			usStateDataCacheTwo = usCachedMonthlyDataService.getUsDataConfirmed("state");
			usCountyDataCacheTwo = usCachedMonthlyDataService.getUsDataConfirmed("county");

			usStateDeathsDataCacheTwo = usCachedMonthlyDataService.getUsDataDeaths("state");
			usCountyDeathsDataCacheTwo = usCachedMonthlyDataService.getUsDataDeaths("county");

			this.setLastDateOfDataSets();
			this.setEmptyDataSet();
			cachedGenericMonthlyData.setLastKnownDate(lastKnownDate);
			cachedGenericMonthlyData.setEmptyDataSet(emptyDataSet);
			cacheOne = false;
			cacheTwo = true;
		}
	}

	public LinkedHashMap<String, LinkedHashMap<String, Integer>> getUsStateData() {
		if (cacheOne) {
			return usStateDataCacheOne;
		} else {
			return usStateDataCacheTwo;
		}
	}

	public void setUsStateData(LinkedHashMap<String, LinkedHashMap<String, Integer>> usStateData) {
		this.usStateDataCacheOne = usStateData;
	}

	public void setUsStateDataCacheTwo(LinkedHashMap<String, LinkedHashMap<String, Integer>> usStateData) {
		this.usStateDataCacheTwo = usStateData;
	}

	public LinkedHashMap<String, LinkedHashMap<String, Integer>> getUsCountyData() {
		if (cacheOne) {
			return usCountyDataCacheOne;
		} else {
			return usCountyDataCacheTwo;
		}
	}

	public void setUsCountyDataCacheOne(LinkedHashMap<String, LinkedHashMap<String, Integer>> usCountyData) {
		this.usCountyDataCacheOne = usCountyData;
	}

	public void setUsCountyDataCacheTwo(LinkedHashMap<String, LinkedHashMap<String, Integer>> usCountyData) {
		this.usCountyDataCacheTwo = usCountyData;
	}

	public LinkedHashMap<String, LinkedHashMap<String, Integer>> getUsStateDeathsData() {
		if (cacheOne) {
			return usStateDeathsDataCacheOne;
		} else {
			return usStateDeathsDataCacheTwo;
		}
	}

	public void setUsStateDeathsDataCacheOne(LinkedHashMap<String, LinkedHashMap<String, Integer>> usStateDeathsData) {
		this.usStateDeathsDataCacheOne = usStateDeathsData;
	}

	public void setUsStateDeathsDataCacheTwo(LinkedHashMap<String, LinkedHashMap<String, Integer>> usStateDeathsData) {
		this.usStateDeathsDataCacheTwo = usStateDeathsData;
	}

	public LinkedHashMap<String, LinkedHashMap<String, Integer>> getUsCountyDeathsData() {
		if (cacheOne) {
			return usCountyDeathsDataCacheOne;
		} else {
			return usCountyDeathsDataCacheTwo;
		}
	}

	public void setUsCountyDeathsDataCacheOne(
			LinkedHashMap<String, LinkedHashMap<String, Integer>> usCountyDeathsData) {
		this.usCountyDeathsDataCacheOne = usCountyDeathsData;
	}

	public void setUsCountyDeathsDataCacheTwo(
			LinkedHashMap<String, LinkedHashMap<String, Integer>> usCountyDeathsData) {
		this.usCountyDeathsDataCacheTwo = usCountyDeathsData;
	}

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
	public LinkedHashMap<String, Integer> getConfirmedCountyDataByCountyId(String id) {
		if (cacheOne) {
			return this.usCountyDataCacheOne.get(id);
		} else {
			return this.usCountyDataCacheTwo.get(id);
		}
	}

	@Override
	public LinkedHashMap<String, Integer> getDeathsCountyDataByCountyId(String id) {
		if (cacheOne) {
			return this.usCountyDeathsDataCacheOne.get(id);
		} else {
			return this.usCountyDeathsDataCacheTwo.get(id);
		}
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
		if (cacheOne) {
			Iterator<Map.Entry<String, LinkedHashMap<String, Integer>>> iterator = this.usStateDataCacheOne.entrySet()
					.iterator();
			while (iterator.hasNext()) {
				Entry<String, LinkedHashMap<String, Integer>> entry = iterator.next();
				if (entry.getValue().size() > 0) {
					this.lastKnownDate = usCachedMonthlyDataService.getLastDateOfDataSets(entry.getValue());
					break;
				}
			}
		} else {
			Iterator<Map.Entry<String, LinkedHashMap<String, Integer>>> iterator = this.usStateDataCacheTwo.entrySet()
					.iterator();
			while (iterator.hasNext()) {
				Entry<String, LinkedHashMap<String, Integer>> entry = iterator.next();
				if (entry.getValue().size() > 0) {
					this.lastKnownDate = usCachedMonthlyDataService.getLastDateOfDataSets(entry.getValue());
					break;
				}
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
