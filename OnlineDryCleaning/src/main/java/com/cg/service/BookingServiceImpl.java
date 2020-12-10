package com.cg.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.Repository.BookingRepository;
import com.cg.entity.Booking;
import com.cg.exceptions.BookingNotFoundException;

@Service
@Transactional
public class BookingServiceImpl implements BookingService {
	
	@Autowired
	BookingRepository bookingRepository;

	@Override
	public Booking addBooking(Booking booking) {
		return bookingRepository.save(booking);
	}

	@Override
	public Optional<Booking> removeBooking(long bookingId) {
		Optional<Booking> booking=bookingRepository.findById(bookingId);
		return booking;
	}

	@Override
	public Booking updateBooking(long bookingId, Booking booking)  throws BookingNotFoundException{
		if(bookingRepository.findById(booking.getBookingId())!=null)
		{
			return bookingRepository.save(booking);
		}
		else
		{
			 throw new BookingNotFoundException("id does not exist");
		}
	}

	@Override
	public Optional<Booking> getBooking(long bookingId) {
		Optional<Booking> optBooking = bookingRepository.findById(bookingId);
		return optBooking;
	}

	@Override
	public List<Booking> getAllBookings() {
		List<Booking> allBookings = bookingRepository.findAll();
		return allBookings;
	}
}