/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.domrade.dao.interfaces;

import java.util.List;

import org.springframework.stereotype.Service;

import com.domrade.entity.implementation.January;

/**
 *
 * @author David
 */
@Service
public interface JanuaryDao {

	public List<January> findAllEntries();

	public January getEntryByCountryRegion(String countryRegion);

	public January findByCountryRegionProvinceState(String countryRegion, String provinceState);

}
