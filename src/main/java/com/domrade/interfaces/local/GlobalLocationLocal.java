package com.domrade.interfaces.local;

import java.util.List;

import org.springframework.stereotype.Service;

import com.domrade.entity.implementation.GlobalLocation;

@Service
public interface GlobalLocationLocal {

	public List<GlobalLocation> findAllGlobalLocations();

	public List<Long> findAllGlobalLocationIds();

	public List<String> findAllGlobalLocationNames();

	public String getLocationNameById(long id);

}
