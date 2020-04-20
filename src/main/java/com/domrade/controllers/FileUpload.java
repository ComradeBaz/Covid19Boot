package com.domrade.controllers;

import javax.servlet.http.Part;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.domrade.interfaces.local.CachedDataLocal;
import com.domrade.interfaces.local.ManageCsvFileServiceLocal;

@Component
@Scope("request")
public class FileUpload {

	@Autowired
	private ManageCsvFileServiceLocal manageDataFile;

	@Autowired
	private CachedDataLocal cachedData;

	private Part uploadedFile;

	public FileUpload() {
		// no arg constructor
	}

	public Part getUploadedFile() {
		return uploadedFile;
	}

	public void setUploadedFile(Part uploadedFile) {
		this.uploadedFile = uploadedFile;
	}

	public String saveFile() {
		String fileLocation = cachedData.getFileLocation();
		String fileName = uploadedFile.getSubmittedFileName();
		// Save uploaded file to disk
		manageDataFile.saveFileToDisk(uploadedFile, fileLocation, fileName);
		if (manageDataFile.checkForFileInDb(fileName, fileLocation)) {
			return "";
		}
		// Save file name and location to db
		manageDataFile.saveDataFile(fileLocation, fileName);
		// Files names are cached so they can be listed in a selectOneMenu on
		// index.xhtml
		manageDataFile.setCachedFileNames();

		return "";
	}

}
