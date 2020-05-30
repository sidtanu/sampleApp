package com.gaig.poc.documentcreation.entities;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CreatedDocumentLink {
	
	private String fileUrl;

	private String fileName;
	
	public CreatedDocumentLink(String fileUrl, String fileName) {
		super();
		this.fileUrl = fileUrl;
		this.fileName = fileName;
	}

	@Override
	public String toString() {
		return "CreatedDocumentLink [fileContent=" + fileUrl + ", fileName=" + fileName + "]";
	}

	public String getFileUrl() {
		return fileUrl;
	}
	@JsonProperty("fileurl")
	public void setFileUrl(String fileUrl) {
		this.fileUrl = fileUrl;
	}

	public String getFileName() {
		return fileName;
	}
	
	@JsonProperty("filename")
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}	

}
