package com.roombooking.service;

import com.roombooking.entity.User;
import com.roombooking.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    public UserRepository userRepository;

    public User saveUser(User user){
        User userr = userRepository.save(user);
        return userr;
    }
}
