package com.domrade.cache.locations;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.jboss.logging.Logger;
import org.jboss.logging.Logger.Level;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.domrade.interfaces.cache.CachedLocationsLocal;
import com.domrade.interfaces.cache.ICachedLocations;

@Component
@Scope("singleton")
public class CachedLocations implements CachedLocationsLocal {

	private static final Logger LOGGER = Logger.getLogger(CachedLocations.class);

	@Autowired
	private ICachedLocations cachedLocationService;

	// Caching
	private boolean cacheOne = true;
	private boolean cacheTwo;

	// List of locations
	// private List<String> locationsCacheOne;
	// private List<String> locationsCacheTwo;

	// US States
	private List<String> usStatesCacheOne;
	private List<String> usStatesCacheTwo;
	// US States and Counties with IDs
	private LinkedHashMap<String, LinkedHashMap<String, Long>> statesAndCountiesCacheOne;
	private LinkedHashMap<String, LinkedHashMap<String, Long>> statesAndCountiesCacheTwo;
	// US States and counties but not Ids
	private LinkedHashMap<String, ArrayList<String>> statesAndCountiesNoIdCacheOne;
	private LinkedHashMap<String, ArrayList<String>> statesAndCountiesNoIdCacheTwo;
	// US Location Ids
	private List<Long> usLocationIdsCacheOne;
	private List<Long> usLocationIdsCacheTwo;
	// Global Location Ids
	private List<Long> globalLocationIdsCacheOne;
	private List<Long> globalLocationIdsCacheTwo;
	// Global Location Strings
	private List<String> globalLocationsCacheOne;
	private List<String> globalLocationsCacheTwo;

	public CachedLocations() {

	}

	@PostConstruct
	public void init() {
		LOGGER.log(Level.DEBUG, "Initialising Locations cache");
		usLocationIdsCacheOne = cachedLocationService.getUsLocationIds();
		globalLocationIdsCacheOne = cachedLocationService.getGlobalLocationIds();
		globalLocationsCacheOne = cachedLocationService.getGlobalLocations();
		// locationsCacheOne = cachedLocationService.getGlobalLocations();
		usStatesCacheOne = cachedLocationService.getUsStates();
		statesAndCountiesCacheOne = cachedLocationService.getUsStatesAndCounties();
		statesAndCountiesNoIdCacheOne = cachedLocationService.getStatesAndCountiesNoId();
		cacheOne = true;
		cacheTwo = false;
	}

	public void updateCache() {
		if (!cacheOne) {
			LOGGER.log(Level.DEBUG, "Updating cacheOne");
			usLocationIdsCacheOne = cachedLocationService.getUsLocationIds();
			globalLocationIdsCacheOne = cachedLocationService.getGlobalLocationIds();
			globalLocationsCacheOne = cachedLocationService.getGlobalLocations();
			// locationsCacheOne = cachedLocationService.getGlobalLocations();
			usStatesCacheOne = cachedLocationService.getUsStates();
			statesAndCountiesCacheOne = cachedLocationService.getUsStatesAndCounties();
			statesAndCountiesNoIdCacheOne = cachedLocationService.getStatesAndCountiesNoId();
			cacheOne = true;
			cacheTwo = false;
		} else {
			LOGGER.log(Level.DEBUG, "Updating cacheTwo");
			usLocationIdsCacheTwo = cachedLocationService.getUsLocationIds();
			globalLocationIdsCacheTwo = cachedLocationService.getGlobalLocationIds();
			globalLocationsCacheTwo = cachedLocationService.getGlobalLocations();
			// locationsCacheTwo = cachedLocationService.getGlobalLocations();
			usStatesCacheTwo = cachedLocationService.getUsStates();
			statesAndCountiesCacheTwo = cachedLocationService.getUsStatesAndCounties();
			statesAndCountiesNoIdCacheTwo = cachedLocationService.getStatesAndCountiesNoId();
			cacheOne = false;
			cacheTwo = true;
		}
	}

	@Override
	public List<String> getUsStates() {
		if (cacheOne) {
			return usStatesCacheOne;
		} else {
			return usStatesCacheTwo;
		}
	}

	@Override
	public List<Long> getUsLocationIds() {
		if (cacheOne) {
			return this.usLocationIdsCacheOne;
		} else {
			return this.usLocationIdsCacheTwo;
		}
	}

	@Override
	public List<Long> getGlobalLocationIds() {
		if (cacheOne) {
			return this.globalLocationIdsCacheOne;
		} else {
			return this.globalLocationIdsCacheTwo;
		}
	}

	@Override
	public List<String> getGlobalLocations() {
		if (cacheOne) {
			return this.globalLocationsCacheOne;
		} else {
			return this.globalLocationsCacheTwo;
		}
	}

	@Override
	public long getCountyIdByStateAndCounty(String state, String county) {
		if (cacheOne) {
			Map<String, Long> statesAndCounties = this.statesAndCountiesCacheOne.get(state);
			long id = statesAndCounties.get(county);

			return id;
		} else {
			Map<String, Long> statesAndCounties = this.statesAndCountiesCacheTwo.get(state);
			long id = statesAndCounties.get(county);

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
