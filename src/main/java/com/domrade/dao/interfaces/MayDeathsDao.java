/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.domrade.dao.interfaces;

import java.util.List;

import org.springframework.stereotype.Service;

import com.domrade.entity.implementation.MayDeaths;

/**
 *
 * @author David
 */
@Service
public interface MayDeathsDao extends Dao<Long, MayDeaths> {

	public List<MayDeaths> findAllEntries();

	public MayDeaths getEntryByCountryRegion(String countryRegion);

	public MayDeaths findByCountryRegionProvinceState(String countryRegion, String provinceState);

}
