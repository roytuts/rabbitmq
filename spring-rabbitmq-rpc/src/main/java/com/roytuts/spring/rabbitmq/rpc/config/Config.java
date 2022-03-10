package com.roytuts.spring.rabbitmq.rpc.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.roytuts.spring.rabbitmq.rpc.client.Client;
import com.roytuts.spring.rabbitmq.rpc.server.Server;

@Configuration
public class Config {

	@Value("${queue.name}")
	private String queueName;

	@Value("${xchange.name}")
	private String directXchangeName;

	@Bean
	public Queue queue() {
		return new Queue(queueName);
	}

	@Bean
	public DirectExchange directExchange() {
		return new DirectExchange(directXchangeName);
	}

	@Bean
	public Binding binding(DirectExchange exchange, Queue queue) {
		return BindingBuilder.bind(queue).to(exchange).with("roytuts");
	}

	@Bean
	public Client client() {
		return new Client();
	}

	@Bean
	public Server server() {
		return new Server();
	}

}