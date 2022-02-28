package com.roytuts.spring.rabbitmq.routing.sender;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

public class Sender {

	@Autowired
	private DirectExchange exchange;

	@Autowired
	private RabbitTemplate rabbitTemplate;

	@Value("${routing.key.info}")
	private String routingKeyInfo;

	@Value("${routing.key.warn}")
	private String routingKeyWarn;

	@Value("${routing.key.error}")
	private String routingKeyError;

	public void sendMsg(final Integer number) {
		final List<String> routings = Arrays.asList(routingKeyInfo, routingKeyWarn, routingKeyError);
		final String routing = routings.get(new Random().nextInt(routings.size()));

		rabbitTemplate.convertAndSend(exchange.getName(), routing, number);

		System.out.println("Sent: " + number);
	}

}
