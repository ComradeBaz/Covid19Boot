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
public abstract class AbstractRequest {
    
    private String requestType;
    private String entityType;

    public AbstractRequest(String requestType, String entityType) {
        this.requestType = requestType;
        this.entityType = entityType;
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
