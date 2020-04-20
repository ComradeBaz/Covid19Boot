/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.domrade.dao.interfaces;

import java.util.List;

import org.springframework.stereotype.Service;

import com.domrade.entity.implementation.February;

/**
 *
 * @author David
 */
@Service
public interface FebruaryDao extends Dao<Long, February> {

	public List<February> findAllEntries();

	public February findByCountryRegionProvinceState(String countryRegion, String provinceState);

	public February getEntryByCountryRegion(String countryRegion);

	public List<String> getAllFebruaryCountries();

	public List<String> getProvinceStateByCountryRegion(String countryRegion);

	public List<String> getAllFebruaryCountryRegionProvinceState();
}
