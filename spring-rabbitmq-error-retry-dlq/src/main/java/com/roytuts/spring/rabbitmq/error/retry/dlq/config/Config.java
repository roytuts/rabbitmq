package com.roytuts.spring.rabbitmq.error.retry.dlq.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.QueueBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

	@Value("${exchange.dl}")
	private String dlExchange;

	@Value("${exchange.roytuts}")
	private String roytutsExchange;

	@Value("${queue.dl}")
	private String dlQueue;

	@Value("${queue.roytuts}")
	private String roytutsQueue;

	@Value("${routing.key.dl}")
	private String routingKeyDl;

	@Value("${routing.key.roytuts}")
	private String routingKeyRoytuts;

	@Bean
	public DirectExchange dlExchange() {
		return new DirectExchange(dlExchange);
	}

	@Bean
	public DirectExchange roytutsExchange() {
		return new DirectExchange(roytutsExchange);
	}

	@Bean
	public Queue dlq() {
		return QueueBuilder.durable(dlQueue).build();
	}

	@Bean
	public Queue queue() {
		return QueueBuilder.durable(roytutsQueue).withArgument("x-dead-letter-exchange", dlExchange)
				.withArgument("x-dead-letter-routing-key", routingKeyDl).build();
	}

	@Bean
	public Binding binding() {
		return BindingBuilder.bind(queue()).to(roytutsExchange()).with(routingKeyRoytuts);
	}

	@Bean
	public Binding dlqBinding() {
		return BindingBuilder.bind(dlq()).to(dlExchange()).with(routingKeyDl);
	}

}
