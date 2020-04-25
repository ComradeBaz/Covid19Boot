package com.domrade.interfaces.local;

import java.util.LinkedHashMap;

import org.springframework.stereotype.Service;

@Service
public interface CachedGenericMonthlyDataLocal {

	public LinkedHashMap<String, Integer> getEmptyDataSet();

	public void setEmptyDataSet(LinkedHashMap<String, Integer> emptyDataSet);

	public String getLastKnownDate();

	public void setLastKnownDate(String lastKnownDate);
}
