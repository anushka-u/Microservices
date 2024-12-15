package com.roombooking.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.roombooking.dto.BookingDto;
import com.roombooking.entity.Booking;
import com.roombooking.entity.Room;
import com.roombooking.entity.User;
import com.roombooking.repository.BookingRepository;
import com.roombooking.repository.RoomRepository;
import com.roombooking.repository.UserRepository;

@Service
public class BookingService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoomRepository roomRepository;

    @Autowired
    private BookingRepository bookingRepository;

    // Create custom exception for better error handling
    public static class EntityNotFoundException extends RuntimeException {
        public EntityNotFoundException(String message) {
            super(message);
        }
    }

    public String doBooking(BookingDto bookingDTO) {
        // Handle null checks before accessing User or Room fields
        if (bookingDTO.getUser() == null || bookingDTO.getRoom() == null) {
            throw new IllegalArgumentException("User and Room data must not be null");
        }

        User user = userRepository.findById(bookingDTO.getUser().getUserId())
            .orElseThrow(() -> new EntityNotFoundException("User not found"));

        Room room = roomRepository.findById(bookingDTO.getRoom().getRoomId())
            .orElseThrow(() -> new EntityNotFoundException("Room not found"));

        // Creating Booking entity and setting fields
        Booking booking = new Booking();
        booking.setUser(user);
        booking.setRoom(room);
        booking.setStartDate(bookingDTO.getStartDate());
        booking.setEndTime(bookingDTO.getEndTime());
        booking.setBookingStatus(bookingDTO.getBookingStatus());

        // Save and return the booking
        bookingRepository.save(booking);
        
        return "Booking Successfull";
    }
    
    public List<Booking> getBookingDetails(){
    	return bookingRepository.findAll();
    }
    
    public Booking cancelBooking(Long bookingId)
    {
    	Booking booking = bookingRepository.findById(bookingId).orElseThrow(()-> new EntityNotFoundException("Booking doesn't exist"));
    	bookingRepository.deleteById(bookingId);
    	return booking; 
    }
    
    
    public Booking getBookingDetailByBookingId(Long BookingId)
    {
    	Booking booking = bookingRepository.findById(BookingId).orElseThrow(()-> new EntityNotFoundException("Booking doesn't exist"));
    	return booking;
    }
    
    public List<Booking> getBookingByUserId(Long userId)
    {
    	return bookingRepository.findByUser_UserId(userId);
    }
}
