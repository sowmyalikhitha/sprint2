package com.cg.test;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import com.cg.OnlineDryCleaningApplication;
import com.cg.entity.CustomerItem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;

@SpringBootTest(classes=OnlineDryCleaningApplication.class, webEnvironment=SpringBootTest.WebEnvironment.RANDOM_PORT)
class OneLineDryCleaningApplicationTests {

	@Test
	void contextLoads() {
	}
	@Autowired
	private TestRestTemplate restTemplate;
	
	@LocalServerPort
	private int port;

	private String getRootUrl() {
		return "http://localhost:"+port;
	}
	
	@Test
	public void testAddCustomerItem() {
		CustomerItem customerItem=new CustomerItem();
		//Date date = new java.util.Date();
		customerItem.setItemId(100);
		customerItem.setName("flared top");
		customerItem.setColor("black");
		customerItem.setCategory("clothes");
		customerItem.setQuantity(2);
		customerItem.setMaterial("cotton");
		customerItem.setDescription("dryclean");
		ResponseEntity<CustomerItem> postResponse=restTemplate.postForEntity(getRootUrl()+"/customerItem/add", customerItem, CustomerItem.class);
		assertNotNull(postResponse);
		assertNotNull(postResponse.getBody());
	}
	
	
	@Test
	public void testUpdateCustomerItem() {
		CustomerItem customerItem=restTemplate.getForObject(getRootUrl()+"/customerItem/5", CustomerItem.class);
		customerItem.setItemId(100);
		customerItem.setName("flared top");
		customerItem.setColor("black");
		customerItem.setCategory("clothes");
		customerItem.setQuantity(2);
		customerItem.setMaterial("cotton");
		customerItem.setDescription("dryclean");
		restTemplate.put(getRootUrl()+"/customerItem/update/8", customerItem);
		CustomerItem updatedCustomer=restTemplate.getForObject(getRootUrl()+"/customer/update/5", CustomerItem.class);		
		assertNotNull(updatedCustomer);
	}
	
	@Test
	public void testDeleteCustomerItem() {
		CustomerItem customerItem=restTemplate.getForObject(getRootUrl()+"/customerItem/4", CustomerItem.class);
	
		restTemplate.delete(getRootUrl()+"/customer/4");
		 CustomerItem deletecustomerItem=restTemplate.getForObject(getRootUrl()+"/customerItem/4",CustomerItem.class);
			System.out.println(customerItem);
			assertNotEquals(customerItem,deletecustomerItem);
}
	
}