package com.example.demo.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Exception.CustomException;
import com.example.demo.model.Booking;
import com.example.demo.model.User;
import com.example.demo.repositories.LoginRepository;

import jakarta.validation.Valid;

@Service
public class LoginService {
	
	@Autowired
    private LoginRepository loginRepository;

    public User findByUsername(Long user_id) {
    	if (user_id == null ) {
            throw new CustomException("User not found");
        }
    	else {
    		return loginRepository.findById(user_id).orElse(null); 
    	}
    }
    public User CreateUser(@Valid User prd) {
  
		return loginRepository.save(prd);
		
	}

}




