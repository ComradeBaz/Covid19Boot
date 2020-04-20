/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.domrade.interfaces.converters;

import org.springframework.stereotype.Service;

import com.domrade.entity.EntityType;
import com.domrade.rest.request.RequestType;

/**
 *
 * @author David
 */
@Service
public interface ConvertStringToEnumTypeServiceLocal {

	public RequestType convertStringToRequestType(String requestType);

	public EntityType convertStringToEntityType(String entityType);

}
