package com.domrade.interfaces.cache;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public interface CachedLocationsLocal {

	public List<String> getUsStates();

	public List<Long> getUsLocationIds();

	public List<Long> getGlobalLocationIds();

	public List<String> getGlobalLocations();

	public long getCountyIdByStateAndCounty(String state, String county);

	public ArrayList<String> getCountiesByState(String state);

}
