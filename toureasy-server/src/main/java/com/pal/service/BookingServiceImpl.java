package com.pal.service;

import com.pal.dto.BookingDTO;
import com.pal.entity.Booking;
import com.pal.entity.Destination;
import com.pal.entity.Users;
import com.pal.exception.TourEasyException;
import com.pal.repository.BookingRepository;
import com.pal.repository.DestinationRepository;
import com.pal.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.OptimisticLockException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service(value = "bookingService")
@Transactional
public class BookingServiceImpl implements BookingService{

    @Autowired
    BookingRepository bookingRepository;
    @Autowired
    UsersRepository usersRepository;
    @Autowired
    DestinationRepository destinationRepository;

    @Override
    public List<BookingDTO> getAllBookings(Integer user_id) throws TourEasyException {
        List<Booking> bookingsFromDB=bookingRepository.findAllByUserId(user_id);

        if(bookingsFromDB.isEmpty()){
            throw new TourEasyException("You haven't book any tour");
        }
        List<BookingDTO> bookingDTOList=new ArrayList<>();
        bookingsFromDB.forEach(booking -> {
            bookingDTOList.add(booking.BookingToDto());
        });

        return bookingDTOList;
    }

    @Override
    public Integer bookDestination(BookingDTO bookingDTO) throws TourEasyException,OptimisticLockException{
        decreamentAvailability(bookingDTO.getDestinationId());

        Booking booking=bookingDTO.bookingDtoBooking();
        Booking savedBooking=bookingRepository.save(booking);

        return savedBooking.getBookingId();
    }


    public void decreamentAvailability(String destinationId) throws TourEasyException, OptimisticLockException {
        Optional<Destination> optionalDestination=destinationRepository.findById(destinationId);
        Destination destinationFromDB=optionalDestination.orElseThrow(()->new TourEasyException("Destination not exists"));
        if(destinationFromDB.getAvailability()>0) {
            destinationFromDB.setAvailability(destinationFromDB.getAvailability() - 1);
            destinationRepository.save(destinationFromDB);
        }else {
            throw new TourEasyException("Booking to this is currently unavailable");
        }
    }

    @Override
    public Integer removeBooking(LocalDate checkIn_date) throws TourEasyException{

        Optional<Booking> optionalBooking=bookingRepository.findByCheckInEquals(checkIn_date);

        Booking bookingFromDB=optionalBooking.orElseThrow(()->new TourEasyException("Booking doesnot exists"));


        bookingRepository.deleteById(bookingFromDB.getBookingId());

        return bookingFromDB.getBookingId();
    }
}
