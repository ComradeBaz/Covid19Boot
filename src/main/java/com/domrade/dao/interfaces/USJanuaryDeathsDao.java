/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.domrade.dao.interfaces;

import java.util.List;

import org.springframework.stereotype.Service;

import com.domrade.entity.implementation.USJanuaryDeaths;

/**
 *
 * @author David
 */
@Service
public interface USJanuaryDeathsDao extends Dao<Long, USJanuaryDeaths> {

	public List<USJanuaryDeaths> findAllEntries();

	public USJanuaryDeaths getEntryByCountryRegion(String countryRegion);

	public USJanuaryDeaths findByCountryRegionProvinceState(String countryRegion, String provinceState);

}
