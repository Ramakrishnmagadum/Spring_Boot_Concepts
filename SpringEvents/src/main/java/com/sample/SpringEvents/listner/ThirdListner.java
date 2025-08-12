package com.sample.SpringEvents.listner;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import com.sample.SpringEvents.event.BigBangPojoEvent;

@Component
public class ThirdListner {

	public void watching(int EpisodeNo) {
		System.out.println("Third Listner Is taken Subscription");
		System.out.println("Third Listner Watching the Episode No " + EpisodeNo);
	}
	
	@EventListener
	public void sample(BigBangPojoEvent event) {
		watching(event.getEpisodeNo());
	}
}
