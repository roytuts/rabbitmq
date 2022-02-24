package com.roytuts.spring.rabbitmq.publish;

import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;

public class Sender {

	@Autowired
	private FanoutExchange exchange;

	@Autowired
	private RabbitTemplate rabbitTemplate;

	public void sendMsg(final Integer number) {
		rabbitTemplate.convertAndSend(exchange.getName(), "", number);
		System.out.println("Sent: " + number);
	}

}
