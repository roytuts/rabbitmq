package com.roytuts.spring.rabbitmq.producer.consumer.config;

import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.roytuts.spring.rabbitmq.consumer.Consumer;
import com.roytuts.spring.rabbitmq.producer.Producer;

@Configuration
public class Config {

	@Value("${queue.name}")
	private String queueName;

	@Bean
	public Queue queue() {
		return new Queue(queueName);
	}

	// @Bean
	public Producer producer() {
		return new Producer();
	}

	// @Bean
	public Consumer consumer() {
		return new Consumer();
	}

}
