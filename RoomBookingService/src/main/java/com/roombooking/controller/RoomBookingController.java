package com.roombooking.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.roombooking.dto.BookingDto;
import com.roombooking.entity.Booking;
import com.roombooking.entity.Payment;
import com.roombooking.entity.Room;
import com.roombooking.entity.User;
import com.roombooking.service.BookingService;
import com.roombooking.service.PaymentService;
import com.roombooking.service.RoomService;
import com.roombooking.service.UserService;

@RestController
@RequestMapping("/roombooking")
public class RoomBookingController {

    @Autowired
    private UserService userService;
    
    @Autowired
    private RoomService roomService;
    
    @Autowired
    private BookingService bookingService;
    
    @Autowired
    private PaymentService paymentService;
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
    
    @PutMapping("/checkout/{roomNumber}")
    public ResponseEntity<String> checkoutRoom(@PathVariable int roomNumber) {
        // Call the service method to update the room status
        roomService.checkoutRoom(roomNumber);
        
        // Return a success response
        return ResponseEntity.ok("Room checked out successfully");
    }
    
    //To add a booking
    
    @PostMapping("/createBooking")
    public ResponseEntity<String> createBooking(@RequestBody BookingDto bookingDTO)
    {
    	//Booking booking = bookingService.doBooking(bookingDTO);
    	return ResponseEntity.ok((String)bookingService.doBooking(bookingDTO));
    }
    
    @GetMapping("/getAllBookings")
    //To get all booking details
    public ResponseEntity<List<Booking>> getAllBooking()
    {
    	return ResponseEntity.ok(bookingService.getBookingDetails());
    }
    
    
    //To get booking detail using booking id
    @GetMapping("/getBookingDetailByBookingId/{bookingId}")
    public ResponseEntity<Booking> getBookingDetailByBookingId(@PathVariable Long bookingId)
    {
    	return ResponseEntity.ok(bookingService.getBookingDetailByBookingId(bookingId));
    }
    
    //To get booking details using user Id
    @GetMapping("/fetchBookingUSingUserId/{userId}")
    public ResponseEntity<List<Booking>> getBookingUsingByUserId(@PathVariable Long userId)
    {
    	return ResponseEntity.ok(bookingService.getBookingByUserId(userId));
    }
    
    //To cancel a booking
    @DeleteMapping("/cancelbooking/{bookingId}")
    public ResponseEntity<Booking> cancelBooking(@PathVariable Long bookingId)
    {
    	return ResponseEntity.ok(bookingService.cancelBooking(bookingId));
    }
    @PostMapping("/makePayment")
    public ResponseEntity<String> makePayment(@RequestBody Payment payment)
    {
//    	Payment paymentt = paymentService.doPayment(payment);
    	
    	return ResponseEntity.ok((String) paymentService.doPayment(payment));
    	
    }
}
