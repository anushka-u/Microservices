package com.roombooking.service;

import com.roombooking.entity.User;
import com.roombooking.repository.UserRepository;

import org.apache.kafka.common.errors.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    public UserRepository userRepository;

    public User saveUser(User user){
        User userr = userRepository.save(user);
        return userr;
    }
    
    public User updateUser(Long id,User user)
    {
    	
		User userr = userRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("User not found"));
    	userr.setPhoneNumber(user.getPhoneNumber());
    	userr.setUserEmail(user.getUserEmail());
    	userr.setUserName(user.getUserName());
    	userRepository.save(userr);
		return userr;
    	
    }
    
    public List<User> getUser(){
    	return userRepository.findAll();
    }
    

	public User getSingleUser(Long userId) {
		// TODO Auto-generated method stub
		return userRepository.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User doesn't exist."));
	}
	
	public Optional<User> deleteUSerById(Long userId)
	{
		Optional<User> user = userRepository.findById(userId);
		user.ifPresent( u -> userRepository.deleteById(userId));
		return user;
	}
}
