package com.roombooking.controller;

import com.roombooking.entity.User;
import com.roombooking.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/roombooking")
public class RoomBookingController {

    @Autowired
    private UserService userService;

    // POST endpoint to create a user
    @PostMapping("/createUser")
    public ResponseEntity<User> addUser(@RequestBody User user) {
        // Save the user and return the saved user as response
        User savedUser = userService.saveUser(user);
        return ResponseEntity.ok(savedUser);
    }
}
