package com.kodilla.stream;

import com.kodilla.stream.world.Continent;
import com.kodilla.stream.world.Country;
import com.kodilla.stream.world.World;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

public class StreamMain {

    public static void main(String[] args) {
        Country country1 = new Country("Germany", new BigDecimal(83000000));
        Country country2 = new Country("Poland", new BigDecimal(48000000));
        Country country3 = new Country("France", new BigDecimal(67000000));
        Country country4 = new Country("Austria", new BigDecimal(9000000));
        Country country5 = new Country("Germany", new BigDecimal(11000000));
        List<Country> countries = Arrays.asList(country1, country2, country3, country4, country5);
        Continent europe = new Continent("Europe", countries);
        Country country6 = new Country("USA", new BigDecimal(329000000));
        Country country7 = new Country("Mexico", new BigDecimal(128900000));
        Country country8 = new Country("Canada", new BigDecimal(38000000));

        List<Country> countries2 = Arrays.asList(country6, country7, country8);
        Continent northAmerica = new Continent("North America", countries2);

        List<Continent> continents = Arrays.asList(europe, northAmerica);

        World world = new World(continents);
        BigDecimal sum = world.getPeopleQuantity();
        System.out.println("Sum of people: " + sum);
    }

}

