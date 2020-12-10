package com.cg.service;

import java.util.List;

import com.cg.entity.Payment;

public interface PaymentService {
	
	public Payment addPayment(Payment payment);
	
	public void removePayment(long paymentId);
	
	public Payment updatePayment(long paymentId,Payment payment);
	
	public Payment getPaymentDetails(long paymentId);
	
	public List<Payment> getAllPaymentDetails();
	
}