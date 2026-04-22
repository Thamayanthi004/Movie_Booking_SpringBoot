package com.example.demo.service;
import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Booking;
import com.example.demo.entity.Member;
import com.example.demo.entity.Movie;
import com.example.demo.repository.BookingRepo;
import com.example.demo.repository.MemberRepo;
import com.example.demo.repository.MovieRepo;

@Service
public class BookingService {

    @Autowired
    private BookingRepo bookingRepo;

    @Autowired
    private MemberRepo memberRepo;

    @Autowired
    private MovieRepo movieRepo;

    public Booking bookTicket(int memberId, int movieId, int seats) {

        Member member = memberRepo.findById(memberId).orElseThrow();
        Movie movie = movieRepo.findById(movieId).orElseThrow();

        double total = seats * movie.getTicketPrice();
        if (seats >= 5) {
            total = total * 0.9;
        }

        Booking booking = new Booking();
        booking.setBookingDate(LocalDate.now());
        booking.setNoOfSeats(seats);
        booking.setTotalAmount(total);
        booking.setBookingStatus("CONFIRMED");
        booking.setMember(member);
        booking.setMovie(movie);

        return bookingRepo.save(booking);
    }

    public String cancelBooking(int id) {
        Booking b = bookingRepo.findById(id).orElseThrow();
        b.setBookingStatus("CANCELLED");
        bookingRepo.save(b);
        return "Cancelled";
    }

}