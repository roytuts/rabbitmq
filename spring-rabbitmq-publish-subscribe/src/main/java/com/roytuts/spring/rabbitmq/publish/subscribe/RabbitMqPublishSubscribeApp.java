package com.roytuts.spring.rabbitmq.publish.subscribe;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.roytuts.spring.rabbitmq.publish.Sender;

@SpringBootApplication
public class RabbitMqPublishSubscribeApp implements CommandLineRunner {

	@Autowired
	private Sender sender;

	public static void main(String[] args) {
		SpringApplication.run(RabbitMqPublishSubscribeApp.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		for (int i = 10000; i < 10010; i++) {
			sender.sendMsg(i);
		}
	}

}
