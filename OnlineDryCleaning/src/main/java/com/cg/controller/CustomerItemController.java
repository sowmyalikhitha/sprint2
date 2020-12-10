package com.cg.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.entity.CustomerItem;
import com.cg.service.CustomerItemService;

@RestController
@RequestMapping("/customerItem")
public class CustomerItemController {

	@Autowired
	 private CustomerItemService customerItemservice;
	

	@PostMapping("/addCustomerItem")
	public CustomerItem addItem(@RequestBody CustomerItem customerItem) {
		CustomerItem Item = customerItemservice.addItem(customerItem);
		return Item;
	}
	

	@DeleteMapping("/deleteCustomerItem/{itemId}")
	public void deleteItem(@PathVariable int itemId) {
		 customerItemservice.deleteItem(itemId);
	}
	

	@GetMapping("/{itemId}")
	public CustomerItem find(@PathVariable int itemId) {
	Optional<CustomerItem> optCustomerItem=customerItemservice.getItemsByCustomer(itemId); 
	return optCustomerItem.orElse(null);
	}
	
	@GetMapping("/all")
	public List<CustomerItem> getAllCustomerItems(){
		return customerItemservice.getAllCustomerItems();
	}
	
	@PutMapping("/update{itemId}")
	public CustomerItem update(@RequestBody CustomerItem customerItem, @PathVariable int itemId) {
	   return customerItemservice.updateItem(customerItem,itemId);
	  
	}
	

}