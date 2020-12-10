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

import com.cg.entity.Payment;
import com.cg.exceptions.PaymentDetailsNotFoundException;
import com.cg.service.PaymentService;


@RestController
@RequestMapping("/payments")
public class PaymentController {

	@Autowired
	PaymentService paymentService;
	
	@PostMapping("/add")
	public Payment addPayment(@RequestBody Payment payment) {
		return paymentService.addPayment(payment);
	}
	
	@DeleteMapping("/{paymentId}")
	public void removePayment(@PathVariable long paymentId) {
		paymentService.removePayment(paymentId);
	}
	
	@PutMapping("/{paymentId}")
	public ResponseEntity<Payment> updatePayment(@PathVariable long paymentId,@RequestBody Payment payment) {
		Payment pay=paymentService.updatePayment(paymentId,payment);
		if(pay==null) {
			throw new PaymentDetailsNotFoundException("Payment details not found");
		}
		return new ResponseEntity<Payment>(pay, HttpStatus.OK);
	}

	@GetMapping("/{paymentId}")
	public ResponseEntity<Payment> getPaymentDetails(@PathVariable long paymentId) {
		Payment pay=paymentService.getPaymentDetails(paymentId);
		if(pay==null) {
			throw new PaymentDetailsNotFoundException("Payment details with given id is not found");
		}
		return new ResponseEntity<Payment>(pay, HttpStatus.OK);
	}
	
	@GetMapping("/all")
	public List<Payment> getAllPaymentDetails() {
		return paymentService.getAllPaymentDetails();
	}
	
}