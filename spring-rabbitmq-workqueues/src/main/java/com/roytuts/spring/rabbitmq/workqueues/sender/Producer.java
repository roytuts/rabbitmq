package com.roytuts.spring.rabbitmq.workqueues.sender;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;

public class Producer {

	@Autowired
	private Queue queue;

	@Autowired
	private RabbitTemplate rabbitTemplate;

	public void sendMsg(final Integer number) {
		rabbitTemplate.convertAndSend(queue.getName(), number);
		System.out.println("Sent: " + number);
	}

}
