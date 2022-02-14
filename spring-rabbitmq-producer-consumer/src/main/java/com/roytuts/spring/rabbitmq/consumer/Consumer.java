package com.roytuts.spring.rabbitmq.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "${queue.name}")
public class Consumer {

	@RabbitHandler
	public void receiveMsg(final String msg) {
		System.out.println("Received: " + msg);
	}

}
