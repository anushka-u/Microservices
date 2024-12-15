package com.roombooking.dto;

import java.time.LocalDate;

import com.roombooking.entity.Room;
import com.roombooking.entity.User;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class BookingDto {

	 private Long bookingId;
	 private User user;
	 private Room room;
	 private LocalDate startDate;
	 private LocalDate endTime;
	 private String bookingStatus;
}
