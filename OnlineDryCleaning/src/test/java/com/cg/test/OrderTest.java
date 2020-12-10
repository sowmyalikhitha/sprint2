package com.cg.test;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.time.LocalDate;
import java.time.LocalTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;

import com.cg.OnlineDryCleaningApplication;
import com.cg.entity.Address;
import com.cg.entity.Booking;
import com.cg.entity.Card;
import com.cg.entity.Customer;
import com.cg.entity.Order;
import com.cg.entity.Payment;

@SpringBootTest(classes=OnlineDryCleaningApplication.class, webEnvironment=SpringBootTest.WebEnvironment.RANDOM_PORT)
class OrderModule1ApplicationTests {

	@Autowired
	private TestRestTemplate restTemplate;
	
	@LocalServerPort
	private int port;
	private String getRootUrl() {
		return "http://localhost:"+port;
	}
	
	@Test
	public void testAddOrder() {
    Address address=new Address( "65-1-46", "karanam", "godarigunta" , "kakinada",  "andhra",  533001);
	Customer customer=new Customer(5L,"likhitha","likhitha@gmail.com" ,"63598964585", LocalDate.now() ,address);
	Card card=new Card(10L , "imandi" ,  "2569784626655", LocalDate.now(), "Uco");
	Booking booking=new Booking(10L, LocalDate.now(), LocalTime.now(),"dry-cleaning",customer);
	Payment payment=new Payment(56L , "upi" , "failed" ,card);
	Order order = new Order(9 ,"2569", LocalDate.now(), customer, payment, booking);
	ResponseEntity<Order> postResponse=restTemplate.postForEntity(getRootUrl()+"/order/add", order, Order.class);
	assertNotNull(postResponse);
	assertNotNull(postResponse.getBody());
	}


	
	@Test
		public void testUpdateOrder() {
		  Address address=new Address( "65-1-6", "karanam", "godarigunta" , "kakinada",  "andhra",  533001);
			Customer customer=new Customer(5L,"likhitha","likhitha@gmail.com" ,"63598964585", LocalDate.now() ,address);
			Card card=new Card(10L , "simandi" ,  "2569784626655", LocalDate.now(), "Uco");
			Booking booking=new Booking(10L, LocalDate.now(), LocalTime.now(),"dry-cleaning",customer);
			Payment payment=new Payment(56L , "upi" , "failed" ,card);
			Order order = new Order(9 ,"2569", LocalDate.now(), customer, payment, booking);
			restTemplate.put(getRootUrl()+"/order/update/9", order);
			Order updatedOrder=restTemplate.getForObject(getRootUrl()+"/order/update/9", Order.class);		
			assertNotNull(updatedOrder);
		}
		
		@Test
		public void testDeleteOrder() {
				Order delOrder=restTemplate.getForObject(getRootUrl()+"/order/9", Order.class);
				System.out.println(delOrder);
				assertNull(delOrder);
	}
		

}