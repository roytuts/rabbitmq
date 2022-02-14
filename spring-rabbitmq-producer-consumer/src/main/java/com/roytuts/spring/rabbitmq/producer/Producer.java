package com.roytuts.spring.rabbitmq.producer;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Producer {

	@Autowired
	private Queue queue;

	@Autowired
	private RabbitTemplate rabbitTemplate;

	public void sendMsg(final String msg) {
		rabbitTemplate.convertAndSend(queue.getName(), msg);
		System.out.println("Sent: " + msg);
	}

}
