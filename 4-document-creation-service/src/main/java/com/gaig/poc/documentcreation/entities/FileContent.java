package com.gaig.poc.documentcreation.entities;

import com.fasterxml.jackson.annotation.JsonProperty;

public class FileContent {

	private String fileContent;

	private String fileName;

	public FileContent() {

	}

	public FileContent(String fileContent, String fileName) {
		super();
		this.fileContent = fileContent;
		this.fileName = fileName;
	}

	public String getFileContent() {
		return fileContent;
	}

	@JsonProperty("fileContent")
	public void setFileContent(String fileContent) {
		this.fileContent = fileContent;
	}

	public String getFileName() {
		return fileName;
	}

	@JsonProperty("fileName")
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

}
