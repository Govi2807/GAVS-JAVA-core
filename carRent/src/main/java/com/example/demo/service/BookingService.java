package com.example.demo.service;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Booking;

import com.example.demo.repositories.BookingRepository;

@Service
public class BookingService {
    @Autowired
    BookingRepository bookingRepository;
    

	public void addProduct( Booking prd) {
		bookingRepository.save(prd);
	}
}