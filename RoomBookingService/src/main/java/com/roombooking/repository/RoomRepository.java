package com.roombooking.repository;

import com.roombooking.entity.Room;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomRepository extends JpaRepository<Room,Long> {

	List<Room> findAllByStatus(String status);

	List<Room> findAllByRoomType(String roomType);

	Room findByRoomNumber(int roomNumber);
}
