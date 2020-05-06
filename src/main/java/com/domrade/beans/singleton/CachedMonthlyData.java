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

	private boolean cacheOne;
	private boolean cacheTwo;

	// cacheOne
	private List<January> januaryConfirmedCacheOne;
	private List<February> februaryConfirmedCacheOne;
	private List<March> marchConfirmedCacheOne;
	private List<April> aprilConfirmedCacheOne;
	private List<May> mayConfirmedCacheOne;

	private List<JanuaryDeaths> januaryDeathsCacheOne;
	private List<FebruaryDeaths> februaryDeathsCacheOne;
	private List<MarchDeaths> marchDeathsCacheOne;
	private List<AprilDeaths> aprilDeathsCacheOne;
	private List<MayDeaths> mayDeathsCacheOne;

	// cacheTwo
	private List<January> januaryConfirmedCacheTwo;
	private List<February> februaryConfirmedCacheTwo;
	private List<March> marchConfirmedCacheTwo;
	private List<April> aprilConfirmedCacheTwo;
	private List<May> mayConfirmedCacheTwo;

	private List<JanuaryDeaths> januaryDeathsCacheTwo;
	private List<FebruaryDeaths> februaryDeathsCacheTwo;
	private List<MarchDeaths> marchDeathsCacheTwo;
	private List<AprilDeaths> aprilDeathsCacheTwo;
	private List<MayDeaths> mayDeathsCacheTwo;

	// Map with location and id
	// service will get an id based on location from this map
	// then get the entity from the List<Month> using the id
	// The same ids are used in all months
	private Map<String, Long> locationsAndIdsCacheOne;
	private Map<String, Long> locationsAndIdsCacheTwo;
	// Deaths
	private Map<String, Long> deathLocationsAndIdsCacheOne;
	private Map<String, Long> deathLocationsAndIdsCacheTwo;

	public CachedMonthlyData() {
		// no arg constructor
	}

	@PostConstruct
	public void init() {
		// Confirmed
		januaryConfirmedCacheOne = januaryService.getAllJanuaryEntries();
		februaryConfirmedCacheOne = februaryService.getAllFebruaryEntries();
		marchConfirmedCacheOne = marchService.getAllMarchEntries();
		aprilConfirmedCacheOne = aprilService.getAllAprilEntries();
		mayConfirmedCacheOne = mayService.getAllMayEntries();

		// Deaths
		januaryDeathsCacheOne = januaryDeathsService.getAllJanuaryDeathsEntries();
		februaryDeathsCacheOne = februaryDeathsService.getAllFebruaryDeathsEntries();
		marchDeathsCacheOne = marchDeathsService.getAllMarchDeathsEntries();
		aprilDeathsCacheOne = aprilDeathsService.getAllAprilDeathsEntries();
		mayDeathsCacheOne = mayDeathsService.getAllMayDeathsEntries();

		// Maps to entities
		locationsAndIdsCacheOne = cachedMonthlyDataService.getJanuaryConfirmedLocationsAndIds(januaryConfirmedCacheOne);
		deathLocationsAndIdsCacheOne = cachedMonthlyDataService.getJanuaryDeathsLocationsAndIds(januaryDeathsCacheOne);
		cacheOne = true;
		cacheTwo = false;
	}

	@Override
	public void updateCache() {
		if (!cacheOne) {
			januaryConfirmedCacheOne = januaryService.getAllJanuaryEntries();
			februaryConfirmedCacheOne = februaryService.getAllFebruaryEntries();
			marchConfirmedCacheOne = marchService.getAllMarchEntries();
			aprilConfirmedCacheOne = aprilService.getAllAprilEntries();
			mayConfirmedCacheOne = mayService.getAllMayEntries();

			// Deaths
			januaryDeathsCacheOne = januaryDeathsService.getAllJanuaryDeathsEntries();
			februaryDeathsCacheOne = februaryDeathsService.getAllFebruaryDeathsEntries();
			marchDeathsCacheOne = marchDeathsService.getAllMarchDeathsEntries();
			aprilDeathsCacheOne = aprilDeathsService.getAllAprilDeathsEntries();
			mayDeathsCacheOne = mayDeathsService.getAllMayDeathsEntries();

			// Maps to entities
			locationsAndIdsCacheOne = cachedMonthlyDataService
					.getJanuaryConfirmedLocationsAndIds(januaryConfirmedCacheOne);
			deathLocationsAndIdsCacheOne = cachedMonthlyDataService
					.getJanuaryDeathsLocationsAndIds(januaryDeathsCacheOne);
			cacheOne = true;
			cacheTwo = false;
		} else {
			januaryConfirmedCacheTwo = januaryService.getAllJanuaryEntries();
			februaryConfirmedCacheTwo = februaryService.getAllFebruaryEntries();
			marchConfirmedCacheTwo = marchService.getAllMarchEntries();
			aprilConfirmedCacheTwo = aprilService.getAllAprilEntries();
			mayConfirmedCacheTwo = mayService.getAllMayEntries();

			// Deaths
			januaryDeathsCacheTwo = januaryDeathsService.getAllJanuaryDeathsEntries();
			februaryDeathsCacheTwo = februaryDeathsService.getAllFebruaryDeathsEntries();
			marchDeathsCacheTwo = marchDeathsService.getAllMarchDeathsEntries();
			aprilDeathsCacheTwo = aprilDeathsService.getAllAprilDeathsEntries();
			mayDeathsCacheTwo = mayDeathsService.getAllMayDeathsEntries();

			// Maps to entities
			locationsAndIdsCacheTwo = cachedMonthlyDataService
					.getJanuaryConfirmedLocationsAndIds(januaryConfirmedCacheOne);
			deathLocationsAndIdsCacheTwo = cachedMonthlyDataService
					.getJanuaryDeathsLocationsAndIds(januaryDeathsCacheOne);
			cacheOne = false;
			cacheTwo = true;
		}
	}

	public List<January> getJanuaryConfirmed() {
		if (cacheOne) {
			return januaryConfirmedCacheOne;
		} else {
			return januaryConfirmedCacheTwo;
		}
	}

	public void setJanuaryConfirmedCacheOne(List<January> januaryConfirmed) {
		this.januaryConfirmedCacheOne = januaryConfirmed;
	}

	public List<February> getFebruaryConfirmed() {
		if (cacheOne) {
			return februaryConfirmedCacheOne;
		} else {
			return februaryConfirmedCacheTwo;
		}
	}

	public void setFebruaryConfirmedCacheOne(List<February> februaryConfirmed) {
		this.februaryConfirmedCacheOne = februaryConfirmed;
	}

	public List<March> getMarchConfirmed() {
		if (cacheOne) {
			return marchConfirmedCacheOne;
		} else {
			return marchConfirmedCacheTwo;
		}
	}

	public void setMarchConfirmedCacheOne(List<March> marchConfirmed) {
		this.marchConfirmedCacheOne = marchConfirmed;
	}

	public List<April> getAprilConfirmed() {
		if (cacheOne) {
			return aprilConfirmedCacheOne;
		} else {
			return aprilConfirmedCacheTwo;
		}
	}

	public void setAprilConfirmedCacheOne(List<April> aprilConfirmed) {
		this.aprilConfirmedCacheOne = aprilConfirmed;
	}

	public Map<String, Long> getLocationsAndIds() {
		if (cacheOne) {
			return locationsAndIdsCacheOne;
		} else {
			return locationsAndIdsCacheTwo;
		}
	}

	public void setLocationsAndIdsCacheOne(Map<String, Long> locationsAndIds) {
		this.locationsAndIdsCacheOne = locationsAndIds;
	}

	public void setLocationsAndIdsCacheTwo(Map<String, Long> locationsAndIds) {
		this.locationsAndIdsCacheTwo = locationsAndIds;
	}

	public List<JanuaryDeaths> getJanuaryDeaths() {
		if (cacheOne) {
			return januaryDeathsCacheOne;
		} else {
			return januaryDeathsCacheTwo;
		}
	}

	public void setJanuaryDeathsCacheOne(List<JanuaryDeaths> januaryDeaths) {
		this.januaryDeathsCacheOne = januaryDeaths;
	}

	public List<FebruaryDeaths> getFebruaryDeaths() {
		if (cacheOne) {
			return februaryDeathsCacheOne;
		} else {
			return februaryDeathsCacheTwo;
		}
	}

	public void setFebruaryDeathsCacheOne(List<FebruaryDeaths> februaryDeaths) {
		this.februaryDeathsCacheOne = februaryDeaths;
	}

	public List<MarchDeaths> getMarchDeaths() {
		if (cacheOne) {
			return marchDeathsCacheOne;
		} else {
			return marchDeathsCacheTwo;
		}
	}

	public void setMarchDeathsCacheOne(List<MarchDeaths> marchDeaths) {
		this.marchDeathsCacheOne = marchDeaths;
	}

	public List<AprilDeaths> getAprilDeaths() {
		if (cacheOne) {
			return aprilDeathsCacheOne;
		} else {
			return aprilDeathsCacheTwo;
		}
	}

	public void setAprilDeathsCacheOne(List<AprilDeaths> aprilDeaths) {
		this.aprilDeathsCacheOne = aprilDeaths;
	}

	public List<May> getMayConfirmed() {
		if (cacheOne) {
			return mayConfirmedCacheOne;
		} else {
			return mayConfirmedCacheTwo;
		}
	}

	public void setMayConfirmedCacheOne(List<May> mayConfirmed) {
		this.mayConfirmedCacheOne = mayConfirmed;
	}

	public List<MayDeaths> getMayDeaths() {
		if (cacheOne) {
			return mayDeathsCacheOne;
		} else {
			return mayDeathsCacheTwo;
		}
	}

	public void setMayDeathsCacheOne(List<MayDeaths> mayDeaths) {
		this.mayDeathsCacheOne = mayDeaths;
	}

	public Map<String, Long> getDeathLocationsAndIds() {
		if (cacheOne) {
			return deathLocationsAndIdsCacheOne;
		} else {
			return deathLocationsAndIdsCacheTwo;
		}
	}

	public void setJanuaryConfirmedCacheTwo(List<January> januaryConfirmedCacheTwo) {
		this.januaryConfirmedCacheTwo = januaryConfirmedCacheTwo;
	}

	public void setFebruaryConfirmedCacheTwo(List<February> februaryConfirmedCacheTwo) {
		this.februaryConfirmedCacheTwo = februaryConfirmedCacheTwo;
	}

	public void setMarchConfirmedCacheTwo(List<March> marchConfirmedCacheTwo) {
		this.marchConfirmedCacheTwo = marchConfirmedCacheTwo;
	}

	public void setAprilConfirmedCacheTwo(List<April> aprilConfirmedCacheTwo) {
		this.aprilConfirmedCacheTwo = aprilConfirmedCacheTwo;
	}

	public void setMayConfirmedCacheTwo(List<May> mayConfirmedCacheTwo) {
		this.mayConfirmedCacheTwo = mayConfirmedCacheTwo;
	}

	public void setJanuaryDeathsCacheTwo(List<JanuaryDeaths> januaryDeathsCacheTwo) {
		this.januaryDeathsCacheTwo = januaryDeathsCacheTwo;
	}

	public void setFebruaryDeathsCacheTwo(List<FebruaryDeaths> februaryDeathsCacheTwo) {
		this.februaryDeathsCacheTwo = februaryDeathsCacheTwo;
	}

	public void setMarchDeathsCacheTwo(List<MarchDeaths> marchDeathsCacheTwo) {
		this.marchDeathsCacheTwo = marchDeathsCacheTwo;
	}

	public void setAprilDeathsCacheTwo(List<AprilDeaths> aprilDeathsCacheTwo) {
		this.aprilDeathsCacheTwo = aprilDeathsCacheTwo;
	}

	public void setMayDeathsCacheTwo(List<MayDeaths> mayDeathsCacheTwo) {
		this.mayDeathsCacheTwo = mayDeathsCacheTwo;
	}

	public void setDeathLocationsAndIdsCacheOne(Map<String, Long> deathLocationsAndIds) {
		this.deathLocationsAndIdsCacheOne = deathLocationsAndIds;
	}

	public void setDeathLocationsAndIdsCacheTwo(Map<String, Long> deathLocationsAndIds) {
		this.deathLocationsAndIdsCacheTwo = deathLocationsAndIds;
	}

	@Override
	public January getJanuaryEntityByLocation(String location) {
		if (cacheOne) {
			Long index = locationsAndIdsCacheOne.get(location);
			for (January j : januaryConfirmedCacheOne) {
				if (index == j.getId()) {
					return j;
				}
			}
			// Return the first entry
			return januaryConfirmedCacheOne.get(0);
		} else {
			Long index = locationsAndIdsCacheTwo.get(location);
			for (January j : januaryConfirmedCacheTwo) {
				if (index == j.getId()) {
					return j;
				}
			}
			// Return the first entry
			return januaryConfirmedCacheTwo.get(0);
		}
	}

	@Override
	public February getFebruaryEntityByLocation(String location) {
		if (cacheOne) {
			Long index = locationsAndIdsCacheOne.get(location);
			for (February f : februaryConfirmedCacheOne) {
				if (index == f.getId()) {
					return f;
				}
			}
			// Return the first entry
			return februaryConfirmedCacheOne.get(0);
		} else {
			Long index = locationsAndIdsCacheTwo.get(location);
			for (February f : februaryConfirmedCacheTwo) {
				if (index == f.getId()) {
					return f;
				}
			}
			// Return the first entry
			return februaryConfirmedCacheTwo.get(0);
		}
	}

	@Override
	public March getMarchEntityByLocation(String location) {
		if (cacheOne) {
			Long index = locationsAndIdsCacheOne.get(location);
			for (March m : marchConfirmedCacheOne) {
				if (index == m.getId()) {
					return m;
				}
			}
			// Return the first entry
			return marchConfirmedCacheOne.get(0);
		} else {
			Long index = locationsAndIdsCacheTwo.get(location);
			for (March m : marchConfirmedCacheTwo) {
				if (index == m.getId()) {
					return m;
				}
			}
			// Return the first entry
			return marchConfirmedCacheTwo.get(0);
		}
	}

	@Override
	public April getAprilEntityByLocation(String location) {
		if (cacheOne) {
			Long index = locationsAndIdsCacheOne.get(location);
			for (April a : aprilConfirmedCacheOne) {
				if (index == a.getId()) {
					return a;
				}
			}
			// Return the first entry
			return aprilConfirmedCacheOne.get(0);
		} else {
			Long index = locationsAndIdsCacheTwo.get(location);
			for (April a : aprilConfirmedCacheTwo) {
				if (index == a.getId()) {
					return a;
				}
			}
			// Return the first entry
			return aprilConfirmedCacheTwo.get(0);
		}
	}

	@Override
	public May getMayEntityByLocation(String location) {
		if (cacheOne) {
			Long index = locationsAndIdsCacheOne.get(location);
			for (May m : mayConfirmedCacheOne) {
				if (index == m.getId()) {
					return m;
				}
			}
			// Return the first entry
			return mayConfirmedCacheOne.get(0);
		} else {
			Long index = locationsAndIdsCacheTwo.get(location);
			for (May m : mayConfirmedCacheTwo) {
				if (index == m.getId()) {
					return m;
				}
			}
			// Return the first entry
			return mayConfirmedCacheTwo.get(0);
		}
	}

	@Override
	public JanuaryDeaths getJanuaryDeathByLocation(String location) {
		if (cacheOne) {
			Long index = deathLocationsAndIdsCacheOne.get(location);
			for (JanuaryDeaths j : januaryDeathsCacheOne) {
				if (index == j.getId()) {
					return j;
				}
			}
			// Return the first entry
			return januaryDeathsCacheOne.get(0);
		} else {
			Long index = deathLocationsAndIdsCacheTwo.get(location);
			for (JanuaryDeaths j : januaryDeathsCacheTwo) {
				if (index == j.getId()) {
					return j;
				}
			}
			// Return the first entry
			return januaryDeathsCacheTwo.get(0);
		}
	}

	@Override
	public FebruaryDeaths getFebruaryDeathsByLocation(String location) {
		if (cacheOne) {
			Long index = deathLocationsAndIdsCacheOne.get(location);
			for (FebruaryDeaths f : februaryDeathsCacheOne) {
				if (index == f.getId()) {
					return f;
				}
			}
			// Return the first entry
			return februaryDeathsCacheOne.get(0);
		} else {
			Long index = deathLocationsAndIdsCacheTwo.get(location);
			for (FebruaryDeaths f : februaryDeathsCacheTwo) {
				if (index == f.getId()) {
					return f;
				}
			}
			// Return the first entry
			return februaryDeathsCacheTwo.get(0);
		}
	}

	@Override
	public MarchDeaths getMarchDeathsByLocation(String location) {
		if (cacheOne) {
			Long index = deathLocationsAndIdsCacheOne.get(location);
			for (MarchDeaths m : marchDeathsCacheOne) {
				if (index == m.getId()) {
					return m;
				}
			}
			// Return the first entry
			return marchDeathsCacheOne.get(0);
		} else {
			Long index = deathLocationsAndIdsCacheTwo.get(location);
			for (MarchDeaths m : marchDeathsCacheTwo) {
				if (index == m.getId()) {
					return m;
				}
			}
			// Return the first entry
			return marchDeathsCacheTwo.get(0);
		}
	}

	@Override
	public AprilDeaths getAprilDeathsByLocation(String location) {
		if (cacheOne) {
			Long index = deathLocationsAndIdsCacheOne.get(location);
			for (AprilDeaths a : aprilDeathsCacheOne) {
				if (index == a.getId()) {
					return a;
				}
			}
			// Return the first entry
			return aprilDeathsCacheOne.get(0);
		} else {
			Long index = deathLocationsAndIdsCacheTwo.get(location);
			for (AprilDeaths a : aprilDeathsCacheTwo) {
				if (index == a.getId()) {
					return a;
				}
			}
			// Return the first entry
			return aprilDeathsCacheTwo.get(0);
		}
	}

	@Override
	public MayDeaths getMayDeathsByLocation(String location) {
		if (cacheOne) {
			Long index = deathLocationsAndIdsCacheOne.get(location);
			for (MayDeaths m : mayDeathsCacheOne) {
				if (index == m.getId()) {
					return m;
				}
			}
			// Return the first entry
			return mayDeathsCacheOne.get(0);
		} else {
			Long index = deathLocationsAndIdsCacheTwo.get(location);
			for (MayDeaths m : mayDeathsCacheTwo) {
				if (index == m.getId()) {
					return m;
				}
			}
			// Return the first entry
			return mayDeathsCacheTwo.get(0);
		}
	}
}
