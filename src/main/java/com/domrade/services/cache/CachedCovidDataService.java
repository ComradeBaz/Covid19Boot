package com.domrade.services.cache;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.domrade.interfaces.cache.CachedLocationsLocal;
import com.domrade.interfaces.cache.ICachedCovidData;
import com.domrade.interfaces.local.CovidDataLocal;
import com.domrade.interfaces.local.GlobalLocationLocal;
import com.domrade.interfaces.local.UsLocationsLocal;

@Service
public class CachedCovidDataService implements ICachedCovidData {

	@Autowired
	private CovidDataLocal covidDataService;

	@Autowired
	private CachedLocationsLocal cachedLocations;

	@Autowired
	private UsLocationsLocal usLocationsService;

	@Autowired
	private GlobalLocationLocal globalLocationService;

	public CachedCovidDataService() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public LinkedHashMap<String, LinkedHashMap<String, Integer>> getCachedUsStateData(String type) {
		List<String> states = cachedLocations.getUsStates();
		LinkedHashMap<String, LinkedHashMap<String, Integer>> returnMap = new LinkedHashMap<>();
		for (String state : states) {
			ArrayList<Date> dates = covidDataService.getDatesOfDataForState(state, type);
			LinkedHashMap<String, Integer> data = new LinkedHashMap<>();
			for (Date date : dates) {
				int total = covidDataService.getSumForState(state, date, type);
				data.put(convertDateToString(date), total);
			}
			returnMap.put(state, data);
		}
		return returnMap;
	}

	@Override
	public LinkedHashMap<Long, LinkedHashMap<String, Integer>> getCachedUsCountyData(String type) {
		LinkedHashMap<Long, LinkedHashMap<String, Integer>> returnMap = new LinkedHashMap<>();
		List<Long> locationIds = cachedLocations.getUsLocationIds();
		// ArrayList<Date> dates = covidDataService.getDates();
		for (long l : locationIds) {
			ArrayList<Date> dates = covidDataService.getDatesOfDataForLocationByType(l, type);
			LinkedHashMap<String, Integer> data = new LinkedHashMap<>();
			for (Date d : dates) {
				System.out.println("Id: " + l + " Date: " + d + " Type: " + type);
				int dailyData = covidDataService.getDataByIdDateType(l, d, type);
				data.put(convertDateToString(d), dailyData);
			}
			// String county = usLocationsService.getCountyNameByLocationId(l);
			returnMap.put(l, data);
		}
		return returnMap;
	}

	@Override
	public LinkedHashMap<String, LinkedHashMap<String, Integer>> getGlobalData(String type) {
		LinkedHashMap<String, LinkedHashMap<String, Integer>> returnMap = new LinkedHashMap<>();
		List<Long> globalLocationIds = cachedLocations.getGlobalLocationIds();
		// ArrayList<Date> dates = covidDataService.getDates();
		for (long l : globalLocationIds) {
			ArrayList<Date> dates = covidDataService.getDatesOfDataForLocationByType(l, type);
			System.out.println("Location: " + l);
			LinkedHashMap<String, Integer> data = new LinkedHashMap<>();
			for (Date d : dates) {
				int dailyData = covidDataService.getDataByIdDateType(l, d, type);
				System.out.println(l + " " + d + " " + type);
				data.put(convertDateToString(d), dailyData);
			}
			String location = globalLocationService.getLocationNameById(l);
			returnMap.put(location, data);
		}
		return returnMap;
	}

	private String convertDateToString(Date d) {
		SimpleDateFormat sdf = new SimpleDateFormat("MMMdd");
		return sdf.format(d);
	}

}
