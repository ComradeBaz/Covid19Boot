/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.domrade.dao.implementation;

import java.util.List;

import org.springframework.stereotype.Service;

import com.domrade.dao.JpaDao;
import com.domrade.dao.interfaces.USMarchDao;
import com.domrade.entity.implementation.USMarch;

/**
 *
 * @author David
 */
@Service
public class JpaUSMarchDao extends JpaDao<Long, USMarch> implements USMarchDao {

	public JpaUSMarchDao() {
		super(USMarch.class);
	}

	@Override
	public List<USMarch> findAllEntries() {
		return entityManager.createNamedQuery("USMarch.findAllEntries").getResultList();
	}

	@Override
	public USMarch getEntryByCountryRegion(String countryRegion) {
		return (USMarch) entityManager.createNamedQuery("USMarch.findByCountryRegion")
				.setParameter("countryRegion", countryRegion).getResultList().get(0);
	}

	@Override
	public USMarch findByCountryRegionProvinceState(String countryRegion, String provinceState) {
		return (USMarch) entityManager.createNamedQuery("USMarch.findByCountryRegionProvinceState")
				.setParameter("countryRegion", countryRegion).setParameter("provenceState", provinceState)
				.getResultList().get(0);
	}

}
