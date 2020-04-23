package com.domrade.interfaces.local;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

@Service
public interface CachedUsMonthlyDataLocal {

	public LinkedHashMap<String, Integer> getUsDataByState(String state);

	public LinkedHashMap<String, Integer> getUsDataByCounty(String countyId);

	public LinkedHashMap<String, Integer> getUsDeathsByState(String state);

	public LinkedHashMap<String, Integer> getUsDeathsByCounty(String countyId);

	public Map<String, Integer> getConfirmedCountyDataByCountyId(String id);

	public Map<String, Integer> getDeathsCountyDataByCountyId(String id);

}
