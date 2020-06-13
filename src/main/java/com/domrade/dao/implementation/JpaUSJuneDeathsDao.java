/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.domrade.dao.implementation;

import java.util.List;

import org.springframework.stereotype.Service;

import com.domrade.dao.JpaDao;
import com.domrade.dao.interfaces.USJuneDeathsDao;
import com.domrade.entity.implementation.USJuneDeaths;

/**
 * 
 * @author David
 */
@Service
public class JpaUSJuneDeathsDao extends JpaDao<Long, USJuneDeaths> implements USJuneDeathsDao {

	public JpaUSJuneDeathsDao() {
		super(USJuneDeaths.class);
	}

	@Override
	public List<USJuneDeaths> findAllEntries() {
		return entityManager.createNamedQuery("USJuneDeaths.findAllEntries").getResultList();
	}

	@Override
	public USJuneDeaths getEntryByCountryRegion(String countryRegion) {
		return (USJuneDeaths) entityManager.createNamedQuery("USJuneDeaths.findByCountryRegion")
				.setParameter("countryRegion", countryRegion).getResultList().get(0);
	}

	@Override
	public USJuneDeaths findByCountryRegionProvinceState(String countryRegion, String provinceState) {
		return (USJuneDeaths) entityManager.createNamedQuery("USJuneDeaths.findByCountryRegionProvinceState")
				.setParameter("countryRegion", countryRegion).setParameter("provenceState", provinceState)
				.getResultList().get(0);
	}

	@Override
	public List<USJuneDeaths> getEntryByProvenceState(String provenceState) {
		return entityManager.createNamedQuery("USJuneDeaths.findByProvenceState")
				.setParameter("provenceState", provenceState).getResultList();
	}

}
