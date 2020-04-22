/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.domrade.dao.interfaces;

import java.util.List;

import org.springframework.stereotype.Service;

import com.domrade.entity.implementation.USJanuary;

/**
 *
 * @author David
 */
@Service
public interface USJanuaryDao {

	public List<USJanuary> findAllEntries();

	public USJanuary getEntryByCountryRegion(String countryRegion);

	public USJanuary findByCountryRegionProvinceState(String countryRegion, String provinceState);

}
