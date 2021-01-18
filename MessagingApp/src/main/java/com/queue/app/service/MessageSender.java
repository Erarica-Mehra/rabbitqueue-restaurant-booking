package com.queue.app.service;


import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.queue.app.domain.BookingRequest;

import app.queue.app.common.ApplicationConstants;


@Service
public class MessageSender {

    private static final Logger log = LoggerFactory.getLogger(MessageSender.class);
    
    @Autowired private final RabbitTemplate rabbitTemplate;

    public MessageSender(final RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public String sendMessage(BookingRequest request) {
    	log.info("Sending message...");
    	//TODO validate and return message
        rabbitTemplate.convertAndSend(ApplicationConstants.EXCHANGE_NAME, ApplicationConstants.ROUTING_KEY, request);
        return "Request is being processed. You will receive a notification in 2 - 3 mins";
    }
}
