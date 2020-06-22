package com.domrade.interfaces.cache;

import java.util.LinkedHashMap;

import org.springframework.stereotype.Service;

@Service
public interface ICachedCovidData {

	public LinkedHashMap<String, LinkedHashMap<String, Integer>> getCachedUsStateData(String type);

	public LinkedHashMap<Long, LinkedHashMap<String, Integer>> getCachedUsCountyData(String type);

	public LinkedHashMap<String, LinkedHashMap<String, Integer>> getGlobalData(String type);

}
