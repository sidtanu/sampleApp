package com.gaig.proxy.exstream.services;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Message;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gaig.proxy.exstream.model.Document;
import com.gaig.proxy.exstream.model.DocumentDCS;

@Service
public class RabbitMQEventConsumer {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Value("${exstream.rabbitmq.queue}")
	String queueName;
	
	private AmqpTemplate amqpTemplate;

	public void receive(String message) {
		logger.info("RabbitMQEventConsumer.receive - Received message -", message);
	}

	public Document getserviceQueue() {

		long timeoutMillis = 1000;
		Message msg = amqpTemplate.receive(queueName, timeoutMillis);

		String docjson = new String(msg.getBody());
		ObjectMapper mapper = new ObjectMapper();
		Document document = null;

		try {
			document = mapper.readValue(docjson, Document.class);

			logger.debug("RabbitMQEventConsumer.getserviceQueue - Received Object - " + document.concatvalues());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return document;

	}

}