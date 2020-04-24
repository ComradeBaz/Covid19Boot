/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.domrade.interfaces.charts;

import java.util.ArrayList;
import java.util.LinkedHashMap;

import org.springframework.stereotype.Service;

import com.domrade.chartjs.chart.ChartsJsChartWithOptionsSingleDataSet;
import com.domrade.chartjs.chart.data.ChartsJsDataMultipleDataSets;
import com.domrade.chartjs.chart.data.ChartsJsDataSingleDataSet;
import com.domrade.chartjs.chart.data.Location;
import com.domrade.chartjs.chart.data.LocationCombinedCountryAndState;
import com.domrade.entity.EntityType;
import com.domrade.rest.request.RequestType;
import com.domrade.rest.request.UsStateAndCounty;

/**
 *
 * @author David
 */
@Service
public interface ChartsJsDataServiceLocal {

	// type is a com.domrade.entity.Month object
	public <T> ChartsJsDataSingleDataSet getChartsJsDataSingleDataSet(T type, String label, RequestType requestType,
			EntityType entityType);

	// get labels for the chart
	public <T> String[] getChartsJsLabels(T type);

	// get more than one data set for a chart
	public <T> ChartsJsDataMultipleDataSets getChartsJsDataForMoreThanOneLocation(
			ArrayList<LinkedHashMap<String, Integer>> listOfCountries, Location[] locations, RequestType requestType);

	// get total confirmed and daily increase in one chart
	public <T> ChartsJsDataMultipleDataSets getChartsJsDataObjectsConfirmedAndDailyIncrease(T type, String label);

	// get a chart with options set
	public <T> ChartsJsChartWithOptionsSingleDataSet getChartsJsDataObjectWithOptions(T type, String label,
			RequestType requestType);

	// get the chart label - type of data being displayed, eg Total Confirmed, Total
	// Deaths, Confirmed - Daily Increase, Deaths - Daily Increase
	public String getChartLabel(RequestType requestType, EntityType entityType);

	public <T> ChartsJsDataMultipleDataSets getChartsJsDataForLocations(
			ArrayList<LinkedHashMap<String, Integer>> listOfCountries, LocationCombinedCountryAndState[] locations,
			RequestType requestType);

	public <T> ChartsJsDataMultipleDataSets getChartsJsDataForUsLocations(
			ArrayList<LinkedHashMap<String, Integer>> listOfCountries, UsStateAndCounty[] locations,
			RequestType requestType);
}
