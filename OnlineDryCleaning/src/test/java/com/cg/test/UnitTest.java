package com.cg.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;

import com.cg.OnlineDryCleaningApplication;
import com.cg.entity.User;



@SpringBootTest(classes=OnlineDryCleaningApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UnitTest{

	@Autowired
	private TestRestTemplate restTemplate;
	
	@LocalServerPort
	private int port;
	private String getRootUrl() {
		return "Http://localhost:"+port;
	}
	
	@Test
	public void testAddUser() {
		User u=new User();
		u.setUserId(1L);
		u.setPassword("jan");
		u.setRole("admin");
		ResponseEntity<User> postResponse=restTemplate.postForEntity(getRootUrl()+"/users/add",u,User.class);
		assertNotNull(postResponse);
		assertNotNull(postResponse.getBody());
	}
	
	@Test
	public void testUpdatePassword() {
		User u=new User();
		u.setUserId(2L);
		u.setPassword("jana");
		u.setRole("admin");
		restTemplate.put(getRootUrl()+"/users/2", User.class);
		ResponseEntity<User> updated=restTemplate.getForEntity(getRootUrl()+"/users/2", User.class);
		assertNotNull(updated);
	}
	
	@Test
	public void testRemoveUser() {
		User delu=restTemplate.getForObject(getRootUrl()+"/users/delete", User.class);
		System.out.println(delu);
		assertNull(delu);
	}
}