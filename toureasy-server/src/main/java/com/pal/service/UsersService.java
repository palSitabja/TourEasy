package com.pal.service;

import com.pal.dto.UsersDTO;
import com.pal.exception.TourEasyException;

import java.security.NoSuchAlgorithmException;

public interface UsersService {
    public UsersDTO authenticateUser(String emailId,String password) throws TourEasyException, NoSuchAlgorithmException;

    public String registerUser(UsersDTO usersDTO) throws TourEasyException, NoSuchAlgorithmException;

    public void updateProfile(UsersDTO usersDTO) throws TourEasyException;
}
