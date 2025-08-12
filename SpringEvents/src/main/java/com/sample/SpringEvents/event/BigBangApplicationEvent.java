package com.sample.SpringEvents.event;

import org.springframework.context.ApplicationEvent;

public class BigBangApplicationEvent extends ApplicationEvent{

	private int episodeNo;
	
	public BigBangApplicationEvent(Object source) {
		super(source);
	}

	public BigBangApplicationEvent(Object source, int episodeNo) {
		super(source);
		this.episodeNo = episodeNo;
	}

	public int getEpisodeNo() {
		return episodeNo;
	}

}
