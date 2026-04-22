package com.example.demo.dto;


public class BookingRequest {

    private int memberId;
    private int movieId;
    private int seats;

    public int getMemberId() { return memberId; }
    public void setMemberId(int memberId) { this.memberId = memberId; }

    public int getMovieId() { return movieId; }
    public void setMovieId(int movieId) { this.movieId = movieId; }

    public int getSeats() { return seats; }
    public void setSeats(int seats) { this.seats = seats; }
}