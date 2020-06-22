package com.domrade.interfaces.cache;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public interface ICachedLocations {

	public List<String> getGlobalLocations();

	public List<String> getUsStates();

	public LinkedHashMap<String, LinkedHashMap<String, Long>> getUsStatesAndCounties();

	public LinkedHashMap<String, ArrayList<String>> getStatesAndCountiesNoId();

	public List<Long> getUsLocationIds();

	public List<Long> getGlobalLocationIds();

}
