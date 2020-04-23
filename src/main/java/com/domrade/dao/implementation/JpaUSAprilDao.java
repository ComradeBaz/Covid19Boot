/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.domrade.dao.implementation;

import java.util.List;

import org.springframework.stereotype.Service;

import com.domrade.dao.JpaDao;
import com.domrade.dao.interfaces.USAprilDao;
import com.domrade.entity.implementation.USApril;

/**
 *
 * @author David
 */
@Service
public class JpaUSAprilDao extends JpaDao<Long, USApril> implements USAprilDao {

	public JpaUSAprilDao() {
		super(USApril.class);
	}

	@Override
	public List<USApril> findAllEntries() {
		return entityManager.createNamedQuery("USApril.findAllEntries").getResultList();
	}

	@Override
	public USApril getEntryByCountryRegion(String countryRegion) {
		return (USApril) entityManager.createNamedQuery("USApril.findByCountryRegion")
				.setParameter("countryRegion", countryRegion).getResultList().get(0);
	}

	@Override
	public USApril findByCountryRegionProvinceState(String countryRegion, String provinceState) {
		return (USApril) entityManager.createNamedQuery("USApril.findByCountryRegionProvinceState")
				.setParameter("countryRegion", countryRegion).setParameter("provenceState", provinceState)
				.getResultList().get(0);
	}

	@Override
	public List<USApril> getEntryByProvenceState(String provenceState) {
		return entityManager.createNamedQuery("USApril.findByProvenceState")
				.setParameter("provenceState", provenceState).getResultList();
	}

}
