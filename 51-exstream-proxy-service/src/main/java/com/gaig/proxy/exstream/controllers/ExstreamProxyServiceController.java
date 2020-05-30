package com.gaig.proxy.exstream.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.gaig.proxy.exstream.model.Document;

@RestController
public class ExstreamProxyServiceController {

	@Value("${exstreamUri}")
	String exstreamUri;
	
	Logger logger = LoggerFactory.getLogger(this.getClass());	

	@PostMapping(value = "/document", consumes = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE }, produces = { MediaType.APPLICATION_JSON_VALUE,
					MediaType.APPLICATION_XML_VALUE })
	public String createDocument(@RequestBody Document document) {
		logger.info("ExtreamProxyService - POST /document called");
		
		RestTemplate restTemplate = new RestTemplate();
		try {			
			return restTemplate.postForObject(exstreamUri, document, String.class);
		} catch (Exception e) {
			logger.error("ExtreamProxyService - POST /document - Encountered Exception - " + e);
			return e.toString();
		}

	}

	@GetMapping(value = "/document")
	public String getDocument() {
		logger.info("ExtreamProxyService - GET /document called");
		return "A very GOOD MORNING to you all....";
	}

}
