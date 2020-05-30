package com.gaig.poc.documentcreation.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.gaig.poc.documentcreation.entities.Document;
import com.gaig.poc.documentcreation.entities.ProxyDocument;

@Service
public class BeanConversionService {
	
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	public ProxyDocument convertDocumentToProxyDocument(Document document) {
		logger.debug(document.toString());
		ProxyDocument proxyDocument = new ProxyDocument();
		if(document!=null) {
			proxyDocument.setClaimantFullName(document.getClaimantFullName());
			proxyDocument.setClaimantSignature(document.getClaimantSignature());
			proxyDocument.setClaimNumber(document.getClaimNumber());
			proxyDocument.setDocuName(document.getDocuName());
			proxyDocument.setPolicyExp(document.getPolicyExp());
			proxyDocument.setPolicyNumber(document.getPolicyNumber());
			proxyDocument.setPolicyTerm(document.getPolicyTerm());
			proxyDocument.setReportedDate(document.getReportedDate());
			proxyDocument.setSendTo(document.getSendTo());
			proxyDocument.setToAddressLine1(document.getToAddressLine1());
			proxyDocument.setToState(document.getToState());
			proxyDocument.setToZip(document.getToZip());
		}
		return proxyDocument;
	}

}
