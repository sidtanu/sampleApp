package com.gaig.proxy.exstream.services;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.gaig.proxy.exstream.model.FileContent;

@FeignClient(name = "exstream-proxy-service")
public interface ProxyService {
	
	@PostMapping(value = "/document", consumes = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE }, produces = { MediaType.APPLICATION_JSON_VALUE,
					MediaType.APPLICATION_XML_VALUE })
	public String createDocument(@RequestBody FileContent document);

}
