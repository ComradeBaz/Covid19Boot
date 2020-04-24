package com.domrade.interfaces.local;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.domrade.entity.EntityType;
import com.domrade.rest.request.UsStateAndCounty;

@Service
public interface CachedUsMonthlyDataLocal {

	public LinkedHashMap<String, Integer> getUsDataByState(String state);

	public LinkedHashMap<String, Integer> getUsDataByCounty(String countyId);

	public LinkedHashMap<String, Integer> getUsDeathsByState(String state);

	public LinkedHashMap<String, Integer> getUsDeathsByCounty(String countyId);

	public Map<String, Integer> getConfirmedCountyDataByCountyId(String id);

	public Map<String, Integer> getDeathsCountyDataByCountyId(String id);

	public ArrayList<LinkedHashMap<String, Integer>> formatDataForMultipleUsLocations(
			UsStateAndCounty[] statesAndCounties, String level, EntityType entityType);

}
