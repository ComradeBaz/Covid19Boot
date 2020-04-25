package com.domrade.services.cache;

import java.util.LinkedHashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.domrade.beans.singleton.CachedGenericMonthlyData;
import com.domrade.interfaces.cache.CachedGenericMonthlyDataServiceLocal;

@Service
public class CachedGenericMonthlyDataService implements CachedGenericMonthlyDataServiceLocal {

	@Autowired
	private CachedGenericMonthlyData cachedGenericData;

	public CachedGenericMonthlyDataService() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public LinkedHashMap<String, Integer> getEmptyDataSet() {
		return cachedGenericData.getEmptyDataSet();
	}

	@Override
	public String getLastKnownDate() {
		return cachedGenericData.getLastKnownDate();
	}

}
