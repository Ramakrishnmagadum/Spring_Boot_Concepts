package com.example;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
 
//----   This is About @PostContructer and @Predestroy...

@RestController
//@RestController --This annotation is combination of  @Controller and @ResponseBody ---> this will work without Html/Jsp Page ...this will diplay in JSON Format..
public class MyFriendsController {
	
	@Autowired
	MyFriends myFriends;
	
	@RequestMapping("/friends/list")
	public List<String> getFriends(){
	return	myFriends.getAlltheFriends();
	}
	
	@RequestMapping("/friends/count")
	public int getFriendsCount(){
	return	myFriends.getAlltheFriendsCount();
	}
	
	@RequestMapping("/friends/add/{friendname}")
	public List<String> AddFriend(@PathVariable String friendname){
		myFriends.addFriend(friendname);
		return myFriends.getAlltheFriends();
	}

}
