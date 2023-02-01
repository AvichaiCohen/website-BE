package com.userLogin.model;

public class CustomUser {

    private Long id;

    private String username;

    private String password;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String city;
    private String country;

    private int active;


    public CustomUser(Long id, String username, String password, String firstName, String lastName, String email, String phone, String city, String country) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.city = city;
        this.country = country;
        this.active = 1;
    }

    protected CustomUser(){}

    public long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getCity() {
        return city;
    }

    public String getCountry() {
        return country;
    }

    public int getActive() {
        return active;
    }

}