package com.domrade.interfaces.data;

import java.util.LinkedHashMap;

import org.springframework.stereotype.Service;

import com.domrade.entity.EntityType;

@Service
public interface FormatUsDataServiceLocal {

	// public Map<String, Map<String, Integer>> getUsStateLevelData();

	// public LinkedHashMap<String, LinkedHashMap<String, Integer>> getUsData(String
	// level, EntityType entityType);

	public <T> LinkedHashMap<String, Integer> removeLocationDetails(T type, EntityType entityType);

}
