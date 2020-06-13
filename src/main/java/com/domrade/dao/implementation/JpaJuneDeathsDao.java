/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.domrade.dao.implementation;

import java.util.List;

import org.springframework.stereotype.Service;

import com.domrade.dao.JpaDao;
import com.domrade.dao.interfaces.JuneDeathsDao;
import com.domrade.entity.implementation.JuneDeaths;

/**
 *
 * @author David
 */
@Service
public class JpaJuneDeathsDao extends JpaDao<Long, JuneDeaths> implements JuneDeathsDao {

	public JpaJuneDeathsDao() {
		super(JuneDeaths.class);
	}

	@Override
	public List<JuneDeaths> findAllEntries() {
		return entityManager.createNamedQuery("JuneDeaths.findAllEntries").getResultList();
	}

	@Override
	public JuneDeaths getEntryByCountryRegion(String countryRegion) {
		return (JuneDeaths) entityManager.createNamedQuery("JuneDeaths.findByCountryRegion")
				.setParameter("countryRegion", countryRegion).getResultList().get(0);
	}

	@Override
	public JuneDeaths findByCountryRegionProvinceState(String countryRegion, String provinceState) {
		return (JuneDeaths) entityManager.createNamedQuery("JuneDeaths.findByCountryRegionProvinceState")
				.setParameter("countryRegion", countryRegion).setParameter("provenceState", provinceState)
				.getResultList().get(0);
	}

}
