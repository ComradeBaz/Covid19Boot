package com.domrade.beans.singleton;

import java.util.LinkedHashMap;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.domrade.interfaces.local.CachedGenericMonthlyDataLocal;

@Component
@Scope("application")
public class CachedGenericMonthlyData implements CachedGenericMonthlyDataLocal {

	// Default DataSets
	private String lastKnownDate;
	LinkedHashMap<String, Integer> emptyDataSet = new LinkedHashMap<>();

	public CachedGenericMonthlyData() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public LinkedHashMap<String, Integer> getEmptyDataSet() {
		return emptyDataSet;
	}

	@Override
	public void setEmptyDataSet(LinkedHashMap<String, Integer> emptyDataSet) {
		this.emptyDataSet = emptyDataSet;
	}

	@Override
	public String getLastKnownDate() {
		return lastKnownDate;
	}

	@Override
	public void setLastKnownDate(String lastKnownDate) {
		this.lastKnownDate = lastKnownDate;
	}

}
