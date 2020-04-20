/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.domrade.interfaces.converters;

import org.springframework.stereotype.Service;

import com.domrade.chartjs.chart.data.Location;
import com.domrade.chartjs.chart.data.LocationCombinedCountryAndState;
import com.domrade.rest.request.RequestBody;
import com.domrade.rest.request.RequestBodyCombinedCountryAndState;
import com.domrade.rest.request.RequestBodyLocations;

/**
 *
 * @author David
 */
@Service
public interface ConvertToObjectServiceLocal {

	public RequestBody getRequestBody(String requestBodyString);

	public Location[] jsonStringToArray(String jsonStringLocations);

	public RequestBodyLocations getRequestBodyWithLocations(String requestBodyString);

	public RequestBodyCombinedCountryAndState getRequestBodyWithCombinedCountryAndState(String requestBodyString);

	public LocationCombinedCountryAndState[] jsonStringToArrayCombinedLocation(String jsonStringLocations);
}
