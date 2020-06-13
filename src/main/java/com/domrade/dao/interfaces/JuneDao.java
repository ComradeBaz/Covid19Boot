/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.domrade.dao.interfaces;

import java.util.List;

import org.springframework.stereotype.Service;

import com.domrade.entity.implementation.June;

/**
 *
 * @author David
 */
@Service
public interface JuneDao extends Dao<Long, June> {

	public List<June> findAllEntries();

	public June getEntryByCountryRegion(String countryRegion);

	public June findByCountryRegionProvinceState(String countryRegion, String provinceState);

}
