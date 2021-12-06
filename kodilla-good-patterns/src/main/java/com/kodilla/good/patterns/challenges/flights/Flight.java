package com.kodilla.good.patterns.challenges.flights;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Objects;

public class Flight {
    String departureCity;
    String arrivalCity;
    LocalTime departureTime;
    LocalTime arrivalTime;
    LocalDate date;

    public Flight(String departureCity, String arrivalCity, LocalTime departureTime, LocalTime arrivalTime, LocalDate date) {
        this.departureCity = departureCity;
        this.arrivalCity = arrivalCity;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.date = date;
    }


    @Override
    public String toString() {
        return "\nDeparture city: " + departureCity +
                "\n Arrival city: " + arrivalCity +
                "\n Departure time: " + departureTime.toString() +
                "\n Arrival time: " + arrivalTime +
                "\n Date: " + date + "\n";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Flight)) return false;
        Flight flight = (Flight) o;
        return Objects.equals(departureCity, flight.departureCity) && Objects.equals(arrivalCity, flight.arrivalCity) && Objects.equals(departureTime, flight.departureTime) && Objects.equals(arrivalTime, flight.arrivalTime) && Objects.equals(date, flight.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(departureCity, arrivalCity, departureTime, arrivalTime, date);
    }
}
