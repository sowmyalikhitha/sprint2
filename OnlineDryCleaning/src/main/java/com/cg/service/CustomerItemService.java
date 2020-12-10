package com.cg.service;

import java.util.List;
import java.util.Optional;

import com.cg.entity.CustomerItem;

public interface CustomerItemService {
	public CustomerItem addItem(CustomerItem item);
	public void deleteItem(int itemId);
	public CustomerItem updateItem( CustomerItem item, int itemId);
	Optional<CustomerItem> getItemsByCustomer(int itemId);
	List<CustomerItem> getAllCustomerItems();

}