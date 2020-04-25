package com.domrade.interfaces.cache;

import java.util.LinkedHashMap;

import org.springframework.stereotype.Service;

@Service
public interface CachedGenericMonthlyDataServiceLocal {

	public LinkedHashMap<String, Integer> getEmptyDataSet();

	public String getLastKnownDate();
}
