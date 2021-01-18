package com.queue.app.repository;

import java.io.Serializable;
import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.queue.app.domain.BookingRequest;

@Repository
public interface BookingRequestRepository extends JpaRepository<BookingRequest, Serializable>{

	BookingRequest findByRestaurantAndDateAndSlot(String restaurant, Date date, String slot);
	
}
