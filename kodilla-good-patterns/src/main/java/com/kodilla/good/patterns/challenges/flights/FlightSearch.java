package com.kodilla.good.patterns.challenges.flights;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FlightSearch {
    FlightData data = new FlightData();
    List<Flight> connections = new ArrayList<>();

    public List<Flight> findFlightsTo(String city) {

        List<Flight> arrivals = data.flights.stream().filter(flight -> city.equals(flight.getArrivalCity()))
                .collect(Collectors.toList());
        return arrivals;
    }

    public List<Flight> findFlightsFrom(String city) {

        List<Flight> departures = data.flights.stream().filter(flight -> city.equals(flight.getDepartureCity()))
                .collect(Collectors.toList());
        return departures;
    }

    public List<List<Flight>> findConnection(String departureCity, String arrivalCity) {
        List<Flight> flightsToArrivalCity = findFlightsTo(arrivalCity);
        List<Flight> flightsFromDepartureCity = findFlightsFrom(departureCity);
        List<List<Flight>> connections = new ArrayList<>();

        for (int i = 0; i < flightsToArrivalCity.size(); i++) {
            for (int n = 0; n < flightsFromDepartureCity.size(); n++) {
                Flight flight1 = flightsToArrivalCity.get(i);
                Flight flight2 = flightsFromDepartureCity.get(n);
                if (flight1.getDepartureCity().equals(flight2.getArrivalCity()) &&
                        flight2.getArrivalTime().getHour() < flight1.getDepartureTime().getHour() &&
                        flight1.getDate().equals(flight2.getDate())) {
                    List<Flight> connection = new ArrayList<>();
                    connection.add(flight2);
                    connection.add(flight1);
                    connections.add(connection);
                }
            }
        }
        return connections;
    }
}
