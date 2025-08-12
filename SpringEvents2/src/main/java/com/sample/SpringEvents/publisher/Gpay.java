package com.sample.SpringEvents.publisher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

import com.sample.SpringEvents.event.TransactionfailuerEvent;

@Component
public class Gpay {

	@Autowired
	ApplicationEventPublisher applicationEventPublisher;

	public void sendMoney(String name, String amount, boolean flag) {
		if (flag) {
			System.out.println("sendMoney() :  Transaction is going on ...");
			applicationEventPublisher.publishEvent(new TransactionfailuerEvent(name , amount));
			throw new RuntimeException("sendMoney() :  Hi " + name + " Transaction failed ");
		}
		System.out.println("sendMoney() : Hi " + name + " Your amount " + amount + " transaction successfully ");
	}
}
