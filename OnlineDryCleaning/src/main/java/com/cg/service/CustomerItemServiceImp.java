package com.cg.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.Repository.CustomerItemRepository;
import com.cg.entity.CustomerItem;


@Service
@Transactional
public   class CustomerItemServiceImp implements CustomerItemService{
	
	
	@Autowired
	private CustomerItemRepository customerItemRepository;

	@Override
	public CustomerItem addItem(CustomerItem item) {
		
		return customerItemRepository.save(item);
	}

	@Override
	public void deleteItem(int itemId) {
		
		customerItemRepository.deleteById(itemId);
		
	}

	@Override
	public CustomerItem updateItem( CustomerItem item, int itemId) {
		if (customerItemRepository.findById(item.getItemId()) != null) {
			return customerItemRepository.save(item);
		} else {
			return null;

		}
	}

	@Override
	public Optional<CustomerItem> getItemsByCustomer(int itemId) {
		Optional<CustomerItem> optcustomerItem = customerItemRepository.findById(itemId);
		return optcustomerItem;
	}

	@Override
	public List<CustomerItem> getAllCustomerItems() {
		List<CustomerItem> allcustomerItems = customerItemRepository.findAll();
		return allcustomerItems;

	}

	}