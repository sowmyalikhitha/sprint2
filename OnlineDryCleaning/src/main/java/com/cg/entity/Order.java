package com.cg.entity;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="order_master")
public class Order {
	
@Id
@GeneratedValue
@Column(name="order_id")
private int id;
@Column(name="order_amount")
private String amount;
@Column(name="billing_date")
private LocalDate billingdate;

@ManyToOne(cascade = CascadeType.ALL)
@JoinColumn(name = "USER_ID")
private Customer customer;

@OneToOne(cascade=CascadeType.ALL)
@JoinColumn(name="payment_id")
private Payment payment;

@OneToOne(cascade=CascadeType.ALL)
@JoinColumn(name="BOOKING_ID")
private Booking booking;
public Order() {
	super();
	// TODO Auto-generated constructor stub
}
public Order(int id, String amount, LocalDate billingdate,Customer customer,Payment payment,Booking booking) {
	super();
	this.id = id;
	this.amount = amount;
	this.billingdate = billingdate;
	this.customer=customer;
	this.payment=payment;
}
public int getId() {
	return id;
}
public Booking getBooking() {
	return booking;
}
public void setBooking(Booking booking) {
	this.booking = booking;
}
public void setId(int id) {
	this.id = id;
}
public String getAmount() {
	return amount;
}
public Payment getPayment() {
	return payment;
}
public void setPayment(Payment payment) {
	this.payment = payment;
}
public Customer getCustomer() {
	return customer;
}
public void setCustomer(Customer customer) {
	this.customer = customer;
}
public void setAmount(String amount) {
	this.amount = amount;
}
public LocalDate getBillingdate() {
	return billingdate;
}
public void setBillingdate(LocalDate billingdate) {
	this.billingdate = billingdate;
}
@Override
public String toString() {
	return "Order [id=" + id + ", amount=" + amount + ", billingdate=" + billingdate + ", customer=" + customer
			+ ", payment=" + payment + ", booking=" + booking + "]";
}
}