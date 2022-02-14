package com.roytuts.spring.rabbitmq;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.roytuts.spring.rabbitmq.producer.Producer;

@SpringBootApplication
public class RabbitMqProducerConsumerApp implements CommandLineRunner {

	@Autowired
	private Producer producer;

	public static void main(String[] args) {
		SpringApplication.run(RabbitMqProducerConsumerApp.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		producer.sendMsg("This message passes through RabbitMQ broker");
	}

}
