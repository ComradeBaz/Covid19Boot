package com.domrade.interfaces.cache;

import java.util.ArrayList;
import java.util.LinkedHashMap;

import org.springframework.stereotype.Service;

@Service
public interface CachedUsMonthlyDataServiceLocal {

	public LinkedHashMap<String, LinkedHashMap<String, Integer>> getUsDataConfirmed(String level);

	public LinkedHashMap<String, LinkedHashMap<String, Integer>> getUsDataDeaths(String level);

	public LinkedHashMap<String, LinkedHashMap<String, String>> getStatesAndCounties();

	public LinkedHashMap<String, ArrayList<String>> getCountiesByState(
			LinkedHashMap<String, LinkedHashMap<String, String>> statesAndCounties);

}
