package com.roytuts.spring.rabbitmq.routing.config;

import org.springframework.amqp.core.AnonymousQueue;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.roytuts.spring.rabbitmq.routing.receiver.Receiver;
import com.roytuts.spring.rabbitmq.routing.sender.Sender;

@Configuration
public class Config {

	@Value("${direct.xchange.name}")
	private String directXchangeName;

	@Value("${routing.key.info}")
	private String routingKeyInfo;

	@Value("${routing.key.warn}")
	private String routingKeyWarn;

	@Value("${routing.key.error}")
	private String routingKeyError;

	@Bean
	public DirectExchange directExchange() {
		return new DirectExchange(directXchangeName);
	}

	@Bean
	public Queue deleteQueue1() {
		return new AnonymousQueue();
	}

	@Bean
	public Queue deleteQueue2() {
		return new AnonymousQueue();
	}

	@Bean
	public Binding binding11(DirectExchange exchange, Queue deleteQueue1) {
		return BindingBuilder.bind(deleteQueue1).to(exchange).with(routingKeyInfo);
	}

	@Bean
	public Binding binding12(DirectExchange exchange, Queue deleteQueue1) {
		return BindingBuilder.bind(deleteQueue1).to(exchange).with(routingKeyWarn);
	}

	@Bean
	public Binding binding21(DirectExchange exchange, Queue deleteQueue2) {
		return BindingBuilder.bind(deleteQueue2).to(exchange).with(routingKeyWarn);
	}

	@Bean
	public Binding binding22(DirectExchange exchange, Queue deleteQueue2) {
		return BindingBuilder.bind(deleteQueue2).to(exchange).with(routingKeyError);
	}

	@Bean
	public Receiver receiver() {
		return new Receiver();
	}

	@Bean
	public Sender sender() {
		return new Sender();
	}

}
