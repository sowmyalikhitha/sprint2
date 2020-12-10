package com.cg.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.Repository.OrderRepository;
import com.cg.entity.Order;

@Service
public class OrderServiceImpl implements OrderService {
	
	@Autowired
	private OrderRepository repository;
	
	@Override
	public List<Order> getAllOrders() {
		List<Order> allOrds=repository.findAll();
		return allOrds;
	}


	@Override
	public Order insertOrder(Order order) {
		return repository.save(order);
	}


	@Override
	public Order getOrder(int id) {
		Order order = repository.findById(id).orElse(null);
		return order;
	}

	@Override
	public List<Order> removeOrder(int id) {
		Order order = repository.findById(id).get();
		repository.delete(order);
		return getAllOrders();
	}

	@Override
	public Order updateOrder(int id) {
		Order order= repository.findById(id).get();
		return repository.save(order);
	}

}