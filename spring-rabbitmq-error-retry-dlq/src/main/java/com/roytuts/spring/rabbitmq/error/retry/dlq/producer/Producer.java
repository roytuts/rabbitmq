package com.roytuts.spring.rabbitmq.error.retry.dlq.producer;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Producer {

	@Value("${exchange.roytuts}")
	private String roytutsExchange;

	@Value("${routing.key.roytuts}")
	private String routingKeyRoytuts;

	@Autowired
	private RabbitTemplate rabbitTemplate;

	public void sendName(final String name) {
		rabbitTemplate.convertAndSend(roytutsExchange, routingKeyRoytuts, name);
		System.out.println("Sent: " + name);
	}

}