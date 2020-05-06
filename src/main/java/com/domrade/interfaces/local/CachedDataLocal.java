/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.domrade.interfaces.local;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

/**
 *
 * @author David
 */
@Service
public interface CachedDataLocal {

	public void updateCache();

	public List<String> getLocations();

	public List<String> getFileNames();

	public void setAllFileNames(List<String> allFileNames);

	public String getFileLocation();

	public void setFileLocation(String fileLocation);

	public List<String> getFebruary();

	public void setFebruary(List<String> february);

	public List<String> getMarch();

	public void setMarch(List<String> march);

	public List<String> getApril();

	public void setApril(List<String> april);

	public List<String> getMay();

	public void setMay(List<String> may);

	public List<String> getJanuary();

	public void setJanuary(List<String> january);

	public boolean isFebruaryData();

	public boolean isMarchData();

	public boolean isAprilData();

	public boolean isMayData();

	public boolean isJanuaryData();

	public List<String> getAllCountries();

	public List<String> getUsStates();

	public String getCountyIdByStateAndCounty(String state, String county);

	public ArrayList<String> getCountiesByState(String state);

}
