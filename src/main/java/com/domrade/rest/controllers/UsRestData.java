package com.domrade.rest.controllers;

import java.util.ArrayList;
import java.util.LinkedHashMap;

import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.jboss.logging.Logger;
import org.jboss.logging.Logger.Level;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.domrade.entity.EntityType;
import com.domrade.interfaces.cache.CachedLocationsLocal;
import com.domrade.interfaces.charts.ChartsJsDataServiceLocal;
import com.domrade.interfaces.converters.ConvertStringToEnumTypeServiceLocal;
import com.domrade.interfaces.converters.ConvertToStringServiceLocal;
import com.domrade.interfaces.data.FormatDataServiceLocal;
import com.domrade.interfaces.data.FormatUsDataServiceLocal;
import com.domrade.interfaces.local.CachedCovidDataLocal;
import com.domrade.rest.request.CollectionUsStateAndCounty;
import com.domrade.rest.request.RequestType;
import com.domrade.rest.request.UsStateAndCounty;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class UsRestData {

	private final static Logger LOGGER = Logger.getLogger(UsRestData.class);
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

	@Autowired
	private CachedLocationsLocal cachedLocations;

	@Autowired
	private CachedCovidDataLocal cachedCovidData;

	public UsRestData() {
		// TODO Auto-generated constructor stub
	}

	@GetMapping("/getStates")
	@Produces(MediaType.APPLICATION_JSON)
	public String getStates() {
		LOGGER.log(Level.DEBUG, "Getting US states");
		return convertToStringService.convertToJsonArray(cachedLocations.getUsStates());
	}

	@GetMapping("/getCountiesByState")
	@Produces(MediaType.APPLICATION_JSON)
	public String getCountiesByState(@RequestParam String state) {
		LOGGER.log(Level.DEBUG, "Getting US counties by state");
		return convertToStringService.convertToJsonArray(cachedLocations.getCountiesByState(state));
	}

	@GetMapping("/getConfirmedDataByState")
	@Produces(MediaType.APPLICATION_JSON)
	public String getConfirmedDataByState(@RequestParam String state) {
		LOGGER.log(Level.DEBUG, "Getting confirmed US data by state: " + state);
		return convertToStringService.convertGenericObjectToJsonObject(chartsJsDataService.getChartsJsDataSingleDataSet(
				cachedCovidData.getUsDataByState(state), state, RequestType.RAW_DATA, EntityType.CONFIRMED));

	}

	@GetMapping("/getDeathsDataByState")
	@Produces(MediaType.APPLICATION_JSON)
	public String getDeathsDataByState(@RequestParam String state) {
		LOGGER.log(Level.DEBUG, "Getting deaths US data by state: " + state);
		// returns a simple array of strings
		return convertToStringService.convertGenericObjectToJsonObject(chartsJsDataService.getChartsJsDataSingleDataSet(
				cachedCovidData.getUsDeathsByState(state), state, RequestType.RAW_DATA, EntityType.DEATHS));

	}

	@GetMapping("/getDailyIncreaseConfirmedDataByState")
	@Produces(MediaType.APPLICATION_JSON)
	public String getDailyIncreaseConfirmedDataByState(@RequestParam String state) {
		LOGGER.log(Level.DEBUG, "Getting daily increase US confirmed data by state: " + state);
		return convertToStringService.convertGenericObjectToJsonObject(chartsJsDataService.getChartsJsDataSingleDataSet(
				cachedCovidData.getUsDataByState(state), state, RequestType.DAILY_INCREASE, EntityType.CONFIRMED));

	}

	@GetMapping("/getDailyIncreaseDeathsDataByState")
	@Produces(MediaType.APPLICATION_JSON)
	public String getDailyIncreaseDeathsDataByState(@RequestParam String state) {
		LOGGER.log(Level.DEBUG, "Getting daily increase US deaths data by state: " + state);
		// returns a simple array of strings
		return convertToStringService.convertGenericObjectToJsonObject(chartsJsDataService.getChartsJsDataSingleDataSet(
				cachedCovidData.getUsDeathsByState(state), state, RequestType.DAILY_INCREASE, EntityType.DEATHS));

	}

	@GetMapping("/getConfirmedDataByCounty")
	@Produces(MediaType.APPLICATION_JSON)
	public String getConfirmedDataByCounty(@RequestParam String state, @RequestParam String county) {
		LOGGER.log(Level.DEBUG, "Getting confirmed US data by state: " + state + " and county: " + county);
		long countyId = cachedLocations.getCountyIdByStateAndCounty(state, county);

		return convertToStringService.convertGenericObjectToJsonObject(chartsJsDataService.getChartsJsDataSingleDataSet(
				cachedCovidData.getConfirmedCountyDataByCountyId(countyId), state, RequestType.RAW_DATA,
				EntityType.CONFIRMED));

	}

	@GetMapping("/getDeathsDataByCounty")
	@Produces(MediaType.APPLICATION_JSON)
	public String getDeathsDataByCounty(@RequestParam String state, @RequestParam String county) {
		LOGGER.log(Level.DEBUG, "Getting deaths US data by state: " + state + " and county: " + county);
		long countyId = cachedLocations.getCountyIdByStateAndCounty(state, county);

		// returns a simple array of strings
		return convertToStringService.convertGenericObjectToJsonObject(chartsJsDataService.getChartsJsDataSingleDataSet(
				cachedCovidData.getDeathsCountyDataByCountyId(countyId), state, RequestType.RAW_DATA,
				EntityType.DEATHS));

	}

	@GetMapping("/getDailyIncreaseConfirmedDataByCounty")
	@Produces(MediaType.APPLICATION_JSON)
	public String getDailyIncreaseConfirmedDataByCounty(@RequestParam String state, @RequestParam String county) {
		LOGGER.log(Level.DEBUG,
				"Getting daily increase US confirmed data by state: " + state + " and county: " + county);
		long countyId = cachedLocations.getCountyIdByStateAndCounty(state, county);

		return convertToStringService.convertGenericObjectToJsonObject(chartsJsDataService.getChartsJsDataSingleDataSet(
				cachedCovidData.getConfirmedCountyDataByCountyId(countyId), state, RequestType.DAILY_INCREASE,
				EntityType.CONFIRMED));

	}

	@GetMapping("/getDailyIncreaseDeathsDataByCounty")
	@Produces(MediaType.APPLICATION_JSON)
	public String getDailyIncreaseDeathsDataByCounty(@RequestParam String state, @RequestParam String county) {
		LOGGER.log(Level.DEBUG, "Getting daily increase US deaths data by state: " + state + " and county: " + county);
		long countyId = cachedLocations.getCountyIdByStateAndCounty(state, county);

		// returns a simple array of strings
		return convertToStringService.convertGenericObjectToJsonObject(chartsJsDataService.getChartsJsDataSingleDataSet(
				cachedCovidData.getDeathsCountyDataByCountyId(countyId), state, RequestType.DAILY_INCREASE,
				EntityType.DEATHS));

	}

	@PostMapping("/getUsCompareLocations")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public String getUsCompareLocations(@RequestBody CollectionUsStateAndCounty request) {

		RequestType requestType = convertStringToEnumTypeService.convertStringToRequestType(request.getRequestType());
		EntityType entityType = convertStringToEnumTypeService.convertStringToEntityType(request.getEntityType());
		UsStateAndCounty statesAndCounties[] = request.getStatesAndCounties();

		LOGGER.log(Level.DEBUG, "Getting compare data for US locations: " + statesAndCounties);

		// Get the raw data for each location
		ArrayList<LinkedHashMap<String, Integer>> locationsData = cachedCovidData
				.getDataForMultipleUsLocations(statesAndCounties, request.getLevel(), entityType);
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
