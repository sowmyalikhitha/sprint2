package com.cg.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//import com.cg.Exceptions.OrderNotFoundException;
import com.cg.service.OrderService;
import com.cg.entity.Order;
import com.cg.exceptions.OrderNotFoundException;

@RestController
@RequestMapping("/order")
public class OrderController {
	
@Autowired
OrderService orderService;

@GetMapping("/all")
public ResponseEntity<List<Order>> findAll(){
	List<Order> orders= orderService.getAllOrders();
	return new ResponseEntity<List<Order>>(orders,HttpStatus.OK);
}

@GetMapping("/{id}")
public ResponseEntity<Order> find(@PathVariable int id) {
	Order order=orderService.getOrder(id);
	if(order==null) {
		throw new OrderNotFoundException("Order not found with the given id");
	}
	return new ResponseEntity<Order>(order,HttpStatus.OK);
}

@PostMapping("/add")
public ResponseEntity<Order> add(@RequestBody Order order){
	Order resorder=orderService.insertOrder(order);

	return new ResponseEntity<Order>(resorder,HttpStatus.OK);
}

@PutMapping("/{id}")
public ResponseEntity<Order> update( @PathVariable int id) {
  Order order= orderService.getOrder(id);
	  if(order==null) {
			throw new OrderNotFoundException("Order not found with the given id");
		}
		return new ResponseEntity<Order>(order,HttpStatus.OK);
}

@DeleteMapping("/{id}")
public List<Order> deleteProduct(@PathVariable int id) {
	return orderService.removeOrder(id);
}
}