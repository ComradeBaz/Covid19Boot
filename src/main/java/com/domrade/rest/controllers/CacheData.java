package com.domrade.rest.controllers;

import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.domrade.interfaces.cache.CachedMonthlyDataServiceLocal;
import com.domrade.interfaces.local.CachedDataLocal;
import com.domrade.interfaces.local.CachedUsMonthlyDataLocal;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class CacheData {

	@Autowired
	private CachedDataLocal cachedData;

	@Autowired
	private CachedMonthlyDataServiceLocal cachedMonthlyData;

	@Autowired
	private CachedUsMonthlyDataLocal cachedUsMonthlyData;

	public CacheData() {
		// TODO Auto-generated constructor stub
	}

	@GetMapping("/getUpdateCache")
	@Produces(MediaType.TEXT_PLAIN)
	public String updateCache(@RequestParam String password) {
		if (password.equalsIgnoreCase("rtJlke48394GDs8")) {
			// CachedData gets data from CachedMonthlyData
			// Update CachedMonthlyData first
			cachedMonthlyData.updateCache();
			cachedUsMonthlyData.updateCache();
			cachedData.updateCache();

			return "Cache Updated";
		}
		return "Error";
	}

}
