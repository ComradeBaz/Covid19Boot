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

import com.domrade.chartjs.chart.data.LocationCombinedCountryAndState;
import com.domrade.entity.EntityType;
import com.domrade.interfaces.cache.CachedLocationsLocal;
import com.domrade.interfaces.charts.ChartsJsDataServiceLocal;
import com.domrade.interfaces.converters.ConvertStringToEnumTypeServiceLocal;
import com.domrade.interfaces.converters.ConvertToObjectServiceLocal;
import com.domrade.interfaces.converters.ConvertToStringServiceLocal;
import com.domrade.interfaces.data.FormatDataServiceLocal;
import com.domrade.interfaces.local.CachedCovidDataLocal;
import com.domrade.rest.request.RequestBodyCombinedCountryAndState;
import com.domrade.rest.request.RequestType;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class GlobalRestData {

	private final static Logger LOGGER = Logger.getLogger(GlobalRestData.class);

	@Autowired
	private ConvertToStringServiceLocal convertToStringService;

	@Autowired
	private ConvertToObjectServiceLocal convertToObjectService;

	@Autowired
	private FormatDataServiceLocal formatDataService;

	@Autowired
	private ChartsJsDataServiceLocal chartsJsDataService;

	@Autowired
	private ConvertStringToEnumTypeServiceLocal convertStringToEnumTypeService;

	@Autowired
	private CachedLocationsLocal cachedLocations;

	@Autowired
	private CachedCovidDataLocal cachedCovidData;

	public GlobalRestData() {
		// TODO Auto-generated constructor stub
	}

	// Get the global locations - user picks from this list to get data relevant to
	// that location
	@GetMapping("/getGlobalLocations")
	@Produces(MediaType.APPLICATION_JSON)
	public String getLocations() {
		LOGGER.log(Level.DEBUG, "Getting global locations");
		// returns a simple array of strings
		return convertToStringService.convertToJsonArray(cachedLocations.getGlobalLocations());
	}

	// Get the number of confirmed cases by global location
	@GetMapping("/getConfirmedDataByGlobalLocation")
	@Produces(MediaType.APPLICATION_JSON)
	public String getConfirmedDataByState(@RequestParam String location) {
		LOGGER.log(Level.DEBUG, "Getting confirmed global data by location: " + location);
		return convertToStringService.convertGenericObjectToJsonObject(chartsJsDataService.getChartsJsDataSingleDataSet(
				cachedCovidData.getConfirmedGlobalDataByLocation(location), location, RequestType.RAW_DATA,
				EntityType.CONFIRMED));

	}

	// Get the number of deaths by global location
	@GetMapping("/getDeathsDataByGlobalLocation")
	@Produces(MediaType.APPLICATION_JSON)
	public String getDeathsDataByState(@RequestParam String location) {
		LOGGER.log(Level.DEBUG, "Getting deaths global data by location: " + location);
		// returns a simple array of strings
		return convertToStringService.convertGenericObjectToJsonObject(chartsJsDataService.getChartsJsDataSingleDataSet(
				cachedCovidData.getConfirmedGlobalDeathsDataByLocation(location), location, RequestType.RAW_DATA,
				EntityType.DEATHS));

	}

	// Get the daily increase in confirmed cases by global location
	@GetMapping("/getDailyIncreaseConfirmedDataByGlobalLocation")
	@Produces(MediaType.APPLICATION_JSON)
	public String getDailyIncreaseConfirmedDataByState(@RequestParam String location) {
		LOGGER.log(Level.DEBUG, "Getting daily increase confirmed global data by location: " + location);
		return convertToStringService.convertGenericObjectToJsonObject(chartsJsDataService.getChartsJsDataSingleDataSet(
				cachedCovidData.getConfirmedGlobalDataByLocation(location), location, RequestType.DAILY_INCREASE,
				EntityType.CONFIRMED));

	}

	// Get the daily increase in deaths by global location
	@GetMapping("/getDailyIncreaseDeathsDataByGlobalLocation")
	@Produces(MediaType.APPLICATION_JSON)
	public String getDailyIncreaseDeathsDataByState(@RequestParam String location) {
		LOGGER.log(Level.DEBUG, "Getting daily increase deaths global data by location: " + location);
		// returns a simple array of strings
		return convertToStringService.convertGenericObjectToJsonObject(chartsJsDataService.getChartsJsDataSingleDataSet(
				cachedCovidData.getConfirmedGlobalDeathsDataByLocation(location), location, RequestType.DAILY_INCREASE,
				EntityType.DEATHS));

	}

	// Get a chart with more that one location
	@PostMapping("/getCompareGlobalLocations")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public String getCompareLocations(@RequestBody RequestBodyCombinedCountryAndState request) {

		RequestType requestType = convertStringToEnumTypeService.convertStringToRequestType(request.getRequestType());
		EntityType entityType = convertStringToEnumTypeService.convertStringToEntityType(request.getEntityType());
		String locations = request.getCombinedCountryAndState();
		LocationCombinedCountryAndState[] locationArray = convertToObjectService
				.jsonStringToArrayCombinedLocation(locations);

		LOGGER.log(Level.DEBUG, "Getting compare data for global locations: " + locations);

		// Get the raw data for each location
		ArrayList<LinkedHashMap<String, Integer>> locationsData = cachedCovidData
				.getDataForMultipleGlobalLocations(locationArray, entityType);
		// Get index of longest map
		int indexOfLongestMap = formatDataService.getIndexOfLongestMap(locationsData);
		LocationCombinedCountryAndState[] reorderedLocation = formatDataService
				.getReorderedListOfLocations(locationArray, indexOfLongestMap);
		// Standardise the data by making the data sets for each country the same lenght
		ArrayList<LinkedHashMap<String, Integer>> listOfCountries = formatDataService
				.formatDataForListOfCountriesDataSet(locationsData, indexOfLongestMap);

		// returns a json object representing chart data
		return convertToStringService.convertGenericObjectToJsonArray(chartsJsDataService
				.getChartsJsDataForLocations(listOfCountries, reorderedLocation, requestType, locationArray));
	}

}
