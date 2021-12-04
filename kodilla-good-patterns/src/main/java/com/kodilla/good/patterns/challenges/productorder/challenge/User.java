package com.kodilla.good.patterns.challenges.productorder.challenge;

public class User {
    private String name;
    private String lastName;
    private String address;

    public User(String name, String lastName, String address) {
        this.name = name;
        this.lastName = lastName;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public String getAddress() {
        return address;
    }
}

