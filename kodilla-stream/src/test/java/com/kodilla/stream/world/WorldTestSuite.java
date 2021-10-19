package com.kodilla.stream.world;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

public class WorldTestSuite {
    @Test
    void testGetPeopleQuantity(){
        //Given
        Country country1 = new Country("Germany", new BigDecimal(83000000));
        Country country2 = new Country("Poland", new BigDecimal(48000000));
        Country country3 = new Country("France", new BigDecimal(67000000));
        List<Country> countries = Arrays.asList(country1, country2, country3);

        Continent europe = new Continent("Europe", countries);
        Country country6 = new Country("USA", new BigDecimal(329000000));
        Country country7 = new Country("Mexico", new BigDecimal(128900000));
        List<Country> countries2 = Arrays.asList(country6, country7);

        Continent northAmerica = new Continent("North America", countries2);
        List<Continent> continents = Arrays.asList(europe, northAmerica);
        World world = new World(continents);
        //When
        BigDecimal sum = world.getPeopleQuantity();
        //Then
        BigDecimal expected = new BigDecimal(655900000);
        Assertions.assertEquals(expected,sum);

    }
}
