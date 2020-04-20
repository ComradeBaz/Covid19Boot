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
public class RequestBodyCombinedCountryAndState {
    
    private String combinedCountryAndState;
    private String requestType;
    private String entityType;

    public RequestBodyCombinedCountryAndState() {
        
    }

    public RequestBodyCombinedCountryAndState(String combinedCountryAndState, String requestType, String entityType) {
        this.combinedCountryAndState = combinedCountryAndState;
        this.requestType = requestType;
        this.entityType = entityType;
    }

    public String getCombinedCountryAndState() {
        return combinedCountryAndState;
    }

    public void setCombinedCountryAndState(String combinedCountryAndState) {
        this.combinedCountryAndState = combinedCountryAndState;
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
