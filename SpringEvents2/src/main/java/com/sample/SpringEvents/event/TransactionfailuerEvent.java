package com.sample.SpringEvents.event;

public class TransactionfailuerEvent {
	private String name;
	private String amount;

	public TransactionfailuerEvent(String name, String amount) {
		this.name = name;
		this.amount = amount;
	}

	public String getName() {
		return name;
	}

	public String getAmount() {
		return amount;
	}
}
