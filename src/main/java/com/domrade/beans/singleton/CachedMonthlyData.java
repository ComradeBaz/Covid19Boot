/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.domrade.beans.singleton;

import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

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
import com.domrade.interfaces.months.confirmed.AprilServiceLocal;
import com.domrade.interfaces.months.confirmed.FebruaryServiceLocal;
import com.domrade.interfaces.months.confirmed.JanuaryServiceLocal;
import com.domrade.interfaces.months.confirmed.MarchServiceLocal;
import com.domrade.interfaces.months.confirmed.MayServiceLocal;
import com.domrade.interfaces.months.deaths.AprilDeathsServiceLocal;
import com.domrade.interfaces.months.deaths.FebruaryDeathsServiceLocal;
import com.domrade.interfaces.months.deaths.JanuaryDeathsServiceLocal;
import com.domrade.interfaces.months.deaths.MarchDeathsServiceLocal;
import com.domrade.interfaces.months.deaths.MayDeathsServiceLocal;

/**
 *
 * @author David
 */
@Component
@Scope("application")
public class CachedMonthlyData implements CachedMonthlyDataLocal {

	@Autowired
	private JanuaryServiceLocal januaryService;

	@Autowired
	private FebruaryServiceLocal februaryService;

	@Autowired
	private MarchServiceLocal marchService;

	@Autowired
	private AprilServiceLocal aprilService;

	@Autowired
	private MayServiceLocal mayService;

	@Autowired
	private CachedMonthlyDataServiceLocal cachedMonthlyDataService;

	@Autowired
	private JanuaryDeathsServiceLocal januaryDeathsService;

	@Autowired
	private FebruaryDeathsServiceLocal februaryDeathsService;

	@Autowired
	private MarchDeathsServiceLocal marchDeathsService;

	@Autowired
	private AprilDeathsServiceLocal aprilDeathsService;

	@Autowired
	private MayDeathsServiceLocal mayDeathsService;

	private List<January> januaryConfirmed;
	private List<February> februaryConfirmed;
	private List<March> marchConfirmed;
	private List<April> aprilConfirmed;
	private List<May> mayConfirmed;

	private List<JanuaryDeaths> januaryDeaths;
	private List<FebruaryDeaths> februaryDeaths;
	private List<MarchDeaths> marchDeaths;
	private List<AprilDeaths> aprilDeaths;
	private List<MayDeaths> mayDeaths;

	// Map with location and id
	// service will get an id based on location from this map
	// then get the entity from the List<Month> using the id
	// The same ids are used in all months
	private Map<String, Long> locationsAndIds;
	// Deaths
	private Map<String, Long> deathLocationsAndIds;

	public CachedMonthlyData() {
		// no arg constructor
	}

	@PostConstruct
	public void init() {
		// Confirmed
		januaryConfirmed = januaryService.getAllJanuaryEntries();
		februaryConfirmed = februaryService.getAllFebruaryEntries();
		marchConfirmed = marchService.getAllMarchEntries();
		aprilConfirmed = aprilService.getAllAprilEntries();
		mayConfirmed = mayService.getAllMayEntries();

		// Deaths
		januaryDeaths = januaryDeathsService.getAllJanuaryDeathsEntries();
		februaryDeaths = februaryDeathsService.getAllFebruaryDeathsEntries();
		marchDeaths = marchDeathsService.getAllMarchDeathsEntries();
		aprilDeaths = aprilDeathsService.getAllAprilDeathsEntries();
		mayDeaths = mayDeathsService.getAllMayDeathsEntries();

		// Maps to entities
		locationsAndIds = cachedMonthlyDataService.getJanuaryConfirmedLocationsAndIds(januaryConfirmed);
		deathLocationsAndIds = cachedMonthlyDataService.getJanuaryDeathsLocationsAndIds(januaryDeaths);
	}

	public List<January> getJanuaryConfirmed() {
		return januaryConfirmed;
	}

	public void setJanuaryConfirmed(List<January> januaryConfirmed) {
		this.januaryConfirmed = januaryConfirmed;
	}

	public List<February> getFebruaryConfirmed() {
		return februaryConfirmed;
	}

	public void setFebruaryConfirmed(List<February> februaryConfirmed) {
		this.februaryConfirmed = februaryConfirmed;
	}

	public List<March> getMarchConfirmed() {
		return marchConfirmed;
	}

	public void setMarchConfirmed(List<March> marchConfirmed) {
		this.marchConfirmed = marchConfirmed;
	}

	public List<April> getAprilConfirmed() {
		return aprilConfirmed;
	}

	public void setAprilConfirmed(List<April> aprilConfirmed) {
		this.aprilConfirmed = aprilConfirmed;
	}

	public Map<String, Long> getLocationsAndIds() {
		return locationsAndIds;
	}

	public void setLocationsAndIds(Map<String, Long> locationsAndIds) {
		this.locationsAndIds = locationsAndIds;
	}

	public List<JanuaryDeaths> getJanuaryDeaths() {
		return januaryDeaths;
	}

	public void setJanuaryDeaths(List<JanuaryDeaths> januaryDeaths) {
		this.januaryDeaths = januaryDeaths;
	}

	public List<FebruaryDeaths> getFebruaryDeaths() {
		return februaryDeaths;
	}

	public void setFebruaryDeaths(List<FebruaryDeaths> februaryDeaths) {
		this.februaryDeaths = februaryDeaths;
	}

	public List<MarchDeaths> getMarchDeaths() {
		return marchDeaths;
	}

	public void setMarchDeaths(List<MarchDeaths> marchDeaths) {
		this.marchDeaths = marchDeaths;
	}

	public List<AprilDeaths> getAprilDeaths() {
		return aprilDeaths;
	}

	public void setAprilDeaths(List<AprilDeaths> aprilDeaths) {
		this.aprilDeaths = aprilDeaths;
	}

	public List<May> getMayConfirmed() {
		return mayConfirmed;
	}

	public void setMayConfirmed(List<May> mayConfirmed) {
		this.mayConfirmed = mayConfirmed;
	}

	public List<MayDeaths> getMayDeaths() {
		return mayDeaths;
	}

	public void setMayDeaths(List<MayDeaths> mayDeaths) {
		this.mayDeaths = mayDeaths;
	}

	public Map<String, Long> getDeathLocationsAndIds() {
		return deathLocationsAndIds;
	}

	public void setDeathLocationsAndIds(Map<String, Long> deathLocationsAndIds) {
		this.deathLocationsAndIds = deathLocationsAndIds;
	}

	@Override
	public January getJanuaryEntityByLocation(String location) {
		Long index = locationsAndIds.get(location);
		for (January j : januaryConfirmed) {
			if (index == j.getId()) {
				return j;
			}
		}
		// Return the first entry
		return januaryConfirmed.get(0);
	}

	@Override
	public February getFebruaryEntityByLocation(String location) {
		Long index = locationsAndIds.get(location);
		for (February f : februaryConfirmed) {
			if (index == f.getId()) {
				return f;
			}
		}
		// Return the first entry
		return februaryConfirmed.get(0);
	}

	@Override
	public March getMarchEntityByLocation(String location) {
		Long index = locationsAndIds.get(location);
		for (March m : marchConfirmed) {
			if (index == m.getId()) {
				return m;
			}
		}
		// Return the first entry
		return marchConfirmed.get(0);
	}

	@Override
	public April getAprilEntityByLocation(String location) {
		Long index = locationsAndIds.get(location);
		for (April a : aprilConfirmed) {
			if (index == a.getId()) {
				return a;
			}
		}
		// Return the first entry
		return aprilConfirmed.get(0);
	}

	@Override
	public May getMayEntityByLocation(String location) {
		Long index = locationsAndIds.get(location);
		for (May m : mayConfirmed) {
			if (index == m.getId()) {
				return m;
			}
		}
		// Return the first entry
		return mayConfirmed.get(0);
	}

	@Override
	public JanuaryDeaths getJanuaryDeathByLocation(String location) {
		Long index = deathLocationsAndIds.get(location);
		for (JanuaryDeaths j : januaryDeaths) {
			if (index == j.getId()) {
				return j;
			}
		}
		// Return the first entry
		return januaryDeaths.get(0);
	}

	@Override
	public FebruaryDeaths getFebruaryDeathsByLocation(String location) {
		Long index = deathLocationsAndIds.get(location);
		for (FebruaryDeaths f : februaryDeaths) {
			if (index == f.getId()) {
				return f;
			}
		}
		// Return the first entry
		return februaryDeaths.get(0);
	}

	@Override
	public MarchDeaths getMarchDeathsByLocation(String location) {
		Long index = deathLocationsAndIds.get(location);
		for (MarchDeaths m : marchDeaths) {
			if (index == m.getId()) {
				return m;
			}
		}
		// Return the first entry
		return marchDeaths.get(0);
	}

	@Override
	public AprilDeaths getAprilDeathsByLocation(String location) {
		Long index = deathLocationsAndIds.get(location);
		for (AprilDeaths a : aprilDeaths) {
			if (index == a.getId()) {
				return a;
			}
		}
		// Return the first entry
		return aprilDeaths.get(0);
	}

	@Override
	public MayDeaths getMayDeathsByLocation(String location) {
		Long index = deathLocationsAndIds.get(location);
		for (MayDeaths m : mayDeaths) {
			if (index == m.getId()) {
				return m;
			}
		}
		// Return the first entry
		return mayDeaths.get(0);
	}
}
