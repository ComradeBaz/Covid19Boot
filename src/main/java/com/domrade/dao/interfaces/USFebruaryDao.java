/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.domrade.dao.interfaces;

import java.util.List;

import org.springframework.stereotype.Service;

import com.domrade.entity.implementation.USFebruary;

/**
 *
 * @author David
 */
@Service
public interface USFebruaryDao extends Dao<Long, USFebruary> {

	public List<USFebruary> findAllEntries();

	public USFebruary findByCountryRegionProvinceState(String countryRegion, String provinceState);

	public USFebruary getEntryByCountryRegion(String countryRegion);

	public List<String> getAllUSFebruaryCountries();

	public List<String> getProvinceStateByCountryRegion(String countryRegion);

	public List<String> getAllUSFebruaryCountryRegionProvinceState();

	public List<USFebruary> getEntryByProvenceState(String provenceState);
}
