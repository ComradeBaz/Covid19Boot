/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.domrade.dao.interfaces;

import java.util.List;

import org.springframework.stereotype.Service;

import com.domrade.entity.implementation.March;

/**
 *
 * @author David
 */
@Service
public interface MarchDao extends Dao<Long, March> {

	public List<March> findAllEntries();

	public March getEntryByCountryRegion(String countryRegion);

	public March findByCountryRegionProvinceState(String countryRegion, String provinceState);

}
