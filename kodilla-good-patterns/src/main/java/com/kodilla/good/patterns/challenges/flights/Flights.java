package com.kodilla.good.patterns.challenges.flights;

import java.util.List;

public class Flights {
    List<Flight> arrivals;
    List<Flight> departures;
    String city;

    public Flights(String city, List<Flight> arrivals, List<Flight> departures) {
        this.city = city;
        this.arrivals = arrivals;
        this.departures = departures;
    }

    public String getCity() {
        return city;
    }

    public List<Flight> getArrivals() {
        return arrivals;
    }

    public List<Flight> getDepartures() {
        return departures;
    }



}
