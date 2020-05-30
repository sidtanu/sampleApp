package com.gaig.proxy.empower.models;

public class Response {
	
	String filename;
	String fileurl;
	Response() {
		
	}
	public Response(String filename, String fileurl) {
		super();
		this.filename = filename;
		this.fileurl = fileurl;
	}
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	public String getFileurl() {
		return fileurl;
	}
	public void setFileurl(String fileurl) {
		this.fileurl = fileurl;
	}
	@Override
	public String toString() {
		return "Response [filename=" + filename + ", fileurl=" + fileurl + "]";
	}

}
