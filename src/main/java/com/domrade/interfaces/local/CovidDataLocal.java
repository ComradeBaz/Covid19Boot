package com.domrade.interfaces.local;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public interface CovidDataLocal {

	List<Integer> getCovidDataByLocationAndType(long location, String type);

	List<Date> getCovidDateByLocationAndType(long location, String type);

	int getSumForState(String stateName, Date date, String type);

	ArrayList<Date> getDatesOfDataForState(String stateName, String type);

	ArrayList<Date> getDatesOfDataForLocationByType(long locationId, String type);

	ArrayList<Date> getDates();

	String getMaxDate();

	int getDataByIdDateType(Long id, Date d, String type);
}
