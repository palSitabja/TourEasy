package com.pal.service;

import com.pal.dto.DestinationDTO;
import com.pal.entity.Destination;
import com.pal.exception.TourEasyException;
import com.pal.repository.DestinationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service(value = "destinationService")
@Transactional
public class DestinationServiceImpl implements DestinationService{

    @Autowired
    DestinationRepository destinationRepository;


    @Override
    public List<DestinationDTO> searchByContinent(String continent) throws TourEasyException {
        List<Destination> destinationsFromDb=destinationRepository.findByContinent(continent);

        if(destinationsFromDb.isEmpty()){
            throw new TourEasyException("No tour available in your destination");
        }

        List<DestinationDTO> destinationDTOS=new ArrayList<>();
        destinationsFromDb.forEach(destination -> {
            destinationDTOS.add(destination.destinationToDTo());
        });

        return destinationDTOS;

    }

    @Override
    public String addNewDestination(DestinationDTO destinationDTO) {
        return null;
    }
}
