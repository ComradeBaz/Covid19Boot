/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.domrade.dao.interfaces;

import java.util.List;

import org.springframework.stereotype.Service;

import com.domrade.entity.implementation.JuneDeaths;

/**
 *
 * @author David
 */
@Service
public interface JuneDeathsDao extends Dao<Long, JuneDeaths> {

	public List<JuneDeaths> findAllEntries();

	public JuneDeaths getEntryByCountryRegion(String countryRegion);

	public JuneDeaths findByCountryRegionProvinceState(String countryRegion, String provinceState);

}
