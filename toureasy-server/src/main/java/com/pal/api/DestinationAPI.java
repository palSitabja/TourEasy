package com.pal.api;

import com.pal.dto.DestinationDTO;
import com.pal.entity.Destination;
import com.pal.exception.TourEasyException;
import com.pal.service.DestinationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value = "/destination")
public class DestinationAPI {

    @Autowired
    DestinationService destinationService;

    @GetMapping(value = "/{continent}")
    ResponseEntity<List<DestinationDTO>> searchByContinent(@PathVariable String continent) throws TourEasyException {
        List<DestinationDTO> destinationDTOS=destinationService.searchByContinent(continent);

        return new ResponseEntity<>(destinationDTOS, HttpStatus.OK);

    }

}
