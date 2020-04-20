/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.domrade.chartjs.chart.data;

import com.domrade.chartjs.chart.data.datasets.AbstractChartsJsDataSet;
import java.util.ArrayList;

/**
 *
 * @author David
 */
public class ChartsJsDataMultipleDataSets extends AbstractChartsJsDataSet {
    
    // datasets includes data array and the label for each array
    private ArrayList<AbstractChartsJsDataSet> dataSets;
    private String[] chartLabels;

    public ChartsJsDataMultipleDataSets(ArrayList<AbstractChartsJsDataSet> dataSets, String[] chartLabels) {
        this.dataSets = dataSets;
        this.chartLabels = chartLabels;
    }

    public ArrayList<AbstractChartsJsDataSet> getDataSets() {
        return dataSets;
    }

    public void setDataSets(ArrayList<AbstractChartsJsDataSet> dataSets) {
        this.dataSets = dataSets;
    }

    public String[] getChartLabels() {
        return chartLabels;
    }

    public void setChartLabels(String[] chartLabels) {
        this.chartLabels = chartLabels;
    }

    
}
