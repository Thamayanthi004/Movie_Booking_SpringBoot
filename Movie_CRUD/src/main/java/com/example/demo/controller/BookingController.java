package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.dto.BookingRequest;
import com.example.demo.entity.Booking;
import com.example.demo.service.BookingService;

@RestController
@RequestMapping("/booking")
public class BookingController {

    @Autowired
    private BookingService service;

    
    @PostMapping("/add")
    public Booking book(@RequestBody BookingRequest req) {
        return service.bookTicket(
                req.getMemberId(),
                req.getMovieId(),
                req.getSeats()
        );
    }

    
    @PutMapping("/cancel/{id}")
    public String cancel(@PathVariable int id) {
        return service.cancelBooking(id);
    }
}