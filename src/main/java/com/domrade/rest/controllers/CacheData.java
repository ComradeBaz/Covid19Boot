package com.domrade.rest.controllers;

import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.jboss.logging.Logger;
import org.jboss.logging.Logger.Level;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.domrade.interfaces.local.CachedCovidDataLocal;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class CacheData {

	private final static Logger LOGGER = Logger.getLogger(CacheData.class);

	@Autowired
	private CachedCovidDataLocal cachedData;

	public CacheData() {
		// TODO Auto-generated constructor stub
	}

	@GetMapping("/getUpdateCache")
	@Produces(MediaType.TEXT_PLAIN)
	public String updateCache(@RequestParam String password) {
		LOGGER.log(Level.DEBUG, "About to update cache...");
		if (password.equalsIgnoreCase("rtJlke48394GDs8")) {
			// CachedData gets data from CachedMonthlyData
			// Update CachedMonthlyData first
			cachedData.updateCache();
			cachedData.updateCache();

			return "Cache Updated";
		}
		return "Error";
	}

}
