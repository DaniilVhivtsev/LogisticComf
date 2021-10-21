package com.logisticcomfort.model;


import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class Person {
    private int id;

    @NotEmpty(message = "Name should not be empty")
    @Size(min = 2, max = 30, message = "Name should be between 2 and 30 characters")
    private String username;

    @NotEmpty(message = "Name should not be empty")
    @Size(min = 2, max = 30, message = "Name should be between 2 and 30 characters")
    private String password;
//
//    @NotEmpty(message = "Email should not be empty")
//    @Email(message = "Email should be valid")
//    private String email;
//
//    @NotEmpty(message = "Email should not be empty")
//    @Email(message = "Email should be valid")
//    private String company_name;

    private boolean active;

    public Person() {
    }

    public Person(int id, String name, String password, String email, String company_name) {
        this.id = id;
        this.username = name;
        this.password = password;
//        this.email = email;
//        this.company_name = company_name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

//    public String getEmail() {
//        return email;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }
//
//    public String getCompany_name() {
//        return company_name;
//    }
//
//    public void setCompany_name(String company_name) {
//        this.company_name = company_name;
//    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
