package com.Gary.shakes.service;

import org.springframework.stereotype.Service;

import com.Gary.shakes.domain.User;


public interface UserService {
	
	void save(User user);
	boolean judgeTelephone(String telephone);
	User findUserByTelephone(String telephone);
	
}
