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

import com.cg.entity.Booking;
import com.cg.service.BookingService;

@RestController
@RequestMapping("/booking")
public class BookingController {
	
	@Autowired
	BookingService bookingService;
	
	@PostMapping("/addBooking")
	public Booking addBooking(@RequestBody Booking booking)
	{
		Booking resBooking = bookingService.addBooking(booking);
		return resBooking;
	}
	
	@DeleteMapping("/deleteBooking")
	public Optional<Booking> removeBooking(@PathVariable long bookingId)
	{
		 return bookingService.removeBooking(bookingId);
	}
	
	@PutMapping("/update")
	public Booking updateBooking(long bookingId, Booking booking) {
		Optional<Booking> bookingOpt = bookingService.getBooking(booking.getBookingId());
		if(bookingOpt.isPresent())
		{
			return bookingService.updateBooking(bookingId, booking);
		}
		else
		{
			return null;
		}
	}
	
	@GetMapping("/bookingId")
	public Booking find(@PathVariable long bookingId)
	{
		Optional<Booking> optBooking=bookingService.getBooking(bookingId); 
		return optBooking.orElse(null);
	}
	
	
	@GetMapping("/allBookings")
	public List<Booking> getAllBookings()
	{
			return bookingService.getAllBookings();
	}
}