package com.gaig.proxy.exstream.model;

import java.util.Arrays;

public class TemplateList {
	
	String[] templates;

	public String[] getTemplates() {
		return templates;
	}

	public void setTemplates(String[] templates) {
		this.templates = templates;
	}

	@Override
	public String toString() {
		return "TemplateList [templates=" + Arrays.toString(templates) + "]";
	}

}
