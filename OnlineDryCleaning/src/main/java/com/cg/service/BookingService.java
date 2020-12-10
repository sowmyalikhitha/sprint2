package com.cg.service;

import java.util.List;
import java.util.Optional;

import com.cg.entity.Booking;


public interface BookingService {

	
	public Booking addBooking(Booking booking);
	public Optional<Booking> removeBooking(long bookingId);
	public Booking updateBooking(long bookingId, Booking booking);
	public Optional<Booking> getBooking(long bookingId);
	public List<Booking> getAllBookings();
}
