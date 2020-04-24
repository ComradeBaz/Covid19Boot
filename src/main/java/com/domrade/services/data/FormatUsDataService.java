package com.domrade.services.data;

import java.util.LinkedHashMap;

import org.springframework.stereotype.Service;

import com.domrade.entity.EntityType;
import com.domrade.interfaces.data.FormatUsDataServiceLocal;
import com.domrade.rest.request.UsStateAndCounty;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class FormatUsDataService implements FormatUsDataServiceLocal {

	private final ObjectMapper mapper = new ObjectMapper();

	public FormatUsDataService() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public <T> LinkedHashMap<String, Integer> removeLocationDetails(T type, EntityType entityType) {
		LinkedHashMap<String, Integer> map = mapper.convertValue(type, LinkedHashMap.class);
		// Remove id and location details
		map.remove("id");
		map.remove("provenceState");
		map.remove("countryRegion");
		map.remove("latitude");
		map.remove("longitude");
		map.remove("admin2");

		if (entityType == EntityType.US_DEATHS) {
			map.remove("population");
		}

		return map;
	}

	@Override
	public UsStateAndCounty[] getReorderedListOfStatesCounties(UsStateAndCounty[] locations, int indexOfLongestMap) {
		UsStateAndCounty[] returnArray = new UsStateAndCounty[locations.length];
		returnArray[0] = locations[indexOfLongestMap];
		for (int i = 1, j = 0; j < locations.length; j++) {
			if (j != indexOfLongestMap) {
				returnArray[i] = locations[j];
				i++;
			}
		}
		return returnArray;
	}
}
