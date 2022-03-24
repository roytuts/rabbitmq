package com.roytuts.spring.rabbitmq.error.retry.dlq;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.roytuts.spring.rabbitmq.error.retry.dlq.producer.Producer;

@SpringBootApplication
public class SpringRabbitMqDlqApp implements CommandLineRunner {

	@Autowired
	private Producer producer;

	public static void main(String[] args) {
		SpringApplication.run(SpringRabbitMqDlqApp.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		producer.sendName("Soumitra");
		producer.sendName("Roy");
		producer.sendName("Roy Tutorials");
		producer.sendName("Soumitra 2");
		producer.sendName("Roy Tutorials2");
	}

}
