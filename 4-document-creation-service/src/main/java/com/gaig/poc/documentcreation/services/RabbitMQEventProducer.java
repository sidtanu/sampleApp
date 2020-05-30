package com.gaig.poc.documentcreation.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.gaig.poc.documentcreation.entities.ProxyDocument;

@Service
public class RabbitMQEventProducer {
	
	private final RabbitTemplate rabbitTemplate;
	
	private final TopicExchange topicExchange;
	
	private final Jackson2JsonMessageConverter jsonMessageConverter;

	@Value("${exstream.rabbitmq.routingkey}")
	private String exstreamRoutingKey;
	
	@Value("${empower.rabbitmq.routingkey}")
	private String empowerRoutingKey;
	
	@Value("${letterexpress.rabbitmq.routingkey}")
	private String letterexpressRoutingKey;

	private final static String SYS_NAME_EXSTREAM = "Exstream";
	private final static String SYS_NAME_LETTEREXPRESS = "LetterExpress";
	private final static String SYS_NAME_EMPOWER = "Empower";
	
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	public RabbitMQEventProducer(RabbitTemplate rabbitTemplate, TopicExchange exchange, Jackson2JsonMessageConverter jsonMessageConverter) {
	    this.rabbitTemplate = rabbitTemplate;
	    this.topicExchange = exchange;
	    this.jsonMessageConverter = jsonMessageConverter;
	    rabbitTemplate.setMessageConverter(jsonMessageConverter);
	}

	public void sendMessage(String systemName, ProxyDocument proxyDocument) throws Exception{
		logger.info("RabbitMQEventProducer - sendMessage() - sending message to " + systemName);
		String routingKey;
	    
	    if(SYS_NAME_EXSTREAM.equalsIgnoreCase(systemName)) {
	    	routingKey = exstreamRoutingKey;
    	}else if (SYS_NAME_EMPOWER.equalsIgnoreCase(systemName)) {
    		routingKey = empowerRoutingKey;
    	}else if (SYS_NAME_LETTEREXPRESS.equalsIgnoreCase(systemName)) {
    		routingKey = letterexpressRoutingKey;
    	} else {
    		throw new Exception("Invalid value for System Name");
    	}
	    
	    rabbitTemplate.convertAndSend(topicExchange.getName(), routingKey, proxyDocument);
	}

}