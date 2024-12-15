package com.roombooking.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.roombooking.entity.Booking;
import com.roombooking.entity.Payment;
import com.roombooking.repository.BookingRepository;
import com.roombooking.repository.PaymentRepository;
import com.roombooking.service.BookingService.EntityNotFoundException;

@Service
public class PaymentService {

	@Autowired
	private PaymentRepository paymentRepository;
	
	@Autowired
	private BookingRepository bookingRepository;
	
	public String doPayment(Payment payment)
	{
		if(payment.getBooking() == null)
		{
			throw new IllegalArgumentException("Booking doesn't exist");
		}
		Booking booking = bookingRepository.findById(payment.getBooking().getBookingId())
				.orElseThrow(() -> new EntityNotFoundException("User not found"));
		
		Payment createPayment = new Payment();
		createPayment.setAmountToPay(payment.getAmountToPay());
		createPayment.setBooking(booking);
		createPayment.setPaymentDate(payment.getPaymentDate());
		createPayment.setPaymentStatus(payment.getPaymentStatus());
		
		paymentRepository.save(createPayment);
		
		return "Payment successfull";
	}
}
