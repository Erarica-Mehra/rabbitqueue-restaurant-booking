package com.queue.app.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.queue.app.domain.BookingRequest;
import com.queue.app.service.BookingService;
import com.queue.app.service.EmailService;
import com.queue.app.service.MessageSender;

@RestController
@RequestMapping(value = "/booking")
public class AppController {

	@Autowired
	private MessageSender sender;
	@Autowired
	EmailService emailService;
	
	@Autowired
	private BookingService bookingService;

	@RequestMapping(value = "/send")
	@PostMapping
	public String begin(@RequestBody BookingRequest request) {
		String response = null;
		request.setStatus(false);
		response = sender.sendMessage(request);
		return response;
	}

	@RequestMapping(value = "/approve/{id}/{status}")
	@PostMapping
	public String approveRequest(@PathVariable Integer id, @PathVariable Boolean status) {
		BookingRequest bookingRequest = bookingService.getBookingRequest(id);
		bookingRequest = bookingService.changeStatus(bookingRequest, status);
		try {
			emailService.sendNotification(bookingRequest, status);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "Status Changed";
	}
}
