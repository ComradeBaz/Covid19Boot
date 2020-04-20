/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.domrade.chartjs.chart.data;

import com.domrade.chartjs.chart.data.datasets.ChartsJsDataSet;
import java.util.List;

/**
 *
 * @author David
 */
public class ChartsJsDataSingleDataSet extends ChartsJsDataSet {
    
    //private AbstractChartsJsDataSet dataSet;
    private String[]chartLabels;

    public ChartsJsDataSingleDataSet(String[] chartLabels, List<Integer> data, String label) {
        super(data, label);
        this.chartLabels = chartLabels;
    }

    /*public AbstractChartsJsDataSet getDataSet() {
    return dataSet;
    }
    public void setDataSet(AbstractChartsJsDataSet dataSet) {
    this.dataSet = dataSet;
    }*/

    public String[] getChartLabels() {
        return chartLabels;
    }

    public void setChartLabels(String[] chartLabels) {
        this.chartLabels = chartLabels;
    }
 
}
