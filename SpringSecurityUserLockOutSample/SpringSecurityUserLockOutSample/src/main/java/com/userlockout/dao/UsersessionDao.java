package com.userlockout.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.userlockout.entity.UserSession;


public interface UsersessionDao  extends JpaRepository<UserSession, Integer>{

}
