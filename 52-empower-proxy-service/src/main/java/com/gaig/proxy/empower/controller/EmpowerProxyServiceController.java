package com.gaig.proxy.empower.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.gaig.proxy.empower.models.Document;
import com.gaig.proxy.empower.models.DocumentDCS;

@RestController
public class EmpowerProxyServiceController {

	@Value("${empowerUri}")
	String uri;

	Logger logger = LoggerFactory.getLogger(this.getClass());

	@PostMapping(value = "/document", consumes = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE }, produces = { MediaType.APPLICATION_JSON_VALUE,
					MediaType.APPLICATION_XML_VALUE })
	public String createDocument(@RequestBody DocumentDCS documentdcs) {
		logger.info("EmpowerProxyService - POST /document called");
		Document document = new Document(documentdcs.getclaimNumber(), documentdcs.concatvalues());
		RestTemplate restTemplate = new RestTemplate();
		try {
			return restTemplate.postForObject(uri, document, String.class);
		} catch (Exception e) {
			System.out.println(e);
			return e.toString();
		}

	}

	@GetMapping(value = "/document")
	public String getDocument() {
		logger.info("EmpowerProxyService - GET /document called");
		return "A very GOOD MORNING to you all....";
	}

}
