package com.cg.service;

import java.util.List;

import com.cg.entity.Order;

public interface OrderService {
   
	public Order insertOrder(Order order);

	public List<Order> getAllOrders();

	public Order getOrder(int id);

	public List<Order> removeOrder(int id);

	Order updateOrder(int id);

}