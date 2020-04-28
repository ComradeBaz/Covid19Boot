/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.domrade.interfaces.data;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.domrade.chartjs.chart.data.LocationCombinedCountryAndState;
import com.domrade.chartjs.chart.data.datasets.ChartsJsDataSet;
import com.domrade.rest.request.UsStateAndCounty;

/**
 *
 * @author David
 */
@Service
public interface DataProcessingServiceLocal {

	// public LinkedHashMap<String, Integer> calculateDailyIncrease(Map type);

	public <T> ArrayList<Integer> calculateDailyIncrease(T type);

	public <T> ArrayList<Float> calculateDailyIncreasePercentage(T type);

	public ArrayList<ChartsJsDataSet> getOriginalOrder(ArrayList<ChartsJsDataSet> arrayList,
			LocationCombinedCountryAndState[] locationArray);

	public ArrayList<ChartsJsDataSet> getOriginalOrderForUsLocations(ArrayList<ChartsJsDataSet> arrayList,
			UsStateAndCounty[] locationArray);

}
