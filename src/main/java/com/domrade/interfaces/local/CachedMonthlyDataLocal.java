/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.domrade.interfaces.local;

import org.springframework.stereotype.Service;

import com.domrade.entity.implementation.April;
import com.domrade.entity.implementation.AprilDeaths;
import com.domrade.entity.implementation.February;
import com.domrade.entity.implementation.FebruaryDeaths;
import com.domrade.entity.implementation.January;
import com.domrade.entity.implementation.JanuaryDeaths;
import com.domrade.entity.implementation.March;
import com.domrade.entity.implementation.MarchDeaths;
import com.domrade.entity.implementation.May;
import com.domrade.entity.implementation.MayDeaths;

/**
 *
 * @author David
 */
@Service
public interface CachedMonthlyDataLocal {

	public January getJanuaryEntityByLocation(String location);

	public February getFebruaryEntityByLocation(String location);

	public March getMarchEntityByLocation(String location);

	public April getAprilEntityByLocation(String location);

	public May getMayEntityByLocation(String location);

	public JanuaryDeaths getJanuaryDeathByLocation(String location);

	public FebruaryDeaths getFebruaryDeathsByLocation(String location);

	public MarchDeaths getMarchDeathsByLocation(String location);

	public AprilDeaths getAprilDeathsByLocation(String location);

	public MayDeaths getMayDeathsByLocation(String location);

	public void updateCache();

}
