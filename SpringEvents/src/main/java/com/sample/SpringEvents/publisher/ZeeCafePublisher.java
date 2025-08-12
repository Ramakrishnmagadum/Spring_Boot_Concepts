package com.sample.SpringEvents.publisher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import com.sample.SpringEvents.event.BigBangApplicationEvent;
import com.sample.SpringEvents.event.BigBangPojoEvent;
import com.sample.SpringEvents.listner.FirstListner;
import com.sample.SpringEvents.listner.SecondListner;
import com.sample.SpringEvents.listner.ThirdListner;

@Component
public class ZeeCafePublisher {

	@Autowired
	FirstListner firstListner;
	
	@Autowired
	SecondListner secondListner;
	
	@Autowired
	ThirdListner thirdListner;
	
	@Autowired
	ApplicationEventPublisher applicationEventPublisher;
	
	public void BigBangTheory(int EpisodeNo) {
		System.out.println("ZeeCafe Published the BigBagThoery Episode No: " + EpisodeNo);
		
//		Here calling Listerns Mannualy 
//		firstListner.watching(101);
//		secondListner.watching(201);
//		thirdListner.watching(301);

//		# 1st way to work with Event and Listner 
//		Here we are Creating BigBangApplicationEvent By Extending the "ApplicationEvent" Object (So we are passing the Event Type Object here)
//		Listner Obejct we are extending the ApplicationListener<BigBangApplicationEvent> "BigBangApplicationEvent" ---> new BigBangApplicationEvent(this , EpisodeNo) this should be same .
		applicationEventPublisher.publishEvent(new BigBangApplicationEvent(this , EpisodeNo));
		
		
//		# 1st way to work with Event and Listner 
//		Here we are not  Creating Event Type Object ..we are passing Java pojo class as Event class
//		@EventListner Annotation we are using to declare as Listener 
//		Publishing Event Class and In Listner Parameter Should be same--> only matching Listner will trigger...
		applicationEventPublisher.publishEvent(new BigBangPojoEvent( EpisodeNo));
	}
}
