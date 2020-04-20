/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.domrade.services;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.domrade.interfaces.local.CachedDataLocal;
import com.domrade.interfaces.local.WriteMonthlyFilesToDiskServiceLocal;

/**
 *
 * @author David
 */
@Service
public class WriteMonthlyFilesToDiskService implements WriteMonthlyFilesToDiskServiceLocal {

	@Autowired
	private CachedDataLocal cachedData;

	// The csv file containing data is not broken down by month
	// ParseCsvService.java parses the original csv file and stores the data by
	// month
	// This method writes the data to individual files sorted by month
	@Override
	public void writeFileToDisk(String fileName, List<String> dataToWrite) {
		try {
			FileWriter fileWriter = new FileWriter(cachedData.getFileLocation() + fileName);
			for (String s : dataToWrite) {
				fileWriter.write(s);
			}
			fileWriter.close();
		} catch (IOException ex) {
			Logger.getLogger(WriteMonthlyFilesToDiskService.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

}
