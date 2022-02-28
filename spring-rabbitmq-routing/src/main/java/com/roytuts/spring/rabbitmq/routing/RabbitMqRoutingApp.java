package com.roytuts.spring.rabbitmq.routing;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.roytuts.spring.rabbitmq.routing.sender.Sender;

@SpringBootApplication
public class RabbitMqRoutingApp implements CommandLineRunner {

	@Autowired
	private Sender sender;

	public static void main(String[] args) {
		SpringApplication.run(RabbitMqRoutingApp.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		for (int i = 1000; i < 1010; i++) {
			sender.sendMsg(i);
		}
	}

}
