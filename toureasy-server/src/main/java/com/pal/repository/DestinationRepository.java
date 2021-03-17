package com.pal.repository;

import com.pal.entity.Destination;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface DestinationRepository extends CrudRepository<Destination,String> {
    List<Destination> findByContinent(String continent);

}
