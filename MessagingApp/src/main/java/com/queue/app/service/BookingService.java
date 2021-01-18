package com.queue.app.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.queue.app.domain.BookingRequest;
import com.queue.app.repository.BookingRequestRepository;

@Service
public class BookingService {
	
	@Autowired BookingRequestRepository bookingRepo;
	
	public BookingRequest saveRequest(BookingRequest bookingRequest) {
		bookingRequest.setStatus(true);
		return bookingRepo.save(bookingRequest);
	}
	
	public BookingRequest getBookingRequest(Integer id) {
		Optional<BookingRequest>  bookings = bookingRepo.findById(id);
		BookingRequest booking = null;
		try {
		booking= bookings.get();
		} catch (Exception e) {
			return null;
		}
		return booking;
	}
	
	public BookingRequest changeStatus(BookingRequest booking, boolean status) {
		booking.setStatus(status);
		return bookingRepo.save(booking);
	}
	
	public boolean checkIfExists(BookingRequest bookingRequest) {
		BookingRequest request = bookingRepo.findByRestaurantAndDateAndSlot(bookingRequest.getRestaurant(), bookingRequest.getDate(), bookingRequest.getSlot());
		if (request != null && request.getStatus() == true)
			return true;
		return false;
	}

}
