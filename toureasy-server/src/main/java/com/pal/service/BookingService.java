package com.pal.service;

import com.pal.dto.BookingDTO;
import com.pal.exception.TourEasyException;

import java.time.LocalDate;
import java.util.List;

public interface BookingService {

    public List<BookingDTO> getAllBookings(Integer user_id) throws TourEasyException;

    public Integer bookDestination(BookingDTO bookingDTO) throws TourEasyException;;

    public Integer removeBooking(LocalDate checkIn_date) throws TourEasyException;;

}
