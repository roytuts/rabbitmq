package com.roytuts.spring.rabbitmq.rpc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.roytuts.spring.rabbitmq.rpc.client.Client;

@SpringBootApplication
public class SpringRabbitMqRpcApp implements CommandLineRunner {

	@Autowired
	private Client client;

	public static void main(String[] args) {
		SpringApplication.run(SpringRabbitMqRpcApp.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		for (int i = 1; i < 10; i++) {
			client.send(i);
		}
	}

}
