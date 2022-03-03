package com.roytuts.spring.rabbitmq.pattern.sender;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

public class Sender {

	@Autowired
	private TopicExchange exchange;

	@Autowired
	private RabbitTemplate rabbitTemplate;

	@Value("${pattern.key.info}")
	private String patternKeyInfo;

	@Value("${pattern.key.warn}")
	private String routingKeyWarn;

	@Value("${pattern.key.error}")
	private String routingKeyError;

	public void sendMsg(final Integer number) {
		final List<String> routings = Arrays.asList(patternKeyInfo, routingKeyWarn, routingKeyError);
		final String routing = routings.get(new Random().nextInt(routings.size()));

		rabbitTemplate.convertAndSend(exchange.getName(), routing, routing + number);

		System.out.println("Sent: " + number);
	}

}
