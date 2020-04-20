/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.domrade.rest.request;

/**
 *
 * @author David
 */
public class RequestBody {
    
    private String countryRegion;
    private String provinceState;
    private String requestType;
    private String entityType;

    public RequestBody() {
        // no arg constructor
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
