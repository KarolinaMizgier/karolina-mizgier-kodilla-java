package com.kodilla.good.patterns.challenges.flights;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class FlightData {

    static List<Flights> cities = new ArrayList<>();

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

    List<Flight> krakowArrivals = List.of(krakow1, krakow2, krakow3, krakow4);
    List<Flight> krakowDepartures = List.of(gdansk2, wroclaw3, warszawa1);
    List<Flight> gdanskArrivals = List.of(gdansk1, gdansk2);
    List<Flight> gdanskDepartures = List.of(krakow1, krakow2, wroclaw2, warszawa2);
    List<Flight> wroclawArrivals = List.of(wroclaw1, wroclaw2, wroclaw3);
    List<Flight> wroclawDepartures = List.of(krakow4);
    List<Flight> warszawaArrivals = List.of(warszawa1, warszawa2);
    List<Flight> warszawaDepartures = List.of(krakow3, wroclaw1, gdansk1);


    Flights krakow = new Flights("Krakow",krakowArrivals, krakowDepartures);
    Flights gdansk = new Flights("Gdansk",gdanskArrivals, gdanskDepartures);
    Flights wroclaw = new Flights("Wroclaw",wroclawArrivals, wroclawDepartures);
    Flights warszawa = new Flights("Warszawa",warszawaArrivals, warszawaDepartures);


    public List<Flights> getFlights(){
        cities.add(krakow);
        cities.add(gdansk);
        cities.add(wroclaw);
        cities.add(warszawa);
        return cities;
    }



}
