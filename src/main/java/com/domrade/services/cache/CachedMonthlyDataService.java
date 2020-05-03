/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.domrade.services.cache;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.domrade.entity.implementation.April;
import com.domrade.entity.implementation.AprilDeaths;
import com.domrade.entity.implementation.February;
import com.domrade.entity.implementation.FebruaryDeaths;
import com.domrade.entity.implementation.January;
import com.domrade.entity.implementation.JanuaryDeaths;
import com.domrade.entity.implementation.March;
import com.domrade.entity.implementation.MarchDeaths;
import com.domrade.entity.implementation.May;
import com.domrade.entity.implementation.MayDeaths;
import com.domrade.interfaces.cache.CachedMonthlyDataServiceLocal;
import com.domrade.interfaces.local.CachedMonthlyDataLocal;

/**
 *
 * @author David
 */
@Service
public class CachedMonthlyDataService implements CachedMonthlyDataServiceLocal {

	@Autowired
	private CachedMonthlyDataLocal cachedMonthlyData;

	public CachedMonthlyDataService() {
		// no arg constructor
	}

	@Override
	public Map<String, Long> getJanuaryConfirmedLocationsAndIds(List<January> januaryConfirmed) {

		Map<String, Long> januaryLocationsAndIds = new LinkedHashMap<>();
		String location;
		long id;

		for (January j : januaryConfirmed) {
			id = j.getId();
			location = j.getCountryRegion() + " - " + j.getProvenceState();
			januaryLocationsAndIds.put(getLocationString(location), id);
		}
		return januaryLocationsAndIds;
	}

	@Override
	public Map<String, Long> getJanuaryDeathsLocationsAndIds(List<JanuaryDeaths> januaryDeaths) {

		Map<String, Long> januaryLocationsAndIds = new LinkedHashMap<>();
		String location;
		long id;

		for (JanuaryDeaths j : januaryDeaths) {
			id = j.getId();
			location = j.getCountryRegion() + " - " + j.getProvenceState();
			januaryLocationsAndIds.put(getLocationString(location), id);
		}
		return januaryLocationsAndIds;
	}

	@Override
	public Map<String, Long> getFebruaryConfirmedLocationsAndIds(List<January> februaryConfirmed) {

		Map<String, Long> februaryLocationsAndIds = new LinkedHashMap<>();
		String location;
		long id;

		for (January j : februaryConfirmed) {
			id = j.getId();
			location = j.getCountryRegion() + " - " + j.getProvenceState();
			februaryLocationsAndIds.put(getLocationString(location), id);
		}
		return februaryLocationsAndIds;
	}

	@Override
	public Map<String, Long> getMarchConfirmedLocationsAndIds(List<January> marchConfirmed) {

		Map<String, Long> marchLocationsAndIds = new LinkedHashMap<>();
		String location;
		long id;

		for (January j : marchConfirmed) {
			id = j.getId();
			location = j.getCountryRegion() + " - " + j.getProvenceState();
			marchLocationsAndIds.put(getLocationString(location), id);
		}
		return marchLocationsAndIds;
	}

	@Override
	public Map<String, Long> getAprilConfirmedLocationsAndIds(List<January> aprilConfirmed) {

		Map<String, Long> aprilLocationsAndIds = new LinkedHashMap<>();
		String location;
		long id;

		for (January j : aprilConfirmed) {
			id = j.getId();
			location = j.getCountryRegion() + " - " + j.getProvenceState();
			aprilLocationsAndIds.put(getLocationString(location), id);
		}
		return aprilLocationsAndIds;
	}

	private String getLocationString(String unformattedLocation) {
		String formattedLocation;
		String trimmedUnformattedLocation = unformattedLocation.trim();
		int stringSize = trimmedUnformattedLocation.length();
		if (Character.valueOf(trimmedUnformattedLocation.charAt(stringSize - 1)).compareTo('-') == 0) {
			formattedLocation = trimmedUnformattedLocation.substring(0, stringSize - 2);
			return formattedLocation;
		} else {
			return trimmedUnformattedLocation;
		}
	}

	@Override
	public January getJanuaryEntityByLocation(String location) {
		return cachedMonthlyData.getJanuaryEntityByLocation(location);
	}

	@Override
	public February getFebruaryEntityByLocation(String location) {
		return cachedMonthlyData.getFebruaryEntityByLocation(location);
	}

	@Override
	public March gettMarchEntityByLocation(String location) {
		return cachedMonthlyData.getMarchEntityByLocation(location);
	}

	@Override
	public April getAprilEntityByLocation(String location) {
		return cachedMonthlyData.getAprilEntityByLocation(location);
	}

	@Override
	public May getMayEntityByLocation(String location) {
		return cachedMonthlyData.getMayEntityByLocation(location);
	}

	@Override
	public JanuaryDeaths getJanuaryDeathsByLocation(String location) {
		return cachedMonthlyData.getJanuaryDeathByLocation(location);
	}

	@Override
	public FebruaryDeaths getFebruaryDeathsByLocation(String location) {
		return cachedMonthlyData.getFebruaryDeathsByLocation(location);
	}

	@Override
	public MarchDeaths getMarchDeathsByLocation(String location) {
		return cachedMonthlyData.getMarchDeathsByLocation(location);
	}

	@Override
	public AprilDeaths getAprilDeathsByLocation(String location) {
		return cachedMonthlyData.getAprilDeathsByLocation(location);
	}

	@Override
	public MayDeaths getMayDeathsByLocation(String location) {
		return cachedMonthlyData.getMayDeathsByLocation(location);
	}

}
