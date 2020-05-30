package com.gaig.proxy.letterexpress.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.gaig.proxy.letterexpress.models.Document;
import com.gaig.proxy.letterexpress.models.DocumentDCS;

@RestController
public class LetterExpressProxyServiceController {

	@Value("${letterExpressUri}")
	String uri;

	Logger logger = LoggerFactory.getLogger(this.getClass());

	@RequestMapping(value = "/document", method = RequestMethod.POST)
	public String createDocument(@RequestBody DocumentDCS documentdcs) {
		logger.info("LetterExpressProxyService - POST /document called");
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
		logger.info("LetterExpressProxyService - GET /document called");
		return "A very GOOD MORNING to you all....";
	}

}
