package com.roytuts.spring.rabbitmq.rpc.server;

import org.springframework.amqp.rabbit.annotation.RabbitListener;

public class Server {

	@RabbitListener(queues = "${queue.name}")
	public long factorial(int n) {
		System.out.println("Received request for " + n);

		long result = computeFactorial(n);

		System.out.println("Returned " + result);

		return result;
	}

	public long computeFactorial(int number) {
		long result = 1;

		for (int f = 2; f <= number; f++) {
			result *= f;
		}

		return result;
	}

}
