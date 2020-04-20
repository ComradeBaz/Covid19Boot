package com.domrade.interfaces.local;

import org.springframework.stereotype.Service;

@Service
public interface ParseCsvServiceLocal {

	public void readFile(String fileName);

	public boolean checkPositionInArray(int index, int arrayLength);

	public String getDataByMonth(String lineOfData, int indexProvinceState, int indexCountryRegion, int indexLat,
			int indexLong, int indexFirstDayOfMonth, int indexEndOfMonth);

}
