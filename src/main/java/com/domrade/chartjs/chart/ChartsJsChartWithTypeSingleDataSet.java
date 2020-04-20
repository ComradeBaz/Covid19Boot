/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.domrade.chartjs.chart;

import com.domrade.chartjs.chart.data.ChartsJsDataSingleDataSet;
import java.util.List;

/**
 *
 * @author David
 */
public class ChartsJsChartWithTypeSingleDataSet extends ChartsJsDataSingleDataSet {
    
    // type is the type of chart - usually line or bar
    private String type;

    public ChartsJsChartWithTypeSingleDataSet(String type, String[] chartLabels, List<Integer> data, String label) {
        super(chartLabels, data, label);
        this.type = type;
    }
    
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
