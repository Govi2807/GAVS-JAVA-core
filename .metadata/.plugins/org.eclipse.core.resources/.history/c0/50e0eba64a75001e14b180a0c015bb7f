package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Booking;
import com.example.demo.service.BookingService;


@RestController
public class BookingController {
    @Autowired
    BookingService bookingService;

    @PostMapping("/addBooking")
	public String addProduct(@RequestBody Booking prd) {
		System.out.println(prd);
		bookingService.addProduct(prd);
		return "Added successfully";
	}
}
