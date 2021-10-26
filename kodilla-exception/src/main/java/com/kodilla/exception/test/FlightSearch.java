package com.kodilla.exception.test;

import java.util.HashMap;
import java.util.Map;

public class FlightSearch {

    public static String findFilght(Flight flight) throws RouteNotFoundException{
        Map<String, Boolean> map = new HashMap<>();
        map.put("Barcelona",true);
        map.put("New York",false);
        map.put("Rome",true);
        Boolean status = null;
        for(Map.Entry<String, Boolean> entry: map.entrySet()){
            if(entry.getKey()==flight.getArrivalAirport()){
                status = entry.getValue();
            }else {
                throw new RouteNotFoundException("Tego miasta nie ma w bazie.");
            }
        }
        return "dostępność lotu: " + status.toString();
    }

    public static void main(String[] args) {
        Flight flight = new Flight("Warszawa","Barcelona");
        try {
            System.out.println(FlightSearch.findFilght(flight));
        } catch (RouteNotFoundException e) {
            e.printStackTrace();
            System.out.println(e);
        }

    }
}


