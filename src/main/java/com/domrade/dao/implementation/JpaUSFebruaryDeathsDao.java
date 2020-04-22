/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.domrade.dao.implementation;

import java.util.List;

import org.springframework.stereotype.Service;

import com.domrade.dao.JpaDao;
import com.domrade.dao.interfaces.USFebruaryDeathsDao;
import com.domrade.entity.implementation.USFebruaryDeaths;

/**
 *
 * @author David
 */
@Service
public class JpaUSFebruaryDeathsDao extends JpaDao<Long, USFebruaryDeaths> implements USFebruaryDeathsDao {

	public JpaUSFebruaryDeathsDao() {
		super(USFebruaryDeaths.class);
	}

	@Override
	public List<USFebruaryDeaths> findAllEntries() {
		return entityManager.createNamedQuery("USFebruaryDeaths.findAllEntries").getResultList();
	}

	@Override
	public USFebruaryDeaths getEntryByCountryRegion(String countryRegion) {
		return (USFebruaryDeaths) entityManager.createNamedQuery("USFebruaryDeaths.findByCountryRegion")
				.setParameter("countryRegion", countryRegion).getResultList().get(0);
	}

	@Override
	public List<String> getAllUSFebruaryDeathsCountries() {
		return entityManager.createNamedQuery("USFebruaryDeaths.findAllCountryRegion").getResultList();
	}

	@Override
	public List<String> getProvinceStateByCountryRegion(String countryRegion) {
		return entityManager.createNamedQuery("USFebruaryDeaths.findProvinceStateByCountryRegion")
				.setParameter("countryRegion", countryRegion).getResultList();
	}

	@Override
	public USFebruaryDeaths findByCountryRegionProvinceState(String countryRegion, String provinceState) {
		return (USFebruaryDeaths) entityManager.createNamedQuery("USFebruaryDeaths.findByCountryRegionProvinceState")
				.setParameter("countryRegion", countryRegion).setParameter("provenceState", provinceState)
				.getResultList().get(0);
	}

}
