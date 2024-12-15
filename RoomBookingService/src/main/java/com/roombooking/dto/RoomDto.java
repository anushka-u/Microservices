package com.roombooking.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RoomDto {
	private Long roomId;
   
    private int roomNumber;
   
    private String roomType;
    
    private int capacity;
    
    private String status;
}
