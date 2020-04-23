/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.domrade.dao.implementation;

import java.util.List;

import org.springframework.stereotype.Service;

import com.domrade.dao.JpaDao;
import com.domrade.dao.interfaces.USJanuaryDeathsDao;
import com.domrade.entity.implementation.USJanuaryDeaths;

/**
 *
 * @author David
 */
@Service
public class JpaUSJanuaryDeathsDao extends JpaDao<Long, USJanuaryDeaths> implements USJanuaryDeathsDao {

	public JpaUSJanuaryDeathsDao() {
		super(USJanuaryDeaths.class);
	}

	@Override
	public List<USJanuaryDeaths> findAllEntries() {
		return entityManager.createNamedQuery("USJanuaryDeaths.findAllEntries").getResultList();
	}

	@Override
	public USJanuaryDeaths getEntryByCountryRegion(String countryRegion) {
		return (USJanuaryDeaths) entityManager.createNamedQuery("USJanuaryDeaths.findByCountryRegion")
				.setParameter("countryRegion", countryRegion).getResultList().get(0);
	}

	@Override
	public USJanuaryDeaths findByCountryRegionProvinceState(String countryRegion, String provinceState) {
		return (USJanuaryDeaths) entityManager.createNamedQuery("USJanuaryDeaths.findByCountryRegionProvinceState")
				.setParameter("countryRegion", countryRegion).setParameter("provenceState", provinceState)
				.getResultList().get(0);
	}

	@Override
	public List<USJanuaryDeaths> getEntryByProvenceState(String provenceState) {
		return entityManager.createNamedQuery("USJanuaryDeaths.findByProvenceState")
				.setParameter("provenceState", provenceState).getResultList();
	}

}
