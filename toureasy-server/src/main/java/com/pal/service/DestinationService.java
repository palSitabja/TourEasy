package com.pal.service;

import com.pal.dto.DestinationDTO;
import com.pal.entity.Destination;
import com.pal.exception.TourEasyException;

import java.util.List;

public interface DestinationService {

    List<DestinationDTO> searchByContinent(String continent) throws TourEasyException;

    String addNewDestination(DestinationDTO destinationDTO);
}
