/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.domrade.chartjs.chart.options.scales;

/**
 *
 * @author David
 */
public class XAxes {
    
    private Ticks ticks;

    public XAxes(Ticks ticks) {
        this.ticks = ticks;
    }

    public Ticks getTicks() {
        return ticks;
    }

    public void setTicks(Ticks ticks) {
        this.ticks = ticks;
    }

}
