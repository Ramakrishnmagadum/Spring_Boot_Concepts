package com.userlockout.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="xusersession")
public class UserSession {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String username;
	private LocalDate SessionStart; 
	private String IpAddress;
	private String sessionId;
	private int NumberOfRequests;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public LocalDate getSessionStart() {
		return SessionStart;
	}
	public void setSessionStart(LocalDate localDate) {
		SessionStart = localDate;
	}
	public String getIpAddress() {
		return IpAddress;
	}
	public void setIpAddress(String ipAddress) {
		IpAddress = ipAddress;
	}
	public String getSessionId() {
		return sessionId;
	}
	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}
	public int getNumberOfRequests() {
		return NumberOfRequests;
	}
	public void setNumberOfRequests(int numberOfRequests) {
		NumberOfRequests = numberOfRequests;
	}
	@Override
	public String toString() {
		return "usersession [id=" + id + ", username=" + username + ", SessionStart=" + SessionStart + ", IpAddress="
				+ IpAddress + ", sessionId=" + sessionId + ", NumberOfRequests=" + NumberOfRequests + "]";
	}	
}
