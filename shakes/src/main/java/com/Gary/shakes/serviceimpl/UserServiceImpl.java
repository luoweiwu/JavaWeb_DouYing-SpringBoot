package com.Gary.shakes.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Gary.shakes.domain.User;
import com.Gary.shakes.repository.UserRepostory;
import com.Gary.shakes.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	
	@Autowired
	private UserRepostory userRepository;
	
	@Override
	public void save(User user) {
		userRepository.save(user);
		
	}
	
	@Override
	public boolean judgeTelephone(String telephone) {
		List<User> list = userRepository.judgeTelephone(telephone);
		return list.size()==0?false:true;
	}

	@Override
	public User findUserByTelephone(String telephone) {
		return userRepository.findUserByTelephone(telephone);
	}
}
