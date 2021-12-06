package com.kodilla.good.patterns.challenges.flights;

import java.util.List;
import java.util.Set;

public class Application {

    public static void main(String args[]) {

        FlightSearch flightSearch = new FlightSearch();
        String warszawa = "Warszawa";
        String gdansk = "Gdansk";
        System.out.println("Flights to " + warszawa + ":\n");
        flightSearch.findFlightTo(warszawa);
        System.out.println("Flights from " + gdansk + ":\n");
        flightSearch.findFlightFrom(gdansk);
        System.out.println("Direct flights from " + warszawa + " to " + gdansk + " :\n");
        Set<Flight> directFlights = flightSearch.findDirectFlights(warszawa, gdansk);
        directFlights.forEach(f -> {
            System.out.println(f.toString());
        });
        List<Flight> connections = flightSearch.findConnections("Warszawa", "Krakow");
        System.out.println("_______________CONNECTIONS________________");
        connections.forEach(c -> System.out.println(c.toString()));
        System.out.println("__________________________________________");
    }
}
