package com.pal.service;

import com.pal.dto.UsersDTO;
import com.pal.entity.Users;
import com.pal.exception.TourEasyException;
import com.pal.repository.UsersRepository;
import com.pal.utility.HashPassword;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.security.NoSuchAlgorithmException;
import java.util.Optional;

@Service(value = "usersService")
@Transactional
public class UsersServiceImpl implements UsersService{

    @Autowired
    UsersRepository usersRepository;

    @Override
    public UsersDTO authenticateUser(String emailId, String password) throws TourEasyException, NoSuchAlgorithmException {

        String hashedPassword= HashPassword.getHashValue(password);
        Optional<Users> userFromDb=usersRepository.findByEmailIdAndPassword(emailId,hashedPassword);

        Users user=userFromDb.orElseThrow(()->new TourEasyException("USER_NOT_FOUND"));

        UsersDTO usersDTO=user.userToDto(user);


        return usersDTO;
    }

    @Override
    public String registerUser(UsersDTO usersDTO) throws TourEasyException, NoSuchAlgorithmException {

        String hashedPassword= HashPassword.getHashValue(usersDTO.getPassword());
        usersDTO.setPassword(hashedPassword);

        Users users=usersDTO.dtoToUsers();

        Optional<Users> userFromDb=usersRepository.findByEmailId(users.getEmailId());
        if(userFromDb.isPresent()){
            throw new TourEasyException("USER_ALREADY_EXISTS");
        }


        Users savedUser=usersRepository.save(users);

        return savedUser.getEmailId();
    }

    @Override
    public void updateProfile(UsersDTO usersDTO) throws TourEasyException {

    }
}
