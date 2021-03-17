package com.pal.dto;

import com.pal.entity.Booking;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class BookingDTO {
    private Integer bookingId;
    private LocalDate checkIn;
    private LocalDate checkOut;
    private Integer NoOfPeople;
    private Float totalCost;
    private LocalDateTime timeOfBooking;
    private Integer userId;
    private String destinationId;

    public Integer getBookingId() {
        return bookingId;
    }

    public void setBookingId(Integer bookingId) {
        this.bookingId = bookingId;
    }

    public LocalDate getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(LocalDate checkIn) {
        this.checkIn = checkIn;
    }

    public LocalDate getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(LocalDate checkOut) {
        this.checkOut = checkOut;
    }

    public Integer getNoOfPeople() {
        return NoOfPeople;
    }

    public void setNoOfPeople(Integer noOfPeople) {
        NoOfPeople = noOfPeople;
    }

    public Float getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(Float totalCost) {
        this.totalCost = totalCost;
    }

    public LocalDateTime getTimeOfBooking() {
        return timeOfBooking;
    }

    public void setTimeOfBooking(LocalDateTime timeOfBooking) {
        this.timeOfBooking = timeOfBooking;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getDestinationId() {
        return destinationId;
    }

    public void setDestinationId(String destinationId) {
        this.destinationId = destinationId;
    }

    @Override
    public String toString() {
        return "BookingDTO{" +
                "bookingId=" + bookingId +
                ", checkIn=" + checkIn +
                ", checkOut=" + checkOut +
                ", NoOfPeople=" + NoOfPeople +
                ", totalCost=" + totalCost +
                ", timeOfBooking=" + timeOfBooking +
                ", userId=" + userId +
                ", destinationId='" + destinationId + '\'' +
                '}';
    }

    public Booking bookingDtoBooking(){
        Booking booking=new Booking();
        booking.setBookingId(this.bookingId);
        booking.setTimeOfBooking(this.timeOfBooking);
        booking.setCheckIn(this.checkIn);
        booking.setCheckOut(this.checkOut);
        booking.setNoOfPeople(this.NoOfPeople);
        booking.setTotalCost(this.totalCost);
        booking.setUserId(this.userId);
        booking.setDestinationId(this.destinationId);

        return booking;
    }
}
