package com.roytuts.spring.rabbitmq.routing.receiver;

import java.math.BigInteger;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.util.StopWatch;

public class Receiver {

	@RabbitListener(queues = "#{deleteQueue1.name}")
	public void receive1(Integer num) throws InterruptedException {
		receiveMsg(num, 1);
	}

	@RabbitListener(queues = "#{deleteQueue2.name}")
	public void receive2(Integer num) throws InterruptedException {
		receiveMsg(num, 2);
	}

	public void receiveMsg(final Integer number, int receiver) {
		StopWatch stopWatch = new StopWatch();
		stopWatch.start();

		System.out.println("Received (" + receiver + "): " + number);

		BigInteger nextPrime = nextPrime(number);

		System.out.println("Next Prime Number (" + receiver + "): " + nextPrime);

		stopWatch.stop();

		System.out.println("Consumer(" + receiver + ") Done in " + stopWatch.getTotalTimeSeconds() + "s");
	}

	private BigInteger nextPrime(int number) {
		BigInteger veryBig = new BigInteger(String.valueOf(number));
		return veryBig.nextProbablePrime();
	}

}
