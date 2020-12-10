package com.cg.entity;


import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name ="BOOKINGS")
public class Booking {
	
	@Id
	@Column(name = "BOOKING_ID")
	private long bookingId;
	@Column(name = "BOOKING_DATE")
	private LocalDate bookingDate;
	@Column(name = "BOOKING_TIME")
	private LocalTime bookingTime;
	@Column(name = "SERVICETYPE")
	private String serviceType;
	@OneToOne
	@JoinColumn(name= "userId")
	private Customer customerDetails;
	public Booking() {
		super();
		
	}
	public Booking(long bookingId, LocalDate bookingDate, LocalTime bookingTime, String serviceType,
			Customer customerDetails) {
		super();
		this.bookingId = bookingId;
		this.bookingDate = bookingDate;
		this.bookingTime = bookingTime;
		this.serviceType = serviceType;
		this.customerDetails = customerDetails;
	}
	public long getBookingId() {
		return bookingId;
	}
	public void setBookingId(long bookingId) {
		this.bookingId = bookingId;
	}
	public LocalDate getBookingDate() {
		return bookingDate;
	}
	public void setBookingDate(LocalDate bookingDate) {
		this.bookingDate = bookingDate;
	}
	public LocalTime getBookingTime() {
		return bookingTime;
	}
	public void setBookingTime(LocalTime bookingTime) {
		this.bookingTime = bookingTime;
	}
	public String getServiceType() {
		return serviceType;
	}
	public void setServiceType(String serviceType) {
		this.serviceType = serviceType;
	}
	public Customer getCustomerDetails() {
		return customerDetails;
	}
	public void setCustomerDetails(Customer customerDetails) {
		this.customerDetails = customerDetails;
	}
	@Override
	public String toString() {
		return "Booking [bookingId=" + bookingId + ", bookingDate=" + bookingDate + ", bookingTime=" + bookingTime
				+ ", serviceType=" + serviceType + ", customerDetails=" + customerDetails + "]";
	}
	
	

}