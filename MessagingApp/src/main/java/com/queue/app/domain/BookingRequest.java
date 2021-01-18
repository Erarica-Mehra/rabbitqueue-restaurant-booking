package com.queue.app.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "bookings")
public class BookingRequest implements Serializable {

	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "username")
	private String userName;
	
	@Column(name = "restaurant")
	private String restaurant;
	
	@Column(name = "special_request")
	private String text;
	
	@Column(name = "reply_to")
	private String to;
	
	@Column(name = "request_from")
	private String from;
	
	@Column(name = "subject")
	private String subject;
	
	@Column(name = "date_request")
	private Date date;
	
	@Column(name = "slot")
	private String slot;
	
	@Column(name = "status")
	private boolean status;
	
	public BookingRequest() {
		super();
	}

	public boolean getStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public BookingRequest(@JsonProperty("userName") String userName, @JsonProperty("text") String text,
			@JsonProperty("restaurant") String restaurant, @JsonProperty("to") String to,
			@JsonProperty("from") String from, @JsonProperty("subject") String subject, @JsonProperty("date") Date date,
			@JsonProperty("slot") String slot) {
		this.text = text;
		this.to = to;
		this.from = from;
		this.subject = subject;
		this.userName = userName;
		this.date = date;
		this.slot = slot;
		this.restaurant = restaurant;
	}

	public String getSlot() {
		return slot;
	}

	public void setSlot(String slot) {
		this.slot = slot;
	}

	public String getText() {
		return text;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getRestaurant() {
		return restaurant;
	}

	public void setRestaurant(String restaurant) {
		this.restaurant = restaurant;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public void setText(String text) {
		this.text = text;
	}


}
