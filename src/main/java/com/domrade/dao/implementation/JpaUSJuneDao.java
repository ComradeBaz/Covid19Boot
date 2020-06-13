/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.domrade.dao.implementation;

import java.util.List;

import org.springframework.stereotype.Service;

import com.domrade.dao.JpaDao;
import com.domrade.dao.interfaces.USJuneDao;
import com.domrade.entity.implementation.USJune;

/**
 * 
 * @author David
 */
@Service
public class JpaUSJuneDao extends JpaDao<Long, USJune> implements USJuneDao {

	public JpaUSJuneDao() {
		super(USJune.class);
	}

	@Override
	public List<USJune> findAllEntries() {
		return entityManager.createNamedQuery("USJune.findAllEntries").getResultList();
	}

	@Override
	public USJune getEntryByCountryRegion(String countryRegion) {
		return (USJune) entityManager.createNamedQuery("USJune.findByCountryRegion")
				.setParameter("countryRegion", countryRegion).getResultList().get(0);
	}

	@Override
	public USJune findByCountryRegionProvinceState(String countryRegion, String provinceState) {
		return (USJune) entityManager.createNamedQuery("USJune.findByCountryRegionProvinceState")
				.setParameter("countryRegion", countryRegion).setParameter("provenceState", provinceState)
				.getResultList().get(0);
	}

	@Override
	public List<USJune> getEntryByProvenceState(String provenceState) {
		return entityManager.createNamedQuery("USJune.findByProvenceState").setParameter("provenceState", provenceState)
				.getResultList();
	}

}
