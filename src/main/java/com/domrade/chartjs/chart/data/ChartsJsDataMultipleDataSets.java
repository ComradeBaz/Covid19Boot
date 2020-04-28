/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.domrade.chartjs.chart.data;

import java.util.ArrayList;

import com.domrade.chartjs.chart.data.datasets.AbstractChartsJsDataSet;
import com.domrade.chartjs.chart.data.datasets.ChartsJsDataSet;

/**
 *
 * @author David
 */
public class ChartsJsDataMultipleDataSets extends AbstractChartsJsDataSet {

	// datasets includes data array and the label for each array
	private ArrayList<ChartsJsDataSet> dataSets;
	private String[] chartLabels;

	public ChartsJsDataMultipleDataSets(ArrayList<ChartsJsDataSet> dataSets, String[] chartLabels) {
		this.dataSets = dataSets;
		this.chartLabels = chartLabels;
	}

	public ArrayList<ChartsJsDataSet> getDataSets() {
		return dataSets;
	}

	public void setDataSets(ArrayList<ChartsJsDataSet> dataSets) {
		this.dataSets = dataSets;
	}

	public String[] getChartLabels() {
		return chartLabels;
	}

	public void setChartLabels(String[] chartLabels) {
		this.chartLabels = chartLabels;
	}

}
