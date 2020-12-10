package com.cg.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.Repository.PaymentRepository;
import com.cg.entity.Payment;

@Service
public class PaymentServiceImpl implements PaymentService{

	@Autowired
	PaymentRepository paymentRepository;
	
	@Override
	public Payment addPayment(Payment payment) {
		return paymentRepository.save(payment);
	}

	@Override
	public void removePayment(long paymentId) {
		paymentRepository.deleteById(paymentId);
	}

	@Override
	public Payment updatePayment(long paymentId, Payment payment) {
		return paymentRepository.save(payment);
	}

	@Override
	public Payment getPaymentDetails(long paymentId) {
		return paymentRepository.getOne(paymentId);
	}

	@Override
	public List<Payment> getAllPaymentDetails() {
		return paymentRepository.findAll();
	}
	
	
}