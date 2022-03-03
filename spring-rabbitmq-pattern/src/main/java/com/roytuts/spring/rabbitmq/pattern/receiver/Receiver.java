package com.roytuts.spring.rabbitmq.pattern.receiver;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.util.StopWatch;

public class Receiver {

	@RabbitListener(queues = "#{deleteQueue1.name}")
	public void receive1(String msg) throws InterruptedException {
		receiveMsg(msg, 1);
	}

	@RabbitListener(queues = "#{deleteQueue2.name}")
	public void receive2(String msg) throws InterruptedException {
		receiveMsg(msg, 2);
	}

	public void receiveMsg(final String msg, int receiver) {
		StopWatch stopWatch = new StopWatch();
		stopWatch.start();

		System.out.println("Received (" + receiver + "): " + msg);

		Integer integer = extractInt(msg);

		System.out.println("Integer Number (" + receiver + "): " + integer);

		stopWatch.stop();

		System.out.println("Consumer(" + receiver + ") Done in " + stopWatch.getTotalTimeSeconds() + "s");
	}

	private Integer extractInt(String string) {
		String intValue = string.replaceAll("[^0-9]", "");
		return Integer.valueOf(intValue);
	}

}
