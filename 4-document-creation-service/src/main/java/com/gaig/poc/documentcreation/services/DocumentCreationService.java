package com.gaig.poc.documentcreation.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.gaig.poc.documentcreation.entities.CreatedDocumentLink;
import com.gaig.poc.documentcreation.entities.Document;
import com.gaig.poc.documentcreation.entities.ProxyDocument;

@Component
public class DocumentCreationService {
		
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private ExstreamFeignClientService exstreamFeignCientService;
	
	@Autowired
	private EmpowerFeignClientService empowerFeignCientService;
	
	@Autowired
	private LetterExpressFeignClientService letterExpressFeignCientService;
	
	@Autowired
	private TemplatesFeignClientService templatesFeignCientService;
	
	@Autowired
	private BeanConversionService beanConversionService;
	
	@Autowired
	private RabbitMQEventProducer rabbitMQEventProducer;
	
	private final static String EXEC_MODE_SYNC = "Synchronous";
	private final static String EXEC_MODE_ASYNC = "Asynchronous";
	
	private final static String SYS_NAME_EXSTREAM = "Exstream";
	private final static String SYS_NAME_LETTEREXPRESS = "LetterExpress";
	private final static String SYS_NAME_EMPOWER = "Empower";
	
	public CreatedDocumentLink createDocument(Document document) throws Exception{
		logger.debug("DocumentCreationService.createDocument(Document) - " + document);
		CreatedDocumentLink response = new CreatedDocumentLink("", "");
		ProxyDocument proxyDocument = beanConversionService.convertDocumentToProxyDocument(document);
		
        if (EXEC_MODE_SYNC.equalsIgnoreCase(document.getExecutionMode())) {
        	if(SYS_NAME_EXSTREAM.equalsIgnoreCase(document.getSystemName())) {
        		response = exstreamFeignCientService.createDocument(proxyDocument);
        	}else if (SYS_NAME_EMPOWER.equalsIgnoreCase(document.getSystemName())) {
        		response = empowerFeignCientService.createDocument(proxyDocument);
        	}else if (SYS_NAME_LETTEREXPRESS.equalsIgnoreCase(document.getSystemName())) {
        		response = letterExpressFeignCientService.createDocument(proxyDocument);
        	} else {
        		throw new Exception("Invalid value for System Name");
        	}        		
        } else if(EXEC_MODE_ASYNC.equalsIgnoreCase(document.getExecutionMode())) {
        	pushMessageIntoQueue(document.getSystemName(), proxyDocument);
        } else {
        	throw new Exception("Invalid value for Execution Mode");
        }

        return response;
    }
	
	public void pushMessageIntoQueue(String systemName, ProxyDocument proxyDocument) throws Exception{
		logger.info("ExtreamProxyService - pushMessageIntoQueue called for asynchronous communication");
		rabbitMQEventProducer.sendMessage(systemName,proxyDocument);
	}
	
	public String getTemplates() {
		return templatesFeignCientService.getTemplates();
	}
}
