/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.domrade.services.converters;

import org.springframework.stereotype.Service;

import com.domrade.entity.EntityType;
import com.domrade.interfaces.converters.ConvertStringToEnumTypeServiceLocal;
import com.domrade.rest.request.RequestType;

/**
 *
 * @author David
 */
@Service
public class ConvertStringToEnumTypeService implements ConvertStringToEnumTypeServiceLocal {

	@Override
	public RequestType convertStringToRequestType(String requestType) {
		RequestType returnType;

		switch (requestType) {
		case "rawData":
			return RequestType.RAW_DATA;
		case "dailyIncrease":
			return RequestType.DAILY_INCREASE;
		default:
			returnType = RequestType.RAW_DATA;
		}
		return returnType;
	}

	@Override
	public EntityType convertStringToEntityType(String entityType) {
		EntityType returnType;

		switch (entityType) {
		case "confirmed":
			return EntityType.CONFIRMED;
		case "deaths":
			return EntityType.DEATHS;
		default:
			returnType = EntityType.CONFIRMED;
		}
		return returnType;
	}

}
