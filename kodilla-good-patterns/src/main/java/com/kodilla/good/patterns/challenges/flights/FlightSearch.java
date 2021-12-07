package com.kodilla.good.patterns.challenges.flights;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class FlightSearch {
    FlightData data = new FlightData();
    List<Flight> connections = new ArrayList<>();

    public List<Flight> findFlightTo(String city) {
        List<Flight> arrivals = data.flights.get(city);
        arrivals.stream().forEach(line -> {
            System.out.println("Flight:" + line + "\n");
        });
        return arrivals;
    }

    public List<Flight> findFlightFrom(String city) {
        List<Flight> departures = new ArrayList<>();
        for (Map.Entry entry : data.flights.entrySet()) {
            List<Flight> fl = (List<Flight>) entry.getValue();
            for (int i = 0; i < fl.size(); i++) {
                if (fl.get(i).departureCity.equals(city)) {
                    departures.add(fl.get(i));
                }
            }
        }
        departures.stream().forEach(line -> {
            System.out.println("Flight:" + line + "\n");
        });
        return departures;
    }

    public List<Flight> findConnection(String departureCity, String arrivalCity) {
        List<Flight> flightsToArrivalCity = data.flights.get(arrivalCity);
        List<Flight> flightsFromDepartureCity = findFlightFrom(departureCity);
        List<Flight> connection = new ArrayList<>();

        for (int i = 0; i < flightsToArrivalCity.size(); i++) {
            for (int n = 0; n < flightsFromDepartureCity.size(); n++) {
                Flight flight1 = flightsToArrivalCity.get(i);
                Flight flight2 = flightsFromDepartureCity.get(n);
                if (flight1.departureCity.equals(flight2.arrivalCity) &&
                        flight2.arrivalTime.getHour() < flight1.departureTime.getHour() &&
                        flight1.date.equals(flight2.date)) {
                    connection.add(flight2);
                    connection.add(flight1);
                }
            }
        }
        return connection;
    }


}
