package com.queue.app.service;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.queue.app.domain.BookingRequest;

import app.queue.app.common.ApplicationConstants;

@Service
public class MessageListener {

    private static final Logger log = LoggerFactory.getLogger(MessageListener.class);
    @Autowired private EmailService emailService;
    
    @Autowired private BookingService bookingService;
    
    @RabbitListener(queues = ApplicationConstants.QUEUE_GENERIC_NAME)
    public void receiveMessage( Message message) {
        log.info("Received message as generic: {}", message.toString());
    }

    @RabbitListener(queues = ApplicationConstants.QUEUE_SPECIFIC_NAME)
    public void receiveMessage(BookingRequest bookingRequest) throws Exception {
        log.info("Received message as specific class: {}", bookingRequest.toString());
        // checks if slots exists
        boolean isExists = bookingService.checkIfExists(bookingRequest);
        // if slot does not exist save booking
        if(isExists) bookingRequest = bookingService.saveRequest(bookingRequest);
        emailService.sendNotification(bookingRequest, isExists);
    }


}
