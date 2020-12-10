package com.cg.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cg.Repository.CustomerRepository;
import com.cg.entity.Customer;

@Service

public class CustomerServiceImpl implements CustomerService {
	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public Customer addCustomer(Customer customer) {
		
		Customer custo=customerRepository.save(customer);
		return custo;
	}

	@Override
	public void deleteCustomer(Long userId) {
		customerRepository.deleteById(userId);

	}

	@Override
	public Customer editCustomer(Customer customer,Long userId) {
		return customerRepository.save(customer);
	}

	@Override
	public Customer getCustomer(Customer customer,Long userId) {
		return customerRepository.save(customer);
	}

	@Override
	public List<Customer> getAllCustomers() {
		List<Customer> allcustomers = customerRepository.findAll();
		return allcustomers;

	}

}
