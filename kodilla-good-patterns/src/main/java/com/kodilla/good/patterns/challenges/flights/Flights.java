package com.kodilla.good.patterns.challenges.flights;

import java.util.List;
import java.util.Map;

public class Flights {
    Map<String,Flight> arrivals;
    Map<String,Flight> departures;
    String city;

    public Flights(String city, Map<String,Flight>  arrivals, Map<String,Flight>  departures) {
        this.city = city;
        this.arrivals = arrivals;
        this.departures = departures;
    }

    public String getCity() {
        return city;
    }

    public Map<String,Flight>  getArrivals() {
        return arrivals;
    }

    public Map<String,Flight>  getDepartures() {
        return departures;
    }



}
