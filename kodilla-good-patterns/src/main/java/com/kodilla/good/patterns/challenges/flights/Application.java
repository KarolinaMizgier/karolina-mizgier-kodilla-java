package com.kodilla.good.patterns.challenges.flights;

import java.util.List;

public class Application {

    public static void main(String args[]) {

        FlightSearch flightSearch = new FlightSearch();
        String warszawa = "Warszawa";
        String gdansk = "Gdansk";
        System.out.println("Flights to " + warszawa + ":\n");
        List<Flight> flightsTo = flightSearch.findFlightsTo(warszawa);
        flightsTo.forEach(line->{
            System.out.println(line.toString());
        });
        System.out.println("Flights from " + gdansk + ":\n");
        List<Flight> flightsFrom = flightSearch.findFlightsFrom(gdansk);
        flightsFrom.forEach(line->{
            System.out.println(line.toString());
        });
        List<List<Flight>> connections = flightSearch.findConnection("Gdansk", "Wroclaw");
        System.out.println("_______________CONNECTIONS________________");
        connections.forEach(c -> System.out.println(c.toString()));
        System.out.println("__________________________________________");
    }
}