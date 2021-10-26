package com.kodilla.exception.test;

import java.util.HashMap;
import java.util.Map;

public class FlightSearch {

    public boolean findFilght(Flight flight) throws RouteNotFoundException {
        Map<String, Boolean> map = new HashMap<>();
        map.put("Barcelona", true);
        map.put("New York", false);
        map.put("Rome", true);

        String arrivalAirport = flight.getArrivalAirport();
        if (!map.containsKey(arrivalAirport)) {
            throw new RouteNotFoundException("Airport in this city is not in avaliable.");
        }
        return map.get(arrivalAirport);
    }

    public static void main(String[] args) {
        Flight flight = new Flight("Warszawa", "New York");
        FlightSearch flightSearch = new FlightSearch();
        try {
            System.out.println("Is airport avaliable: " + flightSearch.findFilght(flight));
        } catch (RouteNotFoundException e) {
            System.out.println("Cannot find flight: " + e.getMessage());
        }

    }
}


