/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.domrade.rest.request;

import com.domrade.chartjs.chart.data.Location;

/**
 *
 * @author David
 */
public class RequestBodyLocations {
    
    private String locations;
    private String requestType;
    private String entityType;
    
    public RequestBodyLocations() {
        // no arg constructor
    }

    public RequestBodyLocations(String locations, String requestType, String entityType) {
        this.requestType = requestType;
        this.entityType = entityType;
        this.locations = locations;
    }

    public String getLocations() {
        return locations;
    }

    public void setLocations(String locations) {
        this.locations = locations;
    }

    public String getRequestType() {
        return requestType;
    }

    public void setRequestType(String requestType) {
        this.requestType = requestType;
    }

    public String getEntityType() {
        return entityType;
    }

    public void setEntityType(String entityType) {
        this.entityType = entityType;
    }
    
}
