/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.domrade.chartjs.chart;

import com.domrade.chartjs.chart.data.ChartsJsDataSingleDataSet;
import com.domrade.chartjs.chart.options.ChartsJsOptions;
import java.util.List;

/**
 *
 * @author David
 */
public class ChartsJsChartWithOptionsSingleDataSet extends ChartsJsDataSingleDataSet {

    private ChartsJsOptions options;

    public ChartsJsChartWithOptionsSingleDataSet(ChartsJsOptions options, String[] chartLabels, List<Integer> data, String label) {
        super(chartLabels, data, label);
        this.options = options;
    }

    public ChartsJsOptions getOptions() {
        return options;
    }

    public void setOptions(ChartsJsOptions options) {
        this.options = options;
    }
    
}
