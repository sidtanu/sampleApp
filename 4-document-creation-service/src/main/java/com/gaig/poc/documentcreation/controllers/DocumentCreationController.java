package com.gaig.poc.documentcreation.controllers;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.slf4j.Logger;

import com.gaig.poc.documentcreation.entities.CreatedDocumentLink;
import com.gaig.poc.documentcreation.entities.Document;
import com.gaig.poc.documentcreation.services.DocumentCreationService;

@RestController
public class DocumentCreationController {	
	
	@Autowired
	private DocumentCreationService documentCreationService;
	
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@PostMapping(value = "/document", consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
				produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public CreatedDocumentLink createDocument(@Validated @RequestBody Document document) throws Exception{
		logger.info("DocumentCreationService - POST /document called");
		
		CreatedDocumentLink response = documentCreationService.createDocument(document);
		
		logger.debug("DocumentCreationService - POST /document - response - " + response);
		return response;
	}	
	
	@GetMapping(value = "/document")
	public String getDocument() {
		logger.info("ExtreamProxyService - GET /document called");
		return "A very GOOD MORNING to you all....";
	}
	
	@GetMapping(value = "/templates")
	public String getTemplates() {
		logger.info("DocumentCreationService - GET /templates called");
		
		return documentCreationService.getTemplates();
	}
	
}
