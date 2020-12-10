package com.cg.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.Repository.UserRepository;
import com.cg.entity.User;
//import com.cg.demo.exception.UserNotFoundException;


@Service
public class UserServiceImpl implements IUserService{
	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public User signIn(User user) {
		if(user==null) {
			return null;
		}
		else {
		return user;
		}
	}
	
	@Override
	public User signOut(User user) {
		if(user==null) {
			return null;
		}
		else {
			return user;
		}
	}
	@Override
	public User addUser(User user) {
			return userRepository.save(user);
		}
	
	@Override
	public List<User> getUser() {
		return userRepository.findAll();
	}

	@Override
	public void removeUser(User user) {
		userRepository.delete(user);
			
	}

   @Override
	public User changePassword(User user, Long userId){
			return userRepository.save(user);
		}

}
