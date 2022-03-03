package com.roytuts.spring.rabbitmq.pattern.config;

import org.springframework.amqp.core.AnonymousQueue;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.roytuts.spring.rabbitmq.pattern.receiver.Receiver;
import com.roytuts.spring.rabbitmq.pattern.sender.Sender;

@Configuration
public class Config {

	@Value("${topic.xchange.name}")
	private String topicXchangeName;

	@Value("${pattern.key.info}")
	private String patternKeyInfo;

	@Value("${pattern.key.warn}")
	private String patternKeyWarn;

	@Value("${pattern.key.error}")
	private String patternKeyError;

	@Bean
	public TopicExchange topicExchange() {
		return new TopicExchange(topicXchangeName);
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
	public Binding binding11(TopicExchange exchange, Queue deleteQueue1) {
		return BindingBuilder.bind(deleteQueue1).to(exchange).with("*." + patternKeyInfo + ".*");
	}

	@Bean
	public Binding binding12(TopicExchange exchange, Queue deleteQueue1) {
		return BindingBuilder.bind(deleteQueue1).to(exchange).with("*.*." + patternKeyWarn);
	}

	@Bean
	public Binding binding21(TopicExchange exchange, Queue deleteQueue2) {
		return BindingBuilder.bind(deleteQueue2).to(exchange).with(patternKeyError + ".#");
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
