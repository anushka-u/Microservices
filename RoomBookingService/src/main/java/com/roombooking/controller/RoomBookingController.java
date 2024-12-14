package com.roombooking.controller;

import com.roombooking.entity.Room;
import com.roombooking.entity.User;
import com.roombooking.service.RoomService;
import com.roombooking.service.UserService;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/roombooking")
public class RoomBookingController {

    @Autowired
    private UserService userService;
    
    @Autowired
    private RoomService roomService;
    
    @GetMapping("/getUser")
    public ResponseEntity<List<User>> getUser()
    {
    	List<User> users = userService.getUser();
		return ResponseEntity.ok(users) ;
    	
    }
    
    @GetMapping("/getUser/{userId}")
    public ResponseEntity<User> getSingleUser(@PathVariable Long userId)
    {
    	User getExistingUser = userService.getSingleUser(userId);
    	return ResponseEntity.ok(getExistingUser);
    }

    // POST endpoint to create a user
    @PostMapping("/createUser")
    public ResponseEntity<User> addUser(@RequestBody User user) {
        // Save the user and return the saved user as response
        User savedUser = userService.saveUser(user);
        return ResponseEntity.ok(savedUser);
    }
    
    
    @PutMapping("/updateUser/{userId}")
    public ResponseEntity<User> updateUserDetail(@PathVariable Long userId,@RequestBody User user)
    {
    	User saveUser= userService.updateUser(userId, user);
		return ResponseEntity.ok(saveUser);
    	
    }
    
    @DeleteMapping("/deleteUser/{userId}")
    public ResponseEntity<User> deleteUser(@PathVariable Long userId)
    {
    	Optional<User> removedUser = userService.deleteUSerById(userId);
    	return ResponseEntity.ok(removedUser.get());
    }
    
    
    @GetMapping("/getRoomdetails")
    public ResponseEntity<List<Room>> getAllRooms() {
    	List<Room> room = roomService.getRoomDetails();
    	return ResponseEntity.ok(room);
    }
    
    @GetMapping("/getRoom/{roomType}")
    public ResponseEntity<List<Room>> getRoomByType(@PathVariable("roomType") String roomType)
    {
    	List<Room> room = roomService.getAvailableRoomByRoomType(roomType);
    	return ResponseEntity.ok(room);
    }
    
    @GetMapping("/getAvailableRoom/{status}")
    public ResponseEntity<List<Room>> getAllAvailableRooms(@PathVariable String status)
    {
    	List<Room> room = roomService.roomAvailable(status);
    	return ResponseEntity.ok(room);
    }
    
    @PostMapping("/addnewroom")
    public ResponseEntity<Room> createRoom(@RequestBody Room room)
    {
    	Room createRoom = roomService.addRooms(room);
    	return ResponseEntity.ok(createRoom);
    }
    
    
}
