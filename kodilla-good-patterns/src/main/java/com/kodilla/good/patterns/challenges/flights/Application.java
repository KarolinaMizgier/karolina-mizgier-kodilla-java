package com.kodilla.good.patterns.challenges.flights;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class Application {

    public static void main (String args[]){

        FlightSearch flightSearch = new FlightSearch();
      //  flightSearch.findFlightTo("Warszawa");
        //List<Flight> gdansk1 = flightSearch.findFlightFrom("Gdansk");

        City gdansk = new City("Gdansk");
       // flightSearch.findFlights(gdansk);

        List<Flight> connections = getConnection("Gdansk", "Krakow", flightSearch);

        System.out.println("_______________CONNECTIONS________________");
        connections.forEach( c -> System.out.println(c.toString()));
        System.out.println("__________________________________________");

        // Gdask -> Warszawa -> Krakow
    }

    public static List<Flight> getConnection(String source, String destination, FlightSearch fs) {
        List<Flight> flightFrom = fs.findFlightFrom(source);
        List<Flight> flightTo = fs.findFlightTo(destination);


        List<Flight> directFlights = flightFrom.stream()
                .filter(flight -> flightTo.contains(flight)) // equals & hashcode required
                .collect(Collectors.toList());

        List<String> flightsToDestination = flightTo.stream()
                .map(f -> f.departureCity)
                .collect(Collectors.toList());

        List<String> flightFromSource = flightFrom.stream()
                .map(f -> f.arrivalCity)
                .collect(Collectors.toList());

        List<String> commonAirports = flightsToDestination.stream()
                .filter(f -> flightFromSource.contains(f))
                .collect(Collectors.toList());

        List<Flight> connections1 = new ArrayList<>();
        List<Flight> connections2 = new ArrayList<>();

        for (int i = 0; i < commonAirports.size(); i++) {
            connections1 = fs.findFlightFrom(commonAirports.get(i));
            connections2 = fs.findFlightTo(commonAirports.get(i));
        }
        List<Flight> collected = connections1.stream()
                .filter(flight -> flightTo.contains(flight))
                .collect(Collectors.toList());

        List<Flight> collected2 = connections2.stream()
                .filter(flight -> flightFrom.contains(flight))
                .collect(Collectors.toList());

        List<Flight> connections = new ArrayList<>();

        connections.addAll(directFlights);
        connections.addAll(collected);
        connections.addAll(collected2);



        return connections;


    }
}
