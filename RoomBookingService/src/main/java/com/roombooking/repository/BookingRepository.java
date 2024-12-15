package com.roombooking.repository;

import com.roombooking.entity.Booking;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingRepository extends JpaRepository<Booking,Long> {
	
	List<Booking> findByUser_UserId(Long userId);
}
