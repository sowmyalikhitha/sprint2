package com.cg.service;



import java.util.List;

import com.cg.entity.Customer;


public interface CustomerService {
	Customer addCustomer(Customer customer);

	void deleteCustomer(Long userId);

	Customer editCustomer(Customer customer,Long userId);

	Customer getCustomer(Customer customer,Long userId);

	List<Customer> getAllCustomers();
}
