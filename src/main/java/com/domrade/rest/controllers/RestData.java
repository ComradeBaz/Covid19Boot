/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.domrade.rest.controllers;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.domrade.chartjs.chart.data.LocationCombinedCountryAndState;
import com.domrade.entity.EntityType;
import com.domrade.entity.implementation.March;
import com.domrade.interfaces.charts.ChartsJsDataServiceLocal;
import com.domrade.interfaces.converters.ConvertStringToEnumTypeServiceLocal;
import com.domrade.interfaces.converters.ConvertToObjectServiceLocal;
import com.domrade.interfaces.converters.ConvertToStringServiceLocal;
import com.domrade.interfaces.data.FormatDataServiceLocal;
import com.domrade.interfaces.local.CachedDataLocal;
import com.domrade.interfaces.months.confirmed.FebruaryServiceLocal;
import com.domrade.interfaces.months.confirmed.MarchServiceLocal;
import com.domrade.rest.request.RequestBodyCombinedCountryAndState;
import com.domrade.rest.request.RequestType;

/**
 *
 * @author David
 */
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class RestData {

	@Autowired
	private ConvertToStringServiceLocal convertToStringService;

	@Autowired
	private ConvertToObjectServiceLocal convertToObjectService;

	@Autowired
	private FebruaryServiceLocal februaryService;

	@Autowired
	private CachedDataLocal cachedData;

	@Autowired
	private MarchServiceLocal marchService;

	@Autowired
	private FormatDataServiceLocal formatDataService;

	@Autowired
	private ChartsJsDataServiceLocal chartsJsDataService;

	@Autowired
	private ConvertStringToEnumTypeServiceLocal convertStringToEnumTypeService;

	@GetMapping("/getCountries")
	@Produces(MediaType.APPLICATION_JSON)
	public String getCountries() {
		List<String> allCountries = februaryService.getAllCountries();

		// returns a simple array of strings
		return convertToStringService.convertToJsonArray(allCountries);
	}

	@GetMapping("/getLocations")
	@Produces(MediaType.APPLICATION_JSON)
	public String getLocations() {

		// returns a simple array of strings
		return convertToStringService.convertToJsonArray(cachedData.getLocations());
	}

	@POST
	@Path("/getProvinceStateByCountry")
	@Consumes(MediaType.TEXT_PLAIN)
	@Produces(MediaType.APPLICATION_JSON)
	public String getProvinceStateByCountry(String country) {

		List<String> provinceState = februaryService.getProvinceStateByCountryRegion(country);

		// returns a simple array of strings
		return convertToStringService.convertToJsonArray(provinceState);
	}

	// Returns one data set
	@GetMapping("/deaths/getDataByCountry")
	@Produces(MediaType.APPLICATION_JSON)
	public String getDeathsDataSet(@RequestParam String country) {

		formatDataService.formatDataForLocation(country, EntityType.DEATHS);

		// returns a json object representing chart data
		return convertToStringService.convertGenericObjectToJsonObject(chartsJsDataService.getChartsJsDataSingleDataSet(
				formatDataService.formatDataForCountryAndState(country, "", EntityType.CONFIRMED), country,
				RequestType.RAW_DATA, EntityType.CONFIRMED));
	}

	// Returns one data set
	@GetMapping("/confirmed/getDataByCountry")
	@Produces(MediaType.APPLICATION_JSON)
	public String getConfirmedDataSet(@RequestParam String country) {

		formatDataService.formatDataForLocation(country, EntityType.CONFIRMED);

		// returns a json object representing chart data
		return convertToStringService.convertGenericObjectToJsonObject(chartsJsDataService.getChartsJsDataSingleDataSet(
				formatDataService.formatDataForCountryAndState(country, "", EntityType.CONFIRMED), country,
				RequestType.RAW_DATA, EntityType.CONFIRMED));
	}

	@PostMapping("/getCompareLocations")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public String getCompareLocations(@RequestBody RequestBodyCombinedCountryAndState request) {

		RequestType requestType = convertStringToEnumTypeService.convertStringToRequestType(request.getRequestType());
		EntityType entityType = convertStringToEnumTypeService.convertStringToEntityType(request.getEntityType());
		String locations = request.getCombinedCountryAndState();
		LocationCombinedCountryAndState[] locationArray = convertToObjectService
				.jsonStringToArrayCombinedLocation(locations);

		// Get the raw data for each location
		ArrayList<LinkedHashMap<String, Integer>> locationsData = formatDataService
				.formatDataForMultipleLocations(locationArray, entityType);
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

	@PostMapping("/getDataByCountryAndProvince")
	@Consumes(MediaType.TEXT_PLAIN)
	@Produces(MediaType.APPLICATION_JSON)
	public String getDataByCountryAndProvince(@RequestParam String request) {

		RequestBodyCombinedCountryAndState requestBody = convertToObjectService
				.getRequestBodyWithCombinedCountryAndState(request);
		RequestType requestType = convertStringToEnumTypeService
				.convertStringToRequestType(requestBody.getRequestType());
		EntityType entityType = convertStringToEnumTypeService.convertStringToEntityType(requestBody.getEntityType());
		String location = requestBody.getCombinedCountryAndState();
		// String provinceState = requestBody.getProvinceState();

		// returns a json object representing chart data
		return convertToStringService.convertGenericObjectToJsonObject(chartsJsDataService.getChartsJsDataSingleDataSet(
				formatDataService.formatDataForLocation(location, entityType), location, requestType, entityType));

	}

	// get chart object
	@PostMapping("/getChartByCountryAndProvince")
	@Consumes(MediaType.TEXT_PLAIN)
	@Produces(MediaType.APPLICATION_JSON)
	public String getChartByCountryAndProvince(@RequestBody String request) {

		RequestBodyCombinedCountryAndState requestBody = convertToObjectService
				.getRequestBodyWithCombinedCountryAndState(request);
		RequestType requestType = convertStringToEnumTypeService
				.convertStringToRequestType(requestBody.getRequestType());
		EntityType entityType = convertStringToEnumTypeService.convertStringToEntityType(requestBody.getEntityType());
		String location = requestBody.getCombinedCountryAndState();

		// returns a json object representing chart data
		return convertToStringService.convertGenericObjectToJsonObject(chartsJsDataService.getChartsJsDataSingleDataSet(
				formatDataService.formatDataForLocation(location, entityType), location, requestType, entityType));

	}

	@Path("getDailyIncreaseByCountryProvince/{country}/{province}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String getDailyIncreaseTwoParams(@PathParam("country") String country,
			@PathParam("province") String province) {

		// returns a json object representing chart data
		return convertToStringService.convertGenericObjectToJsonArray(chartsJsDataService.getChartsJsDataSingleDataSet(
				formatDataService.formatDataForCountryAndState(country, province, EntityType.CONFIRMED), country,
				RequestType.DAILY_INCREASE, EntityType.CONFIRMED));

	}

	// Get two data sets for charts that display two data sets, eg confirmed cases
	// per day and new cases per day
	@GET
	@Path("getConfirmedCasesAndDailyIncrease/{country}")
	@Produces(MediaType.APPLICATION_JSON)
	public String getTwoDataSets(@PathParam("country") String country) {

		// returns a json object representing data for more than one chart
		// eg data for confirmed cases and new cases that can be displayed in one chart
		return convertToStringService
				.convertGenericObjectToJsonArray(chartsJsDataService.getChartsJsDataObjectsConfirmedAndDailyIncrease(
						formatDataService.formatDataForCountryAndState(country, "", EntityType.CONFIRMED), country));
	}

	@GET
	@Path("getChartLabels")
	@Produces(MediaType.APPLICATION_JSON)
	public String getChartLabels() {
		March entryTwo = marchService.getMarchEntryByCountryRegion("Italy");
		LinkedHashMap<String, Integer> data = formatDataService.removeLocationDetails(entryTwo);
		String[] chartsJsLabels = chartsJsDataService.getChartsJsLabels(data);

		// returns just the labels for a chart
		return convertToStringService.convertGenericObjectToJsonArray(chartsJsLabels);
	}
}
