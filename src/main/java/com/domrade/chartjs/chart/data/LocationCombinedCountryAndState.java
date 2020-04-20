/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.domrade.chartjs.chart.data;

/**
 *
 * @author David
 */
public class LocationCombinedCountryAndState {
    
    private String combinedCountryAndState;
    
    public LocationCombinedCountryAndState() {
        // no arg constructor
    }

    public LocationCombinedCountryAndState(String combinedCountryAndState) {
        this.combinedCountryAndState = combinedCountryAndState;
    }

    public String getCombinedCountryAndState() {
        return combinedCountryAndState;
    }

    public void setCombinedCountryAndState(String combinedCountryAndState) {
        this.combinedCountryAndState = combinedCountryAndState;
    }
    
}
