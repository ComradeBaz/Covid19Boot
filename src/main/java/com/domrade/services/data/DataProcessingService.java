/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.domrade.services.data;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.domrade.interfaces.data.DataProcessingServiceLocal;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 *
 * @author David
 */
@Service
public class DataProcessingService implements DataProcessingServiceLocal {

	private final ObjectMapper mapper = new ObjectMapper();

	public DataProcessingService() {
		// no arg constructor
	}

	// Calculate the number of new cases per day by subtracting the total for
	// "yesterday" from the total for "today".
	@Override
	// public LinkedHashMap<String, Integer> calculateDailyIncrease(Map type) {
	public <T> ArrayList<Integer> calculateDailyIncrease(T type) {
		LinkedHashMap<String, Integer> map = mapper.convertValue(type, LinkedHashMap.class);
		Map.Entry<String, Integer> firstEntry = map.entrySet().iterator().next();
		String key = firstEntry.getKey();
		int lastEntryValue = 0;
		int currentEntryValue;

		// int[] dataArray = new int[map.size()];
		ArrayList<Integer> returnList = new ArrayList<>();
		// int index = 0;
		int result;
		boolean firstEntrySet = false;

		for (Map.Entry<String, Integer> entry : map.entrySet()) {
			try {
				// For the first entry in the map
				if ((entry.getKey().equalsIgnoreCase(key))) {
					lastEntryValue = entry.getValue();
					// dataArray[index] = entry.getValue();
					returnList.add(entry.getValue());
					firstEntrySet = true;
					// index++;
				} else {
					currentEntryValue = entry.getValue();
					result = currentEntryValue - lastEntryValue;
					entry.setValue(result);
					// dataArray[index] = result;
					returnList.add(result);
					// index++;
					lastEntryValue = currentEntryValue;
				}
			} catch (NullPointerException npe) {
				// This map has been padded with entries to make it the same length
				// as the entries for another entity with which it will share a chart
				// The x axis has been lengthened with null values
				// NPE will occur until iterator gets to the first entry for which there
				// is an Integer value.
				if (!(firstEntrySet)) {
					lastEntryValue = 0;
					// firstEntrySet = true;
					returnList.add(null);
				} else {
					returnList.add(0);
					lastEntryValue = 0;
				}
			}
		}

		return returnList;
	}

	@Override
	public <T> ArrayList<Float> calculateDailyIncreasePercentage(T type) {
		LinkedHashMap<String, Float> map = mapper.convertValue(type, LinkedHashMap.class);

		Map.Entry<String, Float> firstEntry = map.entrySet().iterator().next();
		String key = firstEntry.getKey();
		float lastEntryValue = 0;
		float currentEntryValue;

		// int[] dataArray = new int[map.size()];
		ArrayList<Float> returnList = new ArrayList<>();
		// int index = 0;
		float result;
		float total = 0;
		boolean firstEntrySet = false;

		for (Map.Entry<String, Float> entry : map.entrySet()) {
			try {
				// For the first entry in the map
				if ((entry.getKey().equalsIgnoreCase(key))) {
					lastEntryValue = entry.getValue();
					// dataArray[index] = entry.getValue();
					returnList.add(0F);
					total += entry.getValue();
					firstEntrySet = true;
					// index++;
				} else {
					currentEntryValue = entry.getValue();
					result = currentEntryValue - lastEntryValue;
					entry.setValue(this.calculateDailyIncreaseAsPercent(total, result));
					// dataArray[index] = result;
					returnList.add(this.calculateDailyIncreaseAsPercent(total, result));

					// index++;
					total += currentEntryValue;
					lastEntryValue = currentEntryValue;
				}
			} catch (NullPointerException npe) {
				// This map has been padded with entries to make it the same length
				// as the entries for another entity with which it will share a chart
				// The x axis has been lengthened with null values
				// NPE will occur until iterator gets to the first entry for which there
				// is an Integer value.
				if (!(firstEntrySet)) {
					lastEntryValue = 0;
					firstEntrySet = true;
					returnList.add(null);
				}
				// 0 is correct for dailyIncrease or dailyIncreasePercent
				returnList.add(0F);
				lastEntryValue = 0;
			}
		}

		return returnList;
	}

	public float calculateDailyIncreaseAsPercent(float total, float dailyIncrease) {
		return (dailyIncrease / total) * 100;
	}
}
