/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.domrade.dao.interfaces;

import java.util.List;

import org.springframework.stereotype.Service;

import com.domrade.entity.implementation.JanuaryDeaths;

/**
 *
 * @author David
 */
@Service
public interface JanuaryDeathsDao extends Dao<Long, JanuaryDeaths> {

	public List<JanuaryDeaths> findAllEntries();

	public JanuaryDeaths getEntryByCountryRegion(String countryRegion);

	public JanuaryDeaths findByCountryRegionProvinceState(String countryRegion, String provinceState);

}
