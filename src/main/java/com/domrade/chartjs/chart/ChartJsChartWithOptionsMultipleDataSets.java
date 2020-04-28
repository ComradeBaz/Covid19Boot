/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.domrade.chartjs.chart;

import java.util.ArrayList;

import com.domrade.chartjs.chart.data.ChartsJsDataMultipleDataSets;
import com.domrade.chartjs.chart.data.datasets.ChartsJsDataSet;
import com.domrade.chartjs.chart.options.ChartsJsOptions;

/**
 *
 * @author David
 */
public class ChartJsChartWithOptionsMultipleDataSets extends ChartsJsDataMultipleDataSets {

	private ChartsJsOptions options;

	public ChartJsChartWithOptionsMultipleDataSets(ChartsJsOptions options, ArrayList<ChartsJsDataSet> dataSets,
			String[] chartLabels) {
		super(dataSets, chartLabels);
		this.options = options;
	}

	public ChartsJsOptions getOptions() {
		return options;
	}

	public void setOptions(ChartsJsOptions options) {
		this.options = options;
	}

}
