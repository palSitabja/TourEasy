package com.pal.repository;

import com.pal.entity.Booking;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface BookingRepository extends CrudRepository<Booking,Integer> {

    @Query(value = "select b from Booking b where b.userId=:userId")
    List<Booking> findAllByUserId(@Param("userId") Integer userId);

    Optional<Booking> findByCheckInEquals(LocalDate localDate);
}
