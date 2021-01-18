package com.queue.app.service;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import com.queue.app.domain.BookingRequest;

import javax.mail.internet.MimeMessage;

@Service
public class EmailService {

	private TemplateEngine templateEngine;

	private JavaMailSender javaMailSender;

	public EmailService(TemplateEngine templateEngine, JavaMailSender javaMailSender) {
		this.templateEngine = templateEngine;
		this.javaMailSender = javaMailSender;
	}

	public void sendNotification(BookingRequest bookingMessage, boolean status) throws Exception {
		MimeMessage mimeMessage = javaMailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(mimeMessage);
		Context context = new Context();
		context.setVariable("message", bookingMessage);
		String html = null;
		if(!status) html = templateEngine.process("bookingReject", context);
		else html = templateEngine.process("bookingEmail", context);
		helper.setSubject(bookingMessage.getSubject());
		helper.setTo(bookingMessage.getTo());
		helper.setText(html, true);
		// context.setVariables(mail.getProps());
		helper.setFrom(bookingMessage.getFrom());
		javaMailSender.send(mimeMessage);
	}
	
	public void bookingConfirmation(BookingRequest bookingMessage) throws Exception {
		MimeMessage mimeMessage = javaMailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(mimeMessage);
		Context context = new Context();
		context.setVariable("message", bookingMessage);
		String html = null;
	    html = templateEngine.process("confirmation", context);
		helper.setSubject(bookingMessage.getSubject());
		helper.setTo(bookingMessage.getTo());
		helper.setText(html, true);
		// context.setVariables(mail.getProps());
		helper.setFrom(bookingMessage.getFrom());
		javaMailSender.send(mimeMessage);
	}
	
	

}
