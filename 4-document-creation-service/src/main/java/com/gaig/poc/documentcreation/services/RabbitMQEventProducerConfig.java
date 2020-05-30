package com.gaig.poc.documentcreation.services;

import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Profile("publisher")
@Configuration
public class RabbitMQEventProducerConfig {

	@Value("${rabbitmq.exchange}")
	String exchange;
	
	@Bean
	public TopicExchange senderTopicExchange() {
		return new TopicExchange(exchange);
	}
	
	@Bean
	public RabbitMQEventProducer eventPublisher(RabbitTemplate rabbitTemplate, TopicExchange senderTopicExchange, Jackson2JsonMessageConverter jsonMessageConverter) {
		return new RabbitMQEventProducer(rabbitTemplate, senderTopicExchange, jsonMessageConverter);
	}
	
	@Bean
	private Jackson2JsonMessageConverter jsonMessageConverter() {
		return new Jackson2JsonMessageConverter();
	}
	
}
