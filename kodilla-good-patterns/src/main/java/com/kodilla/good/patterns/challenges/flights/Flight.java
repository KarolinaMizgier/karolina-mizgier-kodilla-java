package com.kodilla.good.patterns.challenges.flights;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;

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
    public String toString(){
        return "\nDeparture city: "+departureCity+
                "\n Arrival city: "+arrivalCity+
                "\n Departure time: "+departureTime.toString()+
                "\n Arrival time: "+arrivalTime+
                "\n Date: "+date+"\n";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Flight flight = (Flight) o;

        if (departureCity != null ? !departureCity.equals(flight.departureCity) : flight.departureCity != null)
            return false;
        return arrivalCity != null ? arrivalCity.equals(flight.arrivalCity) : flight.arrivalCity == null;
    }

    @Override
    public int hashCode() {
        int result = departureCity != null ? departureCity.hashCode() : 0;
        result = 31 * result + (arrivalCity != null ? arrivalCity.hashCode() : 0);
        return result;
    }
}
