/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.domrade.chartjs.chart;

import com.domrade.chartjs.chart.data.ChartsJsDataMultipleDataSets;
import com.domrade.chartjs.chart.options.ChartsJsOptions;
import com.domrade.chartjs.chart.data.datasets.AbstractChartsJsDataSet;
import com.domrade.chartjs.chart.data.datasets.ChartsJsDataSet;
import java.util.ArrayList;

/**
 *
 * @author David
 */
public class ChartJsChartWithOptionsMultipleDataSets extends ChartsJsDataMultipleDataSets {
    
    private ChartsJsOptions options;

    public ChartJsChartWithOptionsMultipleDataSets(ChartsJsOptions options, ArrayList<AbstractChartsJsDataSet> dataSets, String[] chartLabels) {
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
