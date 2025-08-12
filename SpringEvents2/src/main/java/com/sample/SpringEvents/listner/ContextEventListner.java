package com.sample.SpringEvents.listner;

import org.springframework.context.event.ContextClosedEvent;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.ContextStartedEvent;
import org.springframework.context.event.ContextStoppedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class ContextEventListner {

//	# This will trigger when ApplicationContext is refreshed or Initailized ..
	@EventListener
	public void ContextRefreshed(ContextRefreshedEvent event) {
		System.out.println("ContextRefreshedEvent Is started executing ");
		System.out.println("ContextRefreshedEvent End ");
	}
	
//	# This will trigger when ApplicationContext is Closed  using Close() Method..
	@EventListener
	public void ContextClosed(ContextClosedEvent event) {
		System.out.println("ContextClosedEvent Is started executing ");
		System.out.println("ContextClosedEvent End ");
	}
	
//	# This will trigger when ApplicationContext is started using Start() Method..
	@EventListener
	public void ContextStarted(ContextStartedEvent event) {
		System.out.println("ContextStartedEvent Is started executing ");
		System.out.println("ContextStartedEvent End ");
	}
	
//	# This will trigger when ApplicationContext is Stopped  using Stop() Method..
	@EventListener
	public void ContextStopped(ContextStoppedEvent event) {
		System.out.println("ContextStoppedEvent Is started executing ");
		System.out.println("ContextStoppedEvent End ");
	}
}
