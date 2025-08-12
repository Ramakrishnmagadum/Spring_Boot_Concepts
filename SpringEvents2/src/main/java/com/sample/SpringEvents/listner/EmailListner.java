package com.sample.SpringEvents.listner;

import org.springframework.context.event.EventListener;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import com.sample.SpringEvents.event.TransactionfailuerEvent;

@Component
public class EmailListner {
	
//	# Ordering the Event Listners 
	@Order(2)
	@EventListener
	public void sendEmail(TransactionfailuerEvent event) {
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("Sending the Email");
		System.out.println("Hi "+ event.getName() +" Your Sending Amount "+ event.getAmount()+" Transaction got failed");
	}
}
