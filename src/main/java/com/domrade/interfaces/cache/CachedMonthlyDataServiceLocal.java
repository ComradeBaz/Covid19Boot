/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.domrade.interfaces.cache;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.domrade.entity.implementation.April;
import com.domrade.entity.implementation.AprilDeaths;
import com.domrade.entity.implementation.February;
import com.domrade.entity.implementation.FebruaryDeaths;
import com.domrade.entity.implementation.January;
import com.domrade.entity.implementation.JanuaryDeaths;
import com.domrade.entity.implementation.March;
import com.domrade.entity.implementation.MarchDeaths;

/**
 *
 * @author David
 */
@Service
public interface CachedMonthlyDataServiceLocal {

	public Map<String, Long> getJanuaryConfirmedLocationsAndIds(List<January> januaryConfirmed);

	public Map<String, Long> getFebruaryConfirmedLocationsAndIds(List<January> januaryConfirmed);

	public Map<String, Long> getMarchConfirmedLocationsAndIds(List<January> januaryConfirmed);

	public Map<String, Long> getAprilConfirmedLocationsAndIds(List<January> januaryConfirmed);

	public Map<String, Long> getJanuaryDeathsLocationsAndIds(List<JanuaryDeaths> januaryDeaths);

	public January getJanuaryEntityByLocation(String location);

	public February getFebruaryEntityByLocation(String location);

	public March gettMarchEntityByLocation(String location);

	public April getAprilEntityByLocation(String location);

	public JanuaryDeaths getJanuaryDeathsByLocation(String location);

	public FebruaryDeaths getFebruaryDeathsByLocation(String location);

	public MarchDeaths getMarchDeathsByLocation(String location);

	public AprilDeaths getAprilDeathsByLocation(String location);

}
