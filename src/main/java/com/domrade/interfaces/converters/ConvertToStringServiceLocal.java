/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.domrade.interfaces.converters;

import java.util.List;

import org.springframework.stereotype.Service;

/**
 *
 * @author David
 */
@Service
public interface ConvertToStringServiceLocal {

	// public void convertObjectToJson(February february);

	public <T> String convertGenericObjectToJsonArray(T type);

	public <T> String convertGenericObjectToString(T type);

	public String convertToJsonArray(List<String> listOfStrings);

	public <T> String convertGenericObjectToJsonObject(T type);

}
