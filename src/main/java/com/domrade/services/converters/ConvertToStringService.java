/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.domrade.services.converters;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.stereotype.Service;

import com.domrade.interfaces.converters.ConvertToStringServiceLocal;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 *
 * @author David
 */
@Service
public class ConvertToStringService implements ConvertToStringServiceLocal {

	private final ObjectMapper mapper = new ObjectMapper();

	// Data is retrieved from the dB by month
	// Monthly data is combined to one map
	// The data in the map is used to create a
	// com.domrade.json.helper.ChartsJsDataObject
	// That object is passed to this method to get the REST return string
	@Override
	public <T> String convertGenericObjectToJsonArray(T type) {
		// ObjectMapper mapper = new ObjectMapper();
		String jsonString = "No result";
		try {
			jsonString = "[" + mapper.writeValueAsString(type) + "]";
		} catch (JsonProcessingException ex) {
			Logger.getLogger(ConvertToStringService.class.getName()).log(Level.SEVERE, null, ex);
		}
		return jsonString;
	}

	@Override
	public <T> String convertGenericObjectToJsonObject(T type) {
		// ObjectMapper mapper = new ObjectMapper();
		String jsonString = "No result";
		try {
			jsonString = mapper.writeValueAsString(type);
		} catch (JsonProcessingException ex) {
			Logger.getLogger(ConvertToStringService.class.getName()).log(Level.SEVERE, null, ex);
		}
		return jsonString;
	}

	@Override
	public <T> String convertGenericObjectToString(T type) {
		String result = "";
		try {
			String temp = mapper.writeValueAsString(type);
			// remove the leading and trailing and
			result = temp.substring(1, temp.length() - 1);
		} catch (JsonProcessingException ex) {
			Logger.getLogger(ConvertToStringService.class.getName()).log(Level.SEVERE, null, ex);
		}
		return result;
	}

	@Override
	public String convertToJsonArray(List<String> listOfStrings) {
		String jsonString = "";
		try {
			jsonString = mapper.writeValueAsString(listOfStrings);
		} catch (JsonProcessingException ex) {
			Logger.getLogger(ConvertToStringService.class.getName()).log(Level.SEVERE, null, ex);
		}
		return jsonString;
	}

}
