/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.domrade.chartjs.chart.options;

import com.domrade.chartjs.chart.options.scales.Scales;

/**
 *
 * @author David
 */
public class ChartsJsOptions {
    
    private Scales scales;

    public ChartsJsOptions(Scales scales) {
        this.scales = scales;
    }

    public Scales getScales() {
        return scales;
    }

    public void setScales(Scales scales) {
        this.scales = scales;
    }
    
}
