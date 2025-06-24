package com.sample.SpringProject.PropertySourceone;

public class Film {
	private Actor actor;

	public Film(Actor actor) {
		this.actor = actor;
	}

	public void startfilming() {
		actor.act();
	}
}
