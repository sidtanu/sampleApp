package com.gaig.proxy.empower.services;

import java.io.IOException;
import java.util.Date;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitBootstrapConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonFormatVisitorWrapper;
import com.gaig.proxy.empower.models.DocumentDCS;

@Service
public class RabbitMQSender {
	@Autowired
	private AmqpTemplate amqpTemplate;

	@Value("${hcl.rabbitmq.exchange}")
	private String exchange;

	@Value("${hcl.rabbitmq.routingkey}")
	private String routingkey;
	// @Value("${hcl.rabbitmq.queue}")
	// private String queueName;
	String queueName = "empower";

	public DocumentDCS getserviceQueue() {

		DocumentDCS documentdcs = new DocumentDCS();
		long timeoutMillis = 1000;
		Message msg = amqpTemplate.receive(queueName, timeoutMillis);

		String docjson = new String(msg.getBody());

		ObjectMapper mapper = new ObjectMapper();

		try {
			documentdcs = mapper.readValue(docjson, DocumentDCS.class);

			 System.out.println(documentdcs.concatvalues());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return documentdcs;

	}

}

/*
 * 
 * 
 * //public String getserviceQueue() { System.out.println("getserviceQueue");
 * System.out.println(queueName); // //amqpTemplate.receive(queueName); //
 * amqpTemplate.convertAndSend(routingkey, company); //{ System.out.println(s);
 * //System.out.println(msg.getBody()); //System.out.println(b[0]); // Document
 * doc= amqpTemplate.receiveAndConvert(Document); // System.out.println(
 * amqpTemplate.receiveAndConvert(queueName)); // Document doc=
 * receiveAndConvert(queueName,Document); // System.out.println(doc);
 * //System.out.println(New Date()); //msg= amqpTemplate.receive(queueName,
 * timeoutMillis); // Object doc =amqpTemplate.receiveAndConvert(queueName); //
 * System.out.println(doc.getClass());} //Object o=
 * amqpTemplate.receiveAndConvert(queueName); //System.out.println(o);
 * 
 * // System.out.println( msg.getMessageProperties()); // byte[] b=
 * Document(msg.getBody()); //Message msg1 = mapper.readValue(msg,
 * Message.class);
 * 
 * 
 * public void send(Document docment) {
 * 
 * amqpTemplate.convertAndSend(exchange, routingkey, docment); String queueName
 * = "empower";
 * 
 * System.out.println(queueName);
 * 
 * System.out.println("Send msg = " + docment);
 * 
 * }
 * 
 * public void sendString(String Name) { amqpTemplate.convertAndSend(Name);
 * 
 * }
 * 
 * public Message getserviceName() { String queueName = "javainuse.queueHCL";
 * long timeoutMillis = 10000;
 * 
 * return amqpTemplate.receive(queueName, timeoutMillis);
 * 
 * }
 * 
 * try { String s1 = (mapper.writeValueAsString(msg)); } catch
 * (JsonProcessingException e1) { // TODO Auto-generated catch block
 * e1.printStackTrace(); }
 * 
 */