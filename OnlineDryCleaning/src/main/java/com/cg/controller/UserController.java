package com.cg.controller;

import java.util.List;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.cg.entity.User;
import com.cg.service.IUserService;

@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	IUserService userService;
	
	@GetMapping("/all")
	public ResponseEntity<List<User>> getUser() {
		return new ResponseEntity<List<User>>(userService.getUser(), HttpStatus.OK);
	}
	
	@PostMapping("/add")
	public User addUser(@Valid @RequestBody User user) {
		return userService.addUser(user);
	}
	
	
	@PutMapping("/{userId}")
	public ResponseEntity<User> changePassword(@RequestBody User user,@PathVariable  Long userId) {
		 return new ResponseEntity<User>(userService.changePassword(user,userId), HttpStatus.OK);
	}
	
	@DeleteMapping("/delete")
	public void removeUser(@RequestBody User user) {
		userService.removeUser(user);
	}
	
	@PostMapping("/signin")
	public ResponseEntity<Object> signIn( @RequestBody User user) {
		User u=userService.signIn(user);
		if(u==null) {
			return new ResponseEntity<>("no user found", HttpStatus.NOT_FOUND);
		}
		return ResponseEntity.ok("Login successfull");
		
	}
	
	@PostMapping("/signout")
	public ResponseEntity<Object> signOut(@RequestBody User user) {
		User u= userService.signOut(user);
		if(u==null) {
			return new ResponseEntity<>("no user found", HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>("Signed out successfully", HttpStatus.ACCEPTED);
	}
}
