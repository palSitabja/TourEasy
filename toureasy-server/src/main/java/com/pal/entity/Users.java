package com.pal.entity;

import com.pal.dto.UsersDTO;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "USERS")
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userId;
    private String userName;
    private String emailId;
    private String contactNumber;
    private String password;

/*    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "userId")
    private List<Booking> bookings;*/

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UsersDTO userToDto(Users users){
        UsersDTO usersDTO=new UsersDTO();
        usersDTO.setUserId(users.getUserId());
        usersDTO.setUserName(users.getUserName());
        usersDTO.setEmailId(users.getEmailId());
        usersDTO.setContactNumber(users.getContactNumber());
        usersDTO.setPassword(users.getPassword());

        return usersDTO;
    }
}
