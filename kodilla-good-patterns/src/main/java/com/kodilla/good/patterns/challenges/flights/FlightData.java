package com.kodilla.good.patterns.challenges.flights;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FlightData {

    static Map<String,Flights> cities = new HashMap<>();

    Flight krakow1 = new Flight("Gdansk", "Krakow",
            LocalTime.parse("10:20"), LocalTime.parse("12:20"),
            LocalDate.of(2021, 12, 20));
    Flight krakow2 = new Flight("Gdansk", "Krakow",
            LocalTime.parse("20:20"), LocalTime.parse("22:20"),
            LocalDate.of(2021, 12, 20));
    Flight krakow3 = new Flight("Warszawa", "Krakow",
            LocalTime.parse("15:20"), LocalTime.parse("16:20"),
            LocalDate.of(2021, 12, 20));
    Flight krakow4 = new Flight("Wroclaw", "Krakow",
            LocalTime.parse("14:50"), LocalTime.parse("15:30"),
            LocalDate.of(2021, 12, 20));
    Flight wroclaw1 = new Flight("Warszawa", "Wroclaw",
            LocalTime.parse("08:10"), LocalTime.parse("10:20"),
            LocalDate.of(2021, 12, 20));
    Flight wroclaw2 = new Flight("Gdansk", "Wroclaw",
            LocalTime.parse("12:30"), LocalTime.parse("15:10"),
            LocalDate.of(2021, 12, 20));
    Flight wroclaw3 = new Flight("Krakow", "Wroclaw",
            LocalTime.parse("23:30"), LocalTime.parse("00:10"),
            LocalDate.of(2021, 12, 20));
    Flight gdansk1 = new Flight("Warszawa", "Gdansk",
            LocalTime.parse("07:20"), LocalTime.parse("09:20"),
            LocalDate.of(2021, 12, 20));
    Flight gdansk2 = new Flight("Krakow", "Gdansk",
            LocalTime.parse("11:45"), LocalTime.parse("15:25"),
            LocalDate.of(2021, 12, 20));
    Flight warszawa1 = new Flight("Krakow", "Warszawa",
            LocalTime.parse("17:40"), LocalTime.parse("19:00"),
            LocalDate.of(2021, 12, 20));
    Flight warszawa2 = new Flight("Gdansk", "Warszawa",
            LocalTime.parse("15:30"), LocalTime.parse("18:00"),
            LocalDate.of(2021, 12, 20));

    public Map<String,Flight> krakowArrivalsMap = new HashMap<>(){{
        put(krakow1.departureCity,krakow1);
        put(krakow2.departureCity,krakow2);
        put(krakow3.departureCity,krakow3);
        put(krakow4.departureCity,krakow4);
    }};
    public Map<String,Flight> krakowDeparturesMap = new HashMap<>(){{
        put(gdansk2.arrivalCity,gdansk2);
        put(wroclaw3.arrivalCity,wroclaw3);
        put(warszawa1.arrivalCity, warszawa1);
    }};
    public Map<String,Flight> gdanskArrivalsMap = new HashMap<>(){{
        put(gdansk1.departureCity,gdansk1);
        put(gdansk2.departureCity,gdansk2);
    }};
    public Map<String,Flight> gdanskDeparturesMap = new HashMap<>(){{
        put(krakow1.arrivalCity,krakow1);
        put(krakow2.arrivalCity,krakow2);
        put(wroclaw2.arrivalCity, wroclaw2);
        put(warszawa2.arrivalCity, warszawa2);
    }};
    public Map<String,Flight> wroclawArrivalsMap = new HashMap<>(){{
        put(wroclaw1.departureCity,wroclaw1);
        put(wroclaw2.departureCity,wroclaw2);
        put(wroclaw3.departureCity,wroclaw3);
    }};
    public Map<String,Flight> wroclawDeparturesMap = new HashMap<>(){{
        put(krakow4.arrivalCity,krakow4);
    }};
    public Map<String,Flight> warszawaArrivalsMap = new HashMap<>(){{
        put(warszawa1.departureCity,warszawa1);
        put(warszawa2.departureCity, warszawa2);
    }};
    public Map<String,Flight> warszawaDeparturesMap = new HashMap<>(){{
        put(krakow3.arrivalCity,krakow3);
        put(wroclaw1.arrivalCity,wroclaw1);
        put(gdansk1.arrivalCity,gdansk1);
    }};
    List<Flight> krakowArrivals = List.of(krakow1, krakow2, krakow3, krakow4);
    List<Flight> krakowDepartures = List.of(gdansk2, wroclaw3, warszawa1);
    List<Flight> gdanskArrivals = List.of(gdansk1, gdansk2);
    List<Flight> gdanskDepartures = List.of(krakow1, krakow2, wroclaw2, warszawa2);
    List<Flight> wroclawArrivals = List.of(wroclaw1, wroclaw2, wroclaw3);
    List<Flight> wroclawDepartures = List.of(krakow4);
    List<Flight> warszawaArrivals = List.of(warszawa1, warszawa2);
    List<Flight> warszawaDepartures = List.of(krakow3, wroclaw1, gdansk1);


    Flights krakow = new Flights("Krakow",krakowArrivalsMap, krakowDeparturesMap);
    Flights gdansk = new Flights("Gdansk",gdanskArrivalsMap, gdanskDeparturesMap);
    Flights wroclaw = new Flights("Wroclaw",wroclawArrivalsMap, wroclawDeparturesMap);
    Flights warszawa = new Flights("Warszawa",warszawaArrivalsMap, warszawaDeparturesMap);


    public Map<String,Flights> getFlights(){
        cities.put("Krakow",krakow);
        cities.put("Gdansk",gdansk);
        cities.put("Wroclaw",wroclaw);
        cities.put("Warszawa",warszawa);
        return cities;
    }



}
