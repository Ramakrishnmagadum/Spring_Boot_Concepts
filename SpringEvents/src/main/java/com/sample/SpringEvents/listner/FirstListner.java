package com.sample.SpringEvents.listner;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import com.sample.SpringEvents.event.BigBangApplicationEvent;

@Component
public class FirstListner implements ApplicationListener<BigBangApplicationEvent>{

	public void watching(int EpisodeNo) {
		System.out.println("First Listner Is taken Subscription");
		System.out.println("First Listner Watching the Episode No " + EpisodeNo);
	}

	public void onApplicationEvent(BigBangApplicationEvent event) {
		watching(event.getEpisodeNo());
	}
}
