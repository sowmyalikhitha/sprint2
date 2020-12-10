package com.cg.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.entity.Customer;
import com.cg.service.CustomerService;
@RestController
@RequestMapping("/customer")
public class CustomerController {
	@Autowired
	CustomerService customerService;
	
	@PostMapping("/add")
	public  Customer add(@RequestBody Customer customer) {
	 Customer cust=customerService.addCustomer(customer);
	return cust;
	}
	@DeleteMapping("/{userId}")
	public void deletecustomer(@PathVariable Long userId) {
		 customerService.deleteCustomer(userId);
	}

	@PutMapping("/{userId}")
	public Customer update(@RequestBody Customer customer, @PathVariable Long userId) {
	   return customerService.editCustomer(customer,userId);
	  
	}

	@GetMapping("/{userId}")
	public Customer find(@RequestBody Customer customer,@PathVariable Long userId) {
		return customerService.getCustomer(customer,userId);
	}
	@GetMapping("/all")
	public List<Customer> getAllCustomers(){
		return customerService.getAllCustomers();
	}
	
}