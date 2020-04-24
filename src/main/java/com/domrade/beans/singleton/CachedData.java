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
import com.domrade.dao.interfaces.FebruaryDao;
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
	private FebruaryDao februaryDao;

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

	// List of locations
	private List<String> locations;

	// US States
	private List<String> usStates;
	// US States and Counties with IDs
	LinkedHashMap<String, LinkedHashMap<String, String>> statesAndCounties;
	// US States and counties but not Ids
	LinkedHashMap<String, ArrayList<String>> statesAndCountiesNoId;
	// Common Data
	private List<String> allCountries;

	public CachedData() {
		// no arg constructor
	}

	@PostConstruct
	public void init() {
		// setAllCountries(februaryDao.getAllFebruaryCountries());
		setLocations(februaryService.getAllFebruaryCountryRegionProvinceState());
		allFileNames = dataFileSourceDao.findAllFileNames();
		setFileLocation(fileDirectory);
		usStates = usJanuaryService.getAllStates();
		statesAndCounties = cachedUsMonthlyDataService.getStatesAndCounties();
		statesAndCountiesNoId = cachedUsMonthlyDataService.getCountiesByState(statesAndCounties);
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
		System.out.println(
				"******************************************** January ********************************************");
		for (String s : january) {
			System.out.println(s);
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
		System.out.println(
				"******************************************** February ********************************************");
		for (String s : february) {
			System.out.println(s);
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
		System.out.println(
				"******************************************** March ********************************************");
		for (String s : march) {
			System.out.println(s);
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
		System.out.println(
				"******************************************** April ********************************************");
		for (String s : april) {
			System.out.println(s);
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
		return allCountries;
	}

	public void setAllCountries(List<String> allCountries) {
		this.allCountries = allCountries;
	}

	@Override
	public List<String> getLocations() {
		return locations;
	}

	public void setLocations(List<String> locations) {
		this.locations = locations;
	}

	@Override
	public List<String> getUsStates() {
		return usStates;
	}

	public void setUsStates(List<String> usStates) {
		this.usStates = usStates;
	}

	public LinkedHashMap<String, LinkedHashMap<String, String>> getStatesAndCounties() {
		return statesAndCounties;
	}

	public void setStatesAndCounties(LinkedHashMap<String, LinkedHashMap<String, String>> statesAndCounties) {
		this.statesAndCounties = statesAndCounties;
	}

	@Override
	public String getCountyIdByStateAndCounty(String state, String county) {
		Map<String, String> statesAndCounties = this.statesAndCounties.get(state);
		String id = statesAndCounties.get(county);

		return id;
	}

	// Returns a list of counties for the given state
	@Override
	public ArrayList<String> getCountiesByState(String state) {
		return this.statesAndCountiesNoId.get(state);
	}

}
