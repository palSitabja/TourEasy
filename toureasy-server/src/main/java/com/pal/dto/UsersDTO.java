package com.pal.dto;

import com.pal.entity.Users;

import javax.validation.constraints.*;

public class UsersDTO {
    private Integer userId;

    @NotEmpty(message = "Name should not be empty")
    @Pattern(regexp="[A-Za-z]+( [A-Za-z]+)*", message="Name should contain only alphabets and space")
    private String userName;

    @NotEmpty(message = "email id should not be empty")
    @Email(message = "Enter proper email id")
    private String emailId;

    @NotEmpty(message = "contact number should not be empty")
    @Size(min = 10,max = 10,message = "Contact number must be of 10 digits")
    private String contactNumber;

    @NotEmpty(message = "{Password should not be empty}")
    @Size(min = 8,message = "Password must be of minimum 8 digits")
    private String password;

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

    public Users dtoToUsers(){
        Users users=new Users();
        users.setUserId(this.getUserId());
        users.setUserName(this.getUserName());
        users.setEmailId(this.getEmailId());
        users.setContactNumber(this.getContactNumber());
        users.setPassword(this.getPassword());

        return users;
    }
}
