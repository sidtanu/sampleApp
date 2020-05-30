package com.gaig.poc.documentcreation.services;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.gaig.poc.documentcreation.entities.CreatedDocumentLink;
import com.gaig.poc.documentcreation.entities.ProxyDocument;

@FeignClient(name="letterexpress-proxy-service")
public interface LetterExpressFeignClientService {
	
	@PostMapping(value = "/document", consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
				produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public CreatedDocumentLink createDocument(@RequestBody ProxyDocument document);
	
	@GetMapping("/document")
	public String getDocument();
	
}
