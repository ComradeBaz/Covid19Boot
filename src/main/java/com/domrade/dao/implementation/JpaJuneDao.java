/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.domrade.dao.implementation;

import java.util.List;

import org.springframework.stereotype.Service;

import com.domrade.dao.JpaDao;
import com.domrade.dao.interfaces.JuneDao;
import com.domrade.entity.implementation.June;

/**
 *
 * @author David
 */
@Service
public class JpaJuneDao extends JpaDao<Long, June> implements JuneDao {

	public JpaJuneDao() {
		super(June.class);
	}

	@Override
	public List<June> findAllEntries() {
		return entityManager.createNamedQuery("June.findAllEntries").getResultList();
	}

	@Override
	public June getEntryByCountryRegion(String countryRegion) {
		return (June) entityManager.createNamedQuery("June.findByCountryRegion")
				.setParameter("countryRegion", countryRegion).getResultList().get(0);
	}

	@Override
	public June findByCountryRegionProvinceState(String countryRegion, String provinceState) {
		return (June) entityManager.createNamedQuery("June.findByCountryRegionProvinceState")
				.setParameter("countryRegion", countryRegion).setParameter("provenceState", provinceState)
				.getResultList().get(0);
	}

}
