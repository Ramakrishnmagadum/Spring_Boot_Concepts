package com.sample.SpringEvents.listner;

import org.springframework.context.event.EventListener;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import com.sample.SpringEvents.event.TransactionfailuerEvent;


@Component
public class SmsListner {
	
//	# Ordering the Event Listners 
	@Order(1)
	@EventListener
	public void sendSMS(TransactionfailuerEvent event) {
		System.out.println("Sending the SMS");
		System.out.println("Hi "+ event.getName() +" Your Sending Amount "+ event.getAmount()+" Transaction got failed");
	}
}
