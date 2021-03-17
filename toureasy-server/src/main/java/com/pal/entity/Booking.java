package com.pal.entity;

import com.pal.dto.BookingDTO;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "BOOKING")
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "BOOKING_ID")
    private Integer bookingId;
    private LocalDate checkIn;
    private LocalDate checkOut;
    private Integer NoOfPeople;
    private Float totalCost;
    private LocalDateTime timeOfBooking;
    private Integer userId;
    private String destinationId;

/*    @ManyToOne(cascade =CascadeType.DETACH )
    @JoinColumn(name = "USER_ID")
    private Users user;

    @OneToOne(cascade =CascadeType.DETACH )
    @JoinColumn(name = "DESTINATION_ID")
    private Destination destination;*/

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
        return "Booking{" +
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

    public BookingDTO BookingToDto(){
        BookingDTO bookingDTO=new BookingDTO();

        bookingDTO.setBookingId(this.bookingId);
        bookingDTO.setTimeOfBooking(this.timeOfBooking);
        bookingDTO.setCheckIn(this.checkIn);
        bookingDTO.setCheckOut(this.checkOut);
        bookingDTO.setNoOfPeople(this.NoOfPeople);
        bookingDTO.setTotalCost(this.totalCost);
        bookingDTO.setUserId(this.userId);
        bookingDTO.setDestinationId(this.destinationId);


        return bookingDTO;
    }
}
