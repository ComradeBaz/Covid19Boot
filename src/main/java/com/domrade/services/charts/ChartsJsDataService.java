/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.domrade.services.charts;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.domrade.chartjs.chart.data.ChartsJsDataMultipleDataSets;
import com.domrade.chartjs.chart.data.ChartsJsDataSingleDataSet;
import com.domrade.chartjs.chart.data.LocationCombinedCountryAndState;
import com.domrade.chartjs.chart.data.datasets.ChartsJsDataSet;
import com.domrade.entity.EntityType;
import com.domrade.interfaces.charts.ChartsJsDataServiceLocal;
import com.domrade.interfaces.data.DataProcessingServiceLocal;
import com.domrade.interfaces.data.FormatDataServiceLocal;
import com.domrade.rest.request.RequestType;
import com.domrade.rest.request.UsStateAndCounty;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 *
 * @author David
 */
@Service
public class ChartsJsDataService implements ChartsJsDataServiceLocal {

	private final ObjectMapper mapper = new ObjectMapper();

	@Autowired
	private FormatDataServiceLocal formatDataService;

	@Autowired
	private DataProcessingServiceLocal dataProcessingService;

	// Get an object representing the data format of a Charts.js chart with multiple
	// datasets
	@Override
	public <T> ChartsJsDataSingleDataSet getChartsJsDataSingleDataSet(T type, String label, RequestType requestType,
			EntityType entityType) {

		List<Integer> dataArrayList = new ArrayList<>();
		String chartType = this.getChartLabel(requestType, entityType);

		if (requestType == RequestType.RAW_DATA) {
			dataArrayList = formatDataService.getDataArrayList(type);
		} else if (requestType == RequestType.DAILY_INCREASE) {
			dataArrayList = dataProcessingService.calculateDailyIncrease(type);
		}
		// Get the chart labels
		String[] chartLabels = this.getChartsJsLabels(type);
		ChartsJsDataSingleDataSet returnValue = new ChartsJsDataSingleDataSet(chartLabels, dataArrayList, chartType);

		return returnValue;
	}

	// Handle request for CombinedLocation where countryRegion/provinceState are
	// combined to one string in the request
	@Override
	public <T> ChartsJsDataMultipleDataSets getChartsJsDataForLocations(
			ArrayList<LinkedHashMap<String, Integer>> listOfCountries, LocationCombinedCountryAndState[] locations,
			RequestType requestType, LocationCombinedCountryAndState[] originalOrder) {

		ArrayList<Integer> dataArrayList = new ArrayList<>();
		int[] dataArray;
		int index = 0;
		// The same chart labels apply to all entries in listOfCountries
		String[] labelsArray = this.getChartsJsLabels(listOfCountries.get(0));
		ArrayList<ChartsJsDataSet> arrayList = new ArrayList<>();
		for (Map m : listOfCountries) {
			// dataArrayList = formatDataService.getDataArrayList(m);
			if (requestType == RequestType.RAW_DATA) {
				dataArrayList = formatDataService.getDataArrayList(m);
			} else if (requestType == RequestType.DAILY_INCREASE) {
				dataArrayList = dataProcessingService.calculateDailyIncrease(m);
			}
			String label = locations[index].getCombinedCountryAndState();
			ChartsJsDataSet dataSet = new ChartsJsDataSet(dataArrayList, label);
			arrayList.add(dataSet);
			index++;
		}

		ChartsJsDataMultipleDataSets chartObject = new ChartsJsDataMultipleDataSets(
				dataProcessingService.getOriginalOrder(arrayList, originalOrder), labelsArray);

		return chartObject;
	}

	// Handle request for CombinedLocation where countryRegion/provinceState are
	// combined to one string in the request
	@Override
	public <T> ChartsJsDataMultipleDataSets getChartsJsDataForUsLocations(
			ArrayList<LinkedHashMap<String, Integer>> listOfCountries, UsStateAndCounty[] locations,
			RequestType requestType, UsStateAndCounty statesAndCounties[]) {

		ArrayList<Integer> dataArrayList = new ArrayList<>();
		int[] dataArray;
		int index = 0;
		// The same chart labels apply to all entries in listOfCountries
		String[] labelsArray = this.getChartsJsLabels(listOfCountries.get(0));
		ArrayList<ChartsJsDataSet> arrayList = new ArrayList<>();
		for (Map m : listOfCountries) {
			// dataArrayList = formatDataService.getDataArrayList(m);
			if (requestType == RequestType.RAW_DATA) {
				dataArrayList = formatDataService.getDataArrayList(m);
			} else if (requestType == RequestType.DAILY_INCREASE) {
				dataArrayList = dataProcessingService.calculateDailyIncrease(m);
			}
			String label = locations[index].getCounty().equalsIgnoreCase("") ? locations[index].getState()
					: locations[index].getCounty();
			ChartsJsDataSet dataSet = new ChartsJsDataSet(dataArrayList, label);
			arrayList.add(dataSet);
			index++;
		}
		ChartsJsDataMultipleDataSets chartObject = new ChartsJsDataMultipleDataSets(
				dataProcessingService.getOriginalOrderForUsLocations(arrayList, statesAndCounties), labelsArray);

		return chartObject;
	}

	// Get an array of labels for a chart
	@Override
	public <T> String[] getChartsJsLabels(T type) {
		LinkedHashMap<String, Integer> map = mapper.convertValue(type, LinkedHashMap.class);
		String[] stringArray = new String[map.size()];
		int index = 0;
		for (Map.Entry<String, Integer> entry : map.entrySet()) {
			stringArray[index] = entry.getKey();
			index++;
		}
		return stringArray;
	}

	@Override
	public String getChartLabel(RequestType requestType, EntityType entityType) {

		if (requestType == RequestType.RAW_DATA) {
			if (entityType == EntityType.CONFIRMED) {
				return "Total Confirmed Cases";
			} else if (entityType == EntityType.DEATHS) {
				return "Total Confirmed Deaths";
			}
		} else if (requestType == RequestType.DAILY_INCREASE) {
			if (entityType == EntityType.CONFIRMED) {
				return "Daily Increase - Confirmed Cases";
			} else if (entityType == EntityType.DEATHS) {
				return "Daily Increase - Deaths";
			}
		}

		return "Unknown";
	}
}
