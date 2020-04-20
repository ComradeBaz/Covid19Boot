/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.domrade.dao.implementation;

import java.util.List;

import org.springframework.stereotype.Service;

import com.domrade.dao.JpaDao;
import com.domrade.dao.interfaces.FebruaryDeathsDao;
import com.domrade.entity.implementation.FebruaryDeaths;

/**
 *
 * @author David
 */
@Service
public class JpaFebruaryDeathsDao extends JpaDao<Long, FebruaryDeaths> implements FebruaryDeathsDao {

	public JpaFebruaryDeathsDao() {
		super(FebruaryDeaths.class);
	}

	@Override
	public List<FebruaryDeaths> findAllEntries() {
		return entityManager.createNamedQuery("FebruaryDeaths.findAllEntries").getResultList();
	}

	@Override
	public FebruaryDeaths getEntryByCountryRegion(String countryRegion) {
		return (FebruaryDeaths) entityManager.createNamedQuery("FebruaryDeaths.findByCountryRegion")
				.setParameter("countryRegion", countryRegion).getResultList().get(0);
	}

	@Override
	public List<String> getAllFebruaryDeathsCountries() {
		return entityManager.createNamedQuery("FebruaryDeaths.findAllCountryRegion").getResultList();
	}

	@Override
	public List<String> getProvinceStateByCountryRegion(String countryRegion) {
		return entityManager.createNamedQuery("FebruaryDeaths.findProvinceStateByCountryRegion")
				.setParameter("countryRegion", countryRegion).getResultList();
	}

	@Override
	public FebruaryDeaths findByCountryRegionProvinceState(String countryRegion, String provinceState) {
		return (FebruaryDeaths) entityManager.createNamedQuery("FebruaryDeaths.findByCountryRegionProvinceState")
				.setParameter("countryRegion", countryRegion).setParameter("provenceState", provinceState)
				.getResultList().get(0);
	}

}
