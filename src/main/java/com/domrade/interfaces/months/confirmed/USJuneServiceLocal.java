/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.domrade.interfaces.months.confirmed;

import java.util.List;

import org.springframework.stereotype.Service;

import com.domrade.entity.implementation.USJune;

/**
 *
 * @author David
 */
@Service
public interface USJuneServiceLocal {

	public List<USJune> getAllUSJuneEntries();

	public USJune getUSJuneEntryByCountryRegion(String countryRegion);

	public USJune findByCountryRegionProvinceState(String countryRegion, String provinceState);

	public List<USJune> getEntryByProvenceState(String provenceState);
}
