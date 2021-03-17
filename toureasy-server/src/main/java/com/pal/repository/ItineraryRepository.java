package com.pal.repository;

import com.pal.entity.Itinerary;
import org.springframework.data.repository.CrudRepository;

public interface ItineraryRepository extends CrudRepository<Itinerary,String> {
}
