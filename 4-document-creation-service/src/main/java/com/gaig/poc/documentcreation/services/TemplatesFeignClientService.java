package com.gaig.poc.documentcreation.services;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name="templates-proxy-service", url="${templateUri}")
public interface TemplatesFeignClientService {
	
	@GetMapping(value = "/templateSearchService/templateNameList/")
	public String getTemplates();
	
}
