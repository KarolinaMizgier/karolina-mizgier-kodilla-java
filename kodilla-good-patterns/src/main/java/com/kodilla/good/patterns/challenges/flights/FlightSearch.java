package com.kodilla.good.patterns.challenges.flights;

import org.apache.commons.collections4.CollectionUtils;

import java.util.*;

public class FlightSearch {
    FlightData data = new FlightData();
    List<Flight> connections = new ArrayList<>();

    public Map<String, Flight> findFlightTo(String city) {
        Flights flights = data.getFlights().get(city);
        Map<String, Flight> arrivals = flights.getArrivals();
        arrivals.entrySet().stream().forEach(entry -> {
            System.out.println("Flight:" + entry.getValue() + "\n");
        });
        return arrivals;
    }

    public Map<String, Flight> findFlightFrom(String city) {
        Flights flights = data.getFlights().get(city);
        Map<String, Flight> departures = flights.getDepartures();
        departures.entrySet().stream().forEach(entry -> {
            System.out.println("Flight:" + entry.getValue() + "\n");
        });
        return departures;
    }

    public Set<Flight> findDirectFlights(String departureCity, String arrivalCity) {
        Flights flights = data.getFlights().get(arrivalCity);
        Map<String, Flight> arrivals = flights.getArrivals();

        Set<Flight> directFlights = new HashSet<>();
        for (Map.Entry<String, Flight> entry : arrivals.entrySet()) {
            if (entry.getKey().equals(departureCity)) {
                directFlights.add(entry.getValue());
            }
        }
        return directFlights;
    }


    public List<Flight> findConnections(String departureCity, String arrivalCity) {
        Flights flights = data.getFlights().get(departureCity);
        Map<String, Flight> departures = flights.getDepartures();

        Flights flights2 = data.getFlights().get(arrivalCity);
        Map<String, Flight> arrivals = flights2.getArrivals();

        List<String> commonKeys = (List<String>) CollectionUtils.intersection(arrivals.keySet(), departures.keySet());

        for (int i = 0; i < commonKeys.size(); i++) {
            String key = commonKeys.get(i);
            if (!key.equals(departureCity) &&
                    !key.equals(arrivalCity) &&
                    arrivals.get(key).departureTime.getHour() > (departures.get(key).departureTime.getHour())) {
                connections.add(departures.get(commonKeys.get(i)));
                connections.add(arrivals.get(commonKeys.get(i)));
            }
        }
        return connections;
    }


}
