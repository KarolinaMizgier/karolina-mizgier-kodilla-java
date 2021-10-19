package com.kodilla.stream.world;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

public class World {
    List<Continent> continents;

    public World(List<Continent> continents) {
        this.continents = continents;
    }

    public BigDecimal getPeopleQuantity() {
        List<BigDecimal> numbers = continents.stream()                               // [1]
                .flatMap(continent -> continent.getCountries().stream())       // [2]// [3]
                .map(country -> country.getPeopleQantity())                       // [4]
                .collect(Collectors.toList());
        BigDecimal total = numbers.stream()
                .reduce(BigDecimal.ZERO, (sum, current) -> sum = sum.add(current));
        return total;
    }
}