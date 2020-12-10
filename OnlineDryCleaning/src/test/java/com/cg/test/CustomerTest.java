package com.cg.test;

import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import com.cg.OnlineDryCleaningApplication;
import com.cg.entity.Address;
import com.cg.entity.Customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;

@SpringBootTest(classes=OnlineDryCleaningApplication.class, webEnvironment=SpringBootTest.WebEnvironment.RANDOM_PORT)
class CustomerTest {

	@Autowired
	private TestRestTemplate restTemplate;
	
	@LocalServerPort
	private int port;
	private String getRootUrl() {
		return "Http://localhost:"+port;
	}
	
	@Test
	public void testAddOrder() {
    Address address=new Address( "65", "snoopy", "greamspet" , "hyd",  "telangana",  213451);
	Customer customer=new Customer(5L,"harini","harani@gmail.com" ,"973853585", LocalDate.now() ,address);
	ResponseEntity<Customer> postResponse=restTemplate.postForEntity(getRootUrl()+"/customer/add", customer, Customer.class);
	assertNotNull(postResponse);
	assertNotNull(postResponse.getBody());
	}
	@Test
	public void testUpdateOrder() {
	  Address address=new Address( "65-1-6", "teddy", "vidyanagar" , "chittoor",  "andhra",  533001);
		Customer customer=new Customer(5L,"komla","komli@gmail.com" ,"63598964585", LocalDate.now() ,address);
		restTemplate.put(getRootUrl()+"/order/update/4",customer);
		Customer updatedOrder=restTemplate.getForObject(getRootUrl()+"/customer/update/4", Customer.class);		
		assertNotNull(updatedOrder);
	}
	
	@Test
	public void testDeleteOrder() {
			Customer delOrder=restTemplate.getForObject(getRootUrl()+"/customer/1", Customer.class);
			System.out.println(delOrder);
			assertNull(delOrder);
}
	
}