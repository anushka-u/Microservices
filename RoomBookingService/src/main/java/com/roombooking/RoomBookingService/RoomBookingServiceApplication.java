package com.roombooking.RoomBookingService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = "com.roombooking.entity")
public class RoomBookingServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(RoomBookingServiceApplication.class, args);
	}

}
