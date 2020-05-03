/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.domrade.dao.implementation;

import java.util.List;

import org.springframework.stereotype.Service;

import com.domrade.dao.JpaDao;
import com.domrade.dao.interfaces.USMayDao;
import com.domrade.entity.implementation.USMay;

/**
 *
 * @author David
 */
@Service
public class JpaUSMayDao extends JpaDao<Long, USMay> implements USMayDao {

	public JpaUSMayDao() {
		super(USMay.class);
	}

	@Override
	public List<USMay> findAllEntries() {
		return entityManager.createNamedQuery("USMay.findAllEntries").getResultList();
	}

	@Override
	public USMay getEntryByCountryRegion(String countryRegion) {
		return (USMay) entityManager.createNamedQuery("USMay.findByCountryRegion")
				.setParameter("countryRegion", countryRegion).getResultList().get(0);
	}

	@Override
	public USMay findByCountryRegionProvinceState(String countryRegion, String provinceState) {
		return (USMay) entityManager.createNamedQuery("USMay.findByCountryRegionProvinceState")
				.setParameter("countryRegion", countryRegion).setParameter("provenceState", provinceState)
				.getResultList().get(0);
	}

	@Override
	public List<USMay> getEntryByProvenceState(String provenceState) {
		return entityManager.createNamedQuery("USMay.findByProvenceState").setParameter("provenceState", provenceState)
				.getResultList();
	}

}
