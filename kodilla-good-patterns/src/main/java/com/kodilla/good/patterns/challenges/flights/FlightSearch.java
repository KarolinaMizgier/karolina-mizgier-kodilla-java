package com.kodilla.good.patterns.challenges.flights;

import java.util.*;

public class FlightSearch {
    FlightData data = new FlightData();
    List<Flight> krakowDepartures = data.krakowDepartures;
    List<Flight> wroclawDepartures = data.wroclawDepartures;
    List<Flight> gdanskDepartures = data.gdanskDepartures;
    List<Flight> warszawaDepartures = data.warszawaDepartures;

    City krakow = new City("Krakow");
    City wroclaw = new City("Wroclaw");
    City gdansk = new City("Gdansk");
    City warszawa = new City("Warszawa");

    private Map<City, List<Flight>> departureMap = new HashMap<>(){{
        put(krakow,krakowDepartures);
        put(wroclaw,wroclawDepartures);
        put(gdansk,gdanskDepartures);
        put(warszawa,warszawaDepartures);
    }};

    public List<Flight> findFlightTo(String city){
       List<Flights> flights = data.getFlights();
        Optional<List<Flight>> arrivals = flights.stream()
                .filter(line -> city.equals(line.getCity()))
                .map(line -> line.getArrivals())
                .findFirst();
        arrivals.stream().forEach(line->{
            System.out.println(line.toString());
        });
        return arrivals.orElseGet(ArrayList::new);
    }

    public List<Flight> findFlightFrom(String city){
        List<Flights> flights = data.getFlights();
        Optional<List<Flight>> arrivals = flights.stream()
                .filter(line -> city.equals(line.getCity()))
                .map(line -> line.getDepartures())
                .findFirst();
        arrivals.stream().forEach(line->{
            System.out.println(line.toString());
        });
        return arrivals.orElseGet(ArrayList::new);
    }

    public void findFlights(City city) {

        System.out.println(departureMap.get(city));
    }


}
