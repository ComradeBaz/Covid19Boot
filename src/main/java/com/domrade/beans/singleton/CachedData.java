/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.domrade.beans.singleton;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.domrade.dao.interfaces.DataFileSourceDao;
import com.domrade.interfaces.cache.CachedUsMonthlyDataServiceLocal;
import com.domrade.interfaces.local.CachedDataLocal;
import com.domrade.interfaces.months.confirmed.FebruaryServiceLocal;
import com.domrade.interfaces.months.confirmed.USJanuaryServiceLocal;

/**
 *
 * @author David
 * 
 *         Location data not specific to a time period Countries with
 *         provenceState and US states and counties
 */
@Component
@Scope("application")
public class CachedData implements CachedDataLocal {

	@Autowired
	private DataFileSourceDao dataFileSourceDao;

	@Autowired
	FebruaryServiceLocal februaryService;

	@Autowired
	private USJanuaryServiceLocal usJanuaryService;

	@Autowired
	private CachedUsMonthlyDataServiceLocal cachedUsMonthlyDataService;

	// CSV File
	private List<String> allFileNames;
	private String fileLocation;
	String fileDirectory = "c:\\files\\";

	// Monthly Data
	private List<String> january;
	private boolean januaryData;
	private List<String> february;
	private boolean februaryData;
	private List<String> march;
	private boolean marchData;
	private List<String> april;
	private boolean aprilData;
	private List<String> may;
	private boolean mayData;

	// Caching
	private boolean cacheOne;
	private boolean cacheTwo;

	// List of locations
	private List<String> locationsCacheOne;
	private List<String> locationsCacheTwo;

	// US States
	private List<String> usStatesCacheOne;
	private List<String> usStatesCacheTwo;
	// US States and Counties with IDs
	LinkedHashMap<String, LinkedHashMap<String, String>> statesAndCountiesCacheOne;
	LinkedHashMap<String, LinkedHashMap<String, String>> statesAndCountiesCacheTwo;
	// US States and counties but not Ids
	LinkedHashMap<String, ArrayList<String>> statesAndCountiesNoIdCacheOne;
	LinkedHashMap<String, ArrayList<String>> statesAndCountiesNoIdCacheTwo;
	// Common Data
	private List<String> allCountriesCacheOne;
	private List<String> allCountriesCacheTwo;

	public CachedData() {
		// no arg constructor
	}

	@PostConstruct
	public void init() {
		// setAllCountries(februaryDao.getAllFebruaryCountries());
		setLocationsCacheOne(februaryService.getAllFebruaryCountryRegionProvinceState());
		allFileNames = dataFileSourceDao.findAllFileNames();
		setFileLocation(fileDirectory);
		usStatesCacheOne = usJanuaryService.getAllStates();
		statesAndCountiesCacheOne = cachedUsMonthlyDataService.getStatesAndCounties();
		statesAndCountiesNoIdCacheOne = cachedUsMonthlyDataService.getCountiesByState(statesAndCountiesCacheOne);
		cacheOne = true;
		cacheTwo = false;
	}

	@Override
	public void updateCache() {
		if (!cacheOne) {
			System.out.println("Setting cacheOne");
			setLocationsCacheOne(februaryService.getAllFebruaryCountryRegionProvinceState());
			usStatesCacheOne = usJanuaryService.getAllStates();
			statesAndCountiesCacheOne = cachedUsMonthlyDataService.getStatesAndCounties();
			statesAndCountiesNoIdCacheOne = cachedUsMonthlyDataService.getCountiesByState(statesAndCountiesCacheOne);
			cacheOne = true;
			cacheTwo = false;
		} else {
			System.out.println("Setting cacheTwo");
			setLocationsCacheTwo(februaryService.getAllFebruaryCountryRegionProvinceState());
			usStatesCacheTwo = usJanuaryService.getAllStates();
			statesAndCountiesCacheTwo = cachedUsMonthlyDataService.getStatesAndCounties();
			statesAndCountiesNoIdCacheTwo = cachedUsMonthlyDataService.getCountiesByState(statesAndCountiesCacheOne);
			cacheOne = false;
			cacheTwo = true;
		}
	}

	@Override
	public List<String> getJanuary() {
		return january;
	}

	@Override
	public void setJanuary(List<String> january) {
		this.january = january;
		if (january.size() > 0) {
			setJanuaryData(true);
		} else {
			setJanuaryData(false);
		}
	}

	@Override
	public boolean isJanuaryData() {
		return januaryData;
	}

	public void setJanuaryData(boolean januaryData) {
		this.januaryData = januaryData;
	}

	@Override
	public List<String> getFebruary() {
		return february;
	}

	@Override
	public void setFebruary(List<String> february) {
		this.february = february;
		if (february.size() > 0) {
			setFebruaryData(true);
		} else {
			setFebruaryData(false);
		}
	}

	@Override
	public List<String> getMarch() {
		return march;
	}

	@Override
	public void setMarch(List<String> march) {
		this.march = march;
		if (march.size() > 0) {
			setMarchData(true);
		} else {
			setMarchData(false);
		}
	}

	@Override
	public List<String> getApril() {
		return april;
	}

	@Override
	public void setApril(List<String> april) {
		this.april = april;
		if (april.size() > 0) {
			setAprilData(true);
		} else {
			setAprilData(false);
		}
	}

	@Override
	public List<String> getMay() {
		return may;
	}

	@Override
	public void setMay(List<String> may) {
		this.may = may;
		if (may.size() > 0) {
			setMayData(true);
		} else {
			setMayData(false);
		}
	}

	public List<String> getAllFileNames() {
		return allFileNames;
	}

	@Override
	public void setAllFileNames(List<String> allFileNames) {
		this.allFileNames = allFileNames;
	}

	@Override
	public List<String> getFileNames() {
		return allFileNames;
	}

	@Override
	public String getFileLocation() {
		return fileLocation;
	}

	@Override
	public void setFileLocation(String fileLocation) {
		this.fileLocation = fileDirectory;
	}

	@Override
	public boolean isFebruaryData() {
		return februaryData;
	}

	public void setFebruaryData(boolean februaryData) {
		this.februaryData = februaryData;
	}

	@Override
	public boolean isMarchData() {
		return marchData;
	}

	public void setMarchData(boolean marchData) {
		this.marchData = marchData;
	}

	@Override
	public boolean isAprilData() {
		return aprilData;
	}

	public void setAprilData(boolean aprilData) {
		this.aprilData = aprilData;
	}

	@Override
	public boolean isMayData() {
		return mayData;
	}

	public void setMayData(boolean mayData) {
		this.mayData = mayData;
	}

	@Override
	public List<String> getAllCountries() {
		if (cacheOne) {
			return allCountriesCacheOne;
		} else {
			return allCountriesCacheTwo;
		}
	}

	public void setAllCountriesCacheOne(List<String> allCountries) {
		this.allCountriesCacheOne = allCountries;
	}

	public void setAllCountriesCacheTwo(List<String> allCountries) {
		this.allCountriesCacheTwo = allCountries;
	}

	@Override
	public List<String> getLocations() {
		if (cacheOne) {
			return locationsCacheOne;
		} else {
			return locationsCacheTwo;
		}
	}

	public void setLocationsCacheOne(List<String> locations) {
		this.locationsCacheOne = locations;
	}

	public void setLocationsCacheTwo(List<String> locations) {
		this.locationsCacheTwo = locations;
	}

	@Override
	public List<String> getUsStates() {
		if (cacheOne) {
			return usStatesCacheOne;
		} else {
			return usStatesCacheTwo;
		}
	}

	public void setUsStatesCacheOne(List<String> usStates) {
		this.usStatesCacheOne = usStates;
	}

	public void setUsStatesCacheTwo(List<String> usStates) {
		this.usStatesCacheTwo = usStates;
	}

	public LinkedHashMap<String, LinkedHashMap<String, String>> getStatesAndCountiesCacheOne() {
		return statesAndCountiesCacheOne;
	}

	public LinkedHashMap<String, LinkedHashMap<String, String>> getStatesAndCountiesCacheTwo() {
		return statesAndCountiesCacheTwo;
	}

	public void setStatesAndCountiesCacheOne(LinkedHashMap<String, LinkedHashMap<String, String>> statesAndCounties) {
		this.statesAndCountiesCacheOne = statesAndCounties;
	}

	public void setStatesAndCountiesCacheTwo(LinkedHashMap<String, LinkedHashMap<String, String>> statesAndCounties) {
		this.statesAndCountiesCacheTwo = statesAndCounties;
	}

	@Override
	public String getCountyIdByStateAndCounty(String state, String county) {
		if (cacheOne) {
			Map<String, String> statesAndCounties = this.statesAndCountiesCacheOne.get(state);
			String id = statesAndCounties.get(county);

			return id;
		} else {
			Map<String, String> statesAndCounties = this.statesAndCountiesCacheTwo.get(state);
			String id = statesAndCounties.get(county);

			return id;
		}
	}

	// Returns a list of counties for the given state
	@Override
	public ArrayList<String> getCountiesByState(String state) {
		if (cacheOne) {
			return this.statesAndCountiesNoIdCacheOne.get(state);
		} else {
			return this.statesAndCountiesNoIdCacheTwo.get(state);
		}
	}

}
