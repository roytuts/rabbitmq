package com.roytuts.spring.rabbitmq.pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.roytuts.spring.rabbitmq.pattern.sender.Sender;

@SpringBootApplication
public class RabbitMqPatternApp implements CommandLineRunner {

	@Autowired
	private Sender sender;

	public static void main(String[] args) {
		SpringApplication.run(RabbitMqPatternApp.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		for (int i = 1000; i < 1010; i++) {
			sender.sendMsg(i);
		}
	}

}
