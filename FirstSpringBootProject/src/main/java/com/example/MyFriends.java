package com.example;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.stereotype.Component;

@Component
public class MyFriends {

	List<String> friendslist;

	@PostConstruct
	public void init() {
		System.out.println("doing some init stufsss...");
		friendslist = new ArrayList<String>();
		friendslist.add("ramakrishna");
		friendslist.add("ABC");
		friendslist.add("XYZ");
	}

	public List<String> getAlltheFriends() {
		return friendslist;
	}

	public int getAlltheFriendsCount() {
		return friendslist.size();
	}

	public List<String> addFriend(String friendName) {
		friendslist.add(friendName);
		return friendslist;
	}
	
	@PreDestroy
	public void Destroy() {
		System.out.println("Destroying MyFriends Class.....");
	}
}
