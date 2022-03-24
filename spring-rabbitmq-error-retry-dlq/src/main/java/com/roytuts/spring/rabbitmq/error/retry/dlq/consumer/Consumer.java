package com.roytuts.spring.rabbitmq.error.retry.dlq.consumer;

import java.util.regex.Pattern;

import javax.naming.InvalidNameException;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "${queue.roytuts}")
public class Consumer {

	@RabbitHandler
	public void receiveMsg(final String name) throws InvalidNameException {
		if (!Pattern.matches("[a-zA-Z]+", name)) {
			throw new InvalidNameException("Name should contain only alphabets");
		}

		System.out.println("Received: " + name);
	}

}
