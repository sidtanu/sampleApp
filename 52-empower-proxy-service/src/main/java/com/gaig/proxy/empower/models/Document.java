package com.gaig.proxy.empower.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Document {

	private String fileContent;

	private String fileName;

	public Document() {

	}

	public Document(String fileName, String fileContent) {
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
