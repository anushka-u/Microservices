package com.roombooking.service;

import java.util.List;

import org.apache.kafka.common.errors.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.roombooking.repository.RoomRepository;
import com.roombooking.entity.Room;

@Service
public class RoomService {
	
	@Autowired
	public RoomRepository roomRepository;
	
	public List<Room> getRoomDetails()
	{
		return roomRepository.findAll();
	}
	
	public Room addRooms(Room room)
	{
		Room createRoom = new Room();
		createRoom.setCapacity(room.getCapacity());
		createRoom.setRoomNumber(room.getRoomNumber());
		createRoom.setRoomType(room.getRoomType());
		createRoom.setStatus(room.getStatus());
		
		roomRepository.save(createRoom);
		return createRoom;
	}
	
	public void checkoutRoom(int roomNumber) throws ResourceNotFoundException
	{
		Room room = roomRepository.findByRoomNumber(roomNumber);
			if(room!=null) {
				room.setStatus("Free");
				roomRepository.save(room);
			}
			else {
				throw new ResourceNotFoundException("Room not found with roomNumber: " + roomNumber);
			}
	}
	
	public List<Room> roomAvailable(String status)
	{
		List<Room> room = roomRepository.findAllByStatus(status);
		return room;
	}
	
	public List<Room> getAvailableRoomByRoomType(String roomType)
	{
		List<Room> room = roomRepository.findAllByRoomType(roomType);
		return room;
	}

}
