package com.example.demo.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Exception.CustomException;
import com.example.demo.model.User;
import com.example.demo.model.UserReturn;
import com.example.demo.service.LoginService;

import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Valid;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class LoginController {
    @Autowired
    private LoginService loginService;

    @PostMapping("/Login")
    public ResponseEntity<?> login(@RequestBody User username) {
        try {
            System.out.println(username.getUser_id());
            User user = loginService.findByUsername(username.getUser_id());
            if (user != null && user.getPassword().equals(username.getPassword())) {
            	UserReturn userDTO = new UserReturn(user.getUser_id(),user.getName(),user.getAddress(),user.getPhone(), user.getEmail_id(),user.getUser_type());
                return ResponseEntity.ok(userDTO);
            } else {
            
                return ResponseEntity.status(401).body("Invalid UserId or Password"); 
            }
        } catch (Exception e) {
            return ResponseEntity.status(500).body("An error occurred: " + e.getMessage()); 
        }
    }
    
    @PostMapping("/Create")
    public ResponseEntity<?> Create(@RequestBody User userdetails) {
        try {
        	System.out.print("user");
            User user = loginService.CreateUser(userdetails);
            return ResponseEntity.ok(user);
        } catch (ConstraintViolationException ex) {
            List<String> validationErrors = ex.getConstraintViolations()
                .stream()
                .map(violation -> violation.getPropertyPath() + ": " + violation.getMessage())
                .collect(Collectors.toList());
            System.out.print("Bad Entry");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body("Validation error: " + validationErrors);
        } catch (Exception e) {
            return ResponseEntity.status(500)
                .body("An error occurred: " + e.getMessage());
        }
    }

}
