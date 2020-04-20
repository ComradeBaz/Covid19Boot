/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.domrade.controllers;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.domrade.interfaces.local.CachedDataLocal;
import com.domrade.interfaces.local.ParseCsvServiceLocal;

/**
 *
 * @author David
 */
@Component
@Scope("request")
public class ParseFile {

	@Autowired
	private CachedDataLocal cachedData;

	@Autowired
	private ParseCsvServiceLocal parseCsv;

	private List<String> files;
	private String fileToParse;
	private String fileLocation;

	public ParseFile() {
		// no arg constructor
	}

	@PostConstruct
	public void init() {
		files = cachedData.getFileNames();
		fileLocation = cachedData.getFileLocation();
	}

	public List<String> getFiles() {
		return files;
	}

	public void setFiles(List<String> files) {
		this.files = files;
	}

	public String getFileToParse() {
		return fileToParse;
	}

	public void setFileToParse(String fileToParse) {
		this.fileToParse = fileToParse;
	}

	public String getFileLocation() {
		return fileLocation;
	}

	public void setFileLocation(String fileLocation) {
		this.fileLocation = fileLocation;
	}

	public String doParsing() {
		parseCsv.readFile(fileLocation + fileToParse);

		return "";
	}
}
