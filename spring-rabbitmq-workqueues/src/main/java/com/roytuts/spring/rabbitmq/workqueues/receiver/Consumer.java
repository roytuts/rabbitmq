package com.roytuts.spring.rabbitmq.workqueues.receiver;

import java.math.BigInteger;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.util.StopWatch;

@RabbitListener(queues = "${queue.name}")
public class Consumer {

	private final int srNo;

	public Consumer(int srNo) {
		this.srNo = srNo;
	}

	@RabbitHandler
	public void receiveMsg(final Integer number) {
		StopWatch stopWatch = new StopWatch();
		stopWatch.start();

		System.out.println("Received (" + srNo + "): " + number);

		BigInteger nextPrime = nextPrime(number);

		System.out.println("Next Prime Number: " + nextPrime);

		stopWatch.stop();

		System.out.println("Consumer(" + srNo + ") Done in " + stopWatch.getTotalTimeSeconds() + "s");
	}

	private BigInteger nextPrime(int number) {
		BigInteger veryBig = new BigInteger(String.valueOf(number));
		return veryBig.nextProbablePrime();
	}

}
