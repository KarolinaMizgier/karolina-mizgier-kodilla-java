package com.kodilla.good.patterns.challenges.healthyfoodstore;

public class UserProfile {
    private String name;
    private String lastName;
    private String address;

    public UserProfile(String name, String lastName, String address) {
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
