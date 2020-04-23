/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.domrade.dao.implementation;

import java.util.List;

import org.springframework.stereotype.Service;

import com.domrade.dao.JpaDao;
import com.domrade.dao.interfaces.USJanuaryDao;
import com.domrade.entity.implementation.USJanuary;

/**
 *
 * @author David
 */
@Service
public class JpaUSJanuaryDao extends JpaDao<Long, USJanuary> implements USJanuaryDao {

	public JpaUSJanuaryDao() {
		super(USJanuary.class);
	}

	@Override
	public List<USJanuary> findAllEntries() {
		return entityManager.createNamedQuery("USJanuary.findAllEntries").getResultList();
	}

	@Override
	public USJanuary getEntryByCountryRegion(String countryRegion) {
		return (USJanuary) entityManager.createNamedQuery("USJanuary.findByCountryRegion")
				.setParameter("countryRegion", countryRegion).getResultList().get(0);
	}

	@Override
	public USJanuary findByCountryRegionProvinceState(String countryRegion, String provinceState) {
		return (USJanuary) entityManager.createNamedQuery("USJanuary.findByCountryRegionProvinceState")
				.setParameter("countryRegion", countryRegion).setParameter("provenceState", provinceState)
				.getResultList().get(0);
	}

	@Override
	public List<String> getAllStates() {
		return entityManager.createNamedQuery("USJanuary.findAllStates").getResultList();
	}

	@Override
	public List<USJanuary> getEntryByProvenceState(String provenceState) {
		return entityManager.createNamedQuery("USJanuary.findByProvenceState")
				.setParameter("provenceState", provenceState).getResultList();
	}

}
