/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.domrade.chartjs.chart;

import java.util.ArrayList;

import com.domrade.chartjs.chart.data.ChartsJsDataMultipleDataSets;
import com.domrade.chartjs.chart.data.datasets.ChartsJsDataSet;

/**
 *
 * @author David
 */
public class ChartsJsChartWithTypeMultipleDataSets extends ChartsJsDataMultipleDataSets {

	private String type;

	public ChartsJsChartWithTypeMultipleDataSets(String type, ArrayList<ChartsJsDataSet> dataSets,
			String[] chartLabels) {
		super(dataSets, chartLabels);
		this.type = type;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}
