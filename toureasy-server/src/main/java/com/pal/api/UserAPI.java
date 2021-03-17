package com.pal.api;

import com.pal.dto.UserCredentialDTO;
import com.pal.dto.UsersDTO;
import com.pal.exception.TourEasyException;
import com.pal.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.NoSuchAlgorithmException;

@CrossOrigin
@RestController
@RequestMapping(value = "/user")
public class UserAPI {

    @Autowired
    UsersService usersService;

    @PostMapping(value = "/login")
    private ResponseEntity<UsersDTO> authenticateUser(@RequestBody UserCredentialDTO userCredentialDTO) throws TourEasyException, NoSuchAlgorithmException {
        UsersDTO usersDTO1=usersService.authenticateUser(userCredentialDTO.getEmailId(),userCredentialDTO.getPassword());

        return new ResponseEntity<UsersDTO>(usersDTO1, HttpStatus.OK);
    }

    @PostMapping(value = "/register")
    private ResponseEntity<String> registerUser(@RequestBody @Valid UsersDTO usersDTO) throws TourEasyException, NoSuchAlgorithmException {
        String userId=usersService.registerUser(usersDTO);
        String message="Emaqil id: "+userId+" Registered successfully";

        return new ResponseEntity<String>(message, HttpStatus.OK);
    }

}
