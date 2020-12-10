package com.cg.service;

import java.util.List;

import com.cg.entity.User;

public interface IUserService {
	
	public User signIn(User user);
	
	public User signOut(User user);
	
	public List<User> getUser() ;
	
	public User addUser(User user) ;
	
	public User changePassword(User user,Long userId) ;
	
	public void removeUser(User user) ;
	
}
