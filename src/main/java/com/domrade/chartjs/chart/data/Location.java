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
public class Location {
    
    private String countryRegion;
    private String provinceState;
    
    public Location() {
        // no arg constructor
    }

    public Location(String countryRegion, String provinceState) {
        this.countryRegion = countryRegion;
        this.provinceState = provinceState;
    }

    public String getCountryRegion() {
        return countryRegion;
    }

    public void setCountryRegion(String countryRegion) {
        this.countryRegion = countryRegion;
    }

    public String getProvinceState() {
        return provinceState;
    }

    public void setProvinceState(String provinceState) {
        this.provinceState = provinceState;
    }
}
