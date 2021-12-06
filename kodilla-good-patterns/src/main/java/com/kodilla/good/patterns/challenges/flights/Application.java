package com.kodilla.good.patterns.challenges.flights;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Application {

    public static void main(String args[]) {

        FlightSearch flightSearch = new FlightSearch();
        flightSearch.findFlightTo("Warszawa");
        flightSearch.findFlightFrom("Gdansk");
        Set<Flight> connections = flightSearch.findConnections("Gdansk", "Krakow");
        System.out.println("_______________CONNECTIONS________________");
        connections.forEach(c -> System.out.println(c.toString()));
        System.out.println("__________________________________________");

        // List<Flight> connections = getConnection("Gdansk", "Krakow", flightSearch);

        // System.out.println("_______________CONNECTIONS________________");
        // connections.forEach( c -> System.out.println(c.toString()));
        // System.out.println("__________________________________________");

        // Gdask -> Warszawa -> Krakow
    }
}
