/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.domrade.services.converters;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.stereotype.Service;

import com.domrade.chartjs.chart.data.Location;
import com.domrade.chartjs.chart.data.LocationCombinedCountryAndState;
import com.domrade.interfaces.converters.ConvertToObjectServiceLocal;
import com.domrade.rest.request.RequestBody;
import com.domrade.rest.request.RequestBodyCombinedCountryAndState;
import com.domrade.rest.request.RequestBodyLocations;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 *
 * @author David
 */
@Service
public class ConvertToObjectService implements ConvertToObjectServiceLocal {

	private final ObjectMapper mapper = new ObjectMapper();

	// Get the list of countries submitted by the client when
	// client is constructing a chart with multiple locations
	@Override
	public Location[] jsonStringToArray(String jsonStringLocations) {

		Location[] locations = null;
		try {
			locations = mapper.readValue(jsonStringLocations, Location[].class);
			for (Location l : locations) {
				System.out
						.println("countryRegion: " + l.getCountryRegion() + " provinceState: " + l.getProvinceState());
			}
		} catch (IOException ex) {
			Logger.getLogger(ConvertToStringService.class.getName()).log(Level.SEVERE, null, ex);
		}

		return locations;
	}

	// Get the list of countries submitted by the client when
	// client is constructing a chart with multiple locations
	@Override
	public LocationCombinedCountryAndState[] jsonStringToArrayCombinedLocation(String jsonStringLocations) {

		LocationCombinedCountryAndState[] locations = null;
		try {
			locations = mapper.readValue(jsonStringLocations, LocationCombinedCountryAndState[].class);
			for (LocationCombinedCountryAndState l : locations) {
				System.out.println("location: " + l.getCombinedCountryAndState());
			}
		} catch (IOException ex) {
			Logger.getLogger(ConvertToStringService.class.getName()).log(Level.SEVERE, null, ex);
		}

		return locations;
	}

	@Override
	public RequestBody getRequestBody(String requestBodyString) {
		RequestBody requestBody = null;
		try {
			requestBody = mapper.readValue(requestBodyString, RequestBody.class);
		} catch (IOException ex) {
			Logger.getLogger(ConvertToStringService.class.getName()).log(Level.SEVERE, null, ex);
		}

		return requestBody;
	}

	@Override
	public RequestBodyLocations getRequestBodyWithLocations(String requestBodyString) {
		RequestBodyLocations requestBody = null;
		try {
			requestBody = mapper.readValue(requestBodyString, RequestBodyLocations.class);
		} catch (IOException ex) {
			Logger.getLogger(ConvertToStringService.class.getName()).log(Level.SEVERE, null, ex);
		}

		return requestBody;
	}

	@Override
	public RequestBodyCombinedCountryAndState getRequestBodyWithCombinedCountryAndState(String requestBodyString) {
		RequestBodyCombinedCountryAndState requestBody = null;
		try {
			requestBody = mapper.readValue(requestBodyString, RequestBodyCombinedCountryAndState.class);
		} catch (IOException ex) {
			Logger.getLogger(ConvertToStringService.class.getName()).log(Level.SEVERE, null, ex);
		}

		return requestBody;
	}

}
