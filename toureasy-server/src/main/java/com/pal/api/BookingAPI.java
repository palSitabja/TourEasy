package com.pal.api;

import com.pal.dto.BookingDTO;
import com.pal.exception.TourEasyException;
import com.pal.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.OptimisticLockException;
import java.time.LocalDate;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value = "/booking")
public class BookingAPI {

    @Autowired
    BookingService bookingService;

    @GetMapping(value ="/{user_id}")
    ResponseEntity<List<BookingDTO>> fetchAllBookingsByUserId(@PathVariable Integer user_id) throws TourEasyException {
        List<BookingDTO> bookingDTOList=bookingService.getAllBookings(user_id);

        return new ResponseEntity<>(bookingDTOList, HttpStatus.OK);

    }

    @PostMapping(value = "/book-destination")
    ResponseEntity<String> bookDestination(@RequestBody BookingDTO bookingDTO) throws TourEasyException, OptimisticLockException {

        //System.out.println(bookingDTO.getUsersDTO().getUserId()+"\n"+
                //bookingDTO.getDestinationDTO().getDestinationId()+"\n"+bookingDTO);
        Integer bookingId=bookingService.bookDestination(bookingDTO);

        String message="Destination booked with Id: "+bookingId;
        return new ResponseEntity<>(message,HttpStatus.CREATED);
    }

    @GetMapping(value = "/del/{checkIn}")
    ResponseEntity<String> deleteBooking(@PathVariable LocalDate checkIn) throws TourEasyException {

        Integer bookingId=bookingService.removeBooking(checkIn);
        String message="Booking deleted with Id: "+bookingId;

        return new ResponseEntity<>(message,HttpStatus.OK);
    }

}
