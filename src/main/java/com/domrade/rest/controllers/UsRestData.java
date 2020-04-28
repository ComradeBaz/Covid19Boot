package com.domrade.rest.controllers;

import java.util.ArrayList;
import java.util.LinkedHashMap;

import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.domrade.entity.EntityType;
import com.domrade.interfaces.charts.ChartsJsDataServiceLocal;
import com.domrade.interfaces.converters.ConvertStringToEnumTypeServiceLocal;
import com.domrade.interfaces.converters.ConvertToStringServiceLocal;
import com.domrade.interfaces.data.FormatDataServiceLocal;
import com.domrade.interfaces.data.FormatUsDataServiceLocal;
import com.domrade.interfaces.local.CachedDataLocal;
import com.domrade.interfaces.local.CachedUsMonthlyDataLocal;
import com.domrade.rest.request.CollectionUsStateAndCounty;
import com.domrade.rest.request.RequestType;
import com.domrade.rest.request.UsStateAndCounty;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class UsRestData {

	@Autowired
	private CachedUsMonthlyDataLocal cachedUsData;

	@Autowired
	CachedDataLocal cachedData;

	@Autowired
	private ChartsJsDataServiceLocal chartsJsDataService;

	@Autowired
	private ConvertToStringServiceLocal convertToStringService;

	@Autowired
	private ConvertStringToEnumTypeServiceLocal convertStringToEnumTypeService;

	@Autowired
	private FormatUsDataServiceLocal formatUsDataService;

	@Autowired
	private FormatDataServiceLocal formatDataService;

	public UsRestData() {
		// TODO Auto-generated constructor stub
	}

	@GetMapping("/getStates")
	@Produces(MediaType.APPLICATION_JSON)
	public String getStates() {

		return convertToStringService.convertToJsonArray(cachedData.getUsStates());
	}

	@GetMapping("/getCountiesByState")
	@Produces(MediaType.APPLICATION_JSON)
	public String getCountiesByState(@RequestParam String state) {

		return convertToStringService.convertToJsonArray(cachedData.getCountiesByState(state));
	}

	@GetMapping("/getConfirmedDataByState")
	@Produces(MediaType.APPLICATION_JSON)
	public String getConfirmedDataByState(@RequestParam String state) {

		return convertToStringService.convertGenericObjectToJsonObject(chartsJsDataService.getChartsJsDataSingleDataSet(
				cachedUsData.getUsDataByState(state), state, RequestType.RAW_DATA, EntityType.CONFIRMED));

	}

	@GetMapping("/getDeathsDataByState")
	@Produces(MediaType.APPLICATION_JSON)
	public String getDeathsDataByState(@RequestParam String state) {

		// returns a simple array of strings
		return convertToStringService.convertGenericObjectToJsonObject(chartsJsDataService.getChartsJsDataSingleDataSet(
				cachedUsData.getUsDeathsByState(state), state, RequestType.RAW_DATA, EntityType.DEATHS));

	}

	@GetMapping("/getDailyIncreaseConfirmedDataByState")
	@Produces(MediaType.APPLICATION_JSON)
	public String getDailyIncreaseConfirmedDataByState(@RequestParam String state) {

		return convertToStringService.convertGenericObjectToJsonObject(chartsJsDataService.getChartsJsDataSingleDataSet(
				cachedUsData.getUsDataByState(state), state, RequestType.DAILY_INCREASE, EntityType.CONFIRMED));

	}

	@GetMapping("/getDailyIncreaseDeathsDataByState")
	@Produces(MediaType.APPLICATION_JSON)
	public String getDailyIncreaseDeathsDataByState(@RequestParam String state) {

		// returns a simple array of strings
		return convertToStringService.convertGenericObjectToJsonObject(chartsJsDataService.getChartsJsDataSingleDataSet(
				cachedUsData.getUsDeathsByState(state), state, RequestType.DAILY_INCREASE, EntityType.DEATHS));

	}

	@GetMapping("/getConfirmedDataByCounty")
	@Produces(MediaType.APPLICATION_JSON)
	public String getConfirmedDataByCounty(@RequestParam String state, @RequestParam String county) {

		String countyId = cachedData.getCountyIdByStateAndCounty(state, county);

		return convertToStringService.convertGenericObjectToJsonObject(chartsJsDataService.getChartsJsDataSingleDataSet(
				cachedUsData.getConfirmedCountyDataByCountyId(countyId), state, RequestType.RAW_DATA,
				EntityType.CONFIRMED));

	}

	@GetMapping("/getDeathsDataByCounty")
	@Produces(MediaType.APPLICATION_JSON)
	public String getDeathsDataByCounty(@RequestParam String state, @RequestParam String county) {

		String countyId = cachedData.getCountyIdByStateAndCounty(state, county);

		// returns a simple array of strings
		return convertToStringService.convertGenericObjectToJsonObject(chartsJsDataService.getChartsJsDataSingleDataSet(
				cachedUsData.getDeathsCountyDataByCountyId(countyId), state, RequestType.RAW_DATA, EntityType.DEATHS));

	}

	@GetMapping("/getDailyIncreaseConfirmedDataByCounty")
	@Produces(MediaType.APPLICATION_JSON)
	public String getDailyIncreaseConfirmedDataByCounty(@RequestParam String state, @RequestParam String county) {

		String countyId = cachedData.getCountyIdByStateAndCounty(state, county);

		return convertToStringService.convertGenericObjectToJsonObject(chartsJsDataService.getChartsJsDataSingleDataSet(
				cachedUsData.getConfirmedCountyDataByCountyId(countyId), state, RequestType.DAILY_INCREASE,
				EntityType.CONFIRMED));

	}

	@GetMapping("/getDailyIncreaseDeathsDataByCounty")
	@Produces(MediaType.APPLICATION_JSON)
	public String getDailyIncreaseDeathsDataByCounty(@RequestParam String state, @RequestParam String county) {

		String countyId = cachedData.getCountyIdByStateAndCounty(state, county);

		// returns a simple array of strings
		return convertToStringService.convertGenericObjectToJsonObject(
				chartsJsDataService.getChartsJsDataSingleDataSet(cachedUsData.getDeathsCountyDataByCountyId(countyId),
						state, RequestType.DAILY_INCREASE, EntityType.DEATHS));

	}

	@PostMapping("/getUsCompareLocations")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public String getUsCompareLocations(@RequestBody CollectionUsStateAndCounty request) {

		RequestType requestType = convertStringToEnumTypeService.convertStringToRequestType(request.getRequestType());
		EntityType entityType = convertStringToEnumTypeService.convertStringToEntityType(request.getEntityType());
		UsStateAndCounty statesAndCounties[] = request.getStatesAndCounties();

		// Get the raw data for each location
		ArrayList<LinkedHashMap<String, Integer>> locationsData = cachedUsData
				.formatDataForMultipleUsLocations(statesAndCounties, request.getLevel(), entityType);
		// Get index of longest map
		int indexOfLongestMap = formatDataService.getIndexOfLongestMap(locationsData);
		UsStateAndCounty[] reorderedLocation = formatUsDataService.getReorderedListOfStatesCounties(statesAndCounties,
				indexOfLongestMap);
		// Standardise the data by making the data sets for each country the same length
		ArrayList<LinkedHashMap<String, Integer>> listOfStatesCounties = formatDataService
				.formatDataForListOfCountriesDataSet(locationsData, indexOfLongestMap);
		// returns a json object representing chart data
		return convertToStringService.convertGenericObjectToJsonArray(chartsJsDataService.getChartsJsDataForUsLocations(
				listOfStatesCounties, reorderedLocation, requestType, statesAndCounties));
	}

}
