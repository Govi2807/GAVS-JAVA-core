package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.model.Booking;
import com.example.demo.model.User;
import com.example.demo.service.BookingService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class BookingController {
    @Autowired
    BookingService service;

    @GetMapping("/bookedcar")
    public ResponseEntity<List<Booking>> getBookingDetails() {
        List<Booking> bookings = service.getAllProducts();
        return ResponseEntity.ok(bookings);
    }
//    @PostMapping("/bookedcar")
//    public Booking getBookingDetailsByAd(@RequestBody User user) {
//    	
//        return (Booking) service.getProduct(user);
//		
//    }
    @PostMapping("/addBooking")
    public ResponseEntity<Booking> addProduct(@RequestBody Booking booking) {
        Booking book=service.addProduct(booking);
        return ResponseEntity.ok(book);
    }

    @DeleteMapping("/deleteBooking/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable("id") int id) {
        service.deleteProduct(id);
        return ResponseEntity.ok("Deleted");
    }

    @PutMapping("/booking/{itemId}")
    public ResponseEntity<Booking> updateItem(@PathVariable int itemId, @RequestBody Booking updatedItem) {
        Booking updated = service.updateItem(itemId, updatedItem);
        return ResponseEntity.ok(updated);
    }
}
