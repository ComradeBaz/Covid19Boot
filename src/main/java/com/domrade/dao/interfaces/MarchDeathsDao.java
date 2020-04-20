/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.domrade.dao.interfaces;

import java.util.List;

import org.springframework.stereotype.Service;

import com.domrade.entity.implementation.MarchDeaths;

/**
 *
 * @author David
 */
@Service
public interface MarchDeathsDao extends Dao<Long, MarchDeaths> {

	public List<MarchDeaths> findAllEntries();

	public MarchDeaths getEntryByCountryRegion(String countryRegion);

	public MarchDeaths findByCountryRegionProvinceState(String countryRegion, String provinceState);

}
