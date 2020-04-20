/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.domrade.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.domrade.interfaces.local.CachedDataLocal;
import com.domrade.interfaces.local.WriteMonthlyFilesToDiskServiceLocal;

/**
 *
 * @author David
 */
@Component
@Scope("request")
public class WriteMonthlyFilesToDisk {

	private final String januaryFileName = "jan";
	private final String februaryFileName = "february";
	private final String marchFileName = "march";
	private final String aprilFileName = "april";
	private final String mayFileName = "may";
	private final String extension = ".csv";

	private String typeOfFile;

	@Autowired
	private WriteMonthlyFilesToDiskServiceLocal writeFilesToDisk;

	@Autowired
	private CachedDataLocal cachedData;

	public WriteMonthlyFilesToDisk() {
		// no arg constructor
	}

	public String getTypeOfFile() {
		return typeOfFile;
	}

	public void setTypeOfFile(String typeOfFile) {
		this.typeOfFile = typeOfFile;
	}

	public String writeFileToDisk() {

		if (cachedData.isJanuaryData()) {
			writeFilesToDisk.writeFileToDisk(januaryFileName + typeOfFile + extension, cachedData.getJanuary());
		}
		if (cachedData.isFebruaryData()) {
			writeFilesToDisk.writeFileToDisk(februaryFileName + typeOfFile + extension, cachedData.getFebruary());
		}
		if (cachedData.isMarchData()) {
			writeFilesToDisk.writeFileToDisk(marchFileName + typeOfFile + extension, cachedData.getMarch());
		}
		if (cachedData.isAprilData()) {
			writeFilesToDisk.writeFileToDisk(aprilFileName + typeOfFile + extension, cachedData.getApril());
		}
		if (cachedData.isMayData()) {
			writeFilesToDisk.writeFileToDisk(mayFileName + typeOfFile + extension, cachedData.getMarch());
		}

		return "";
	}
}
