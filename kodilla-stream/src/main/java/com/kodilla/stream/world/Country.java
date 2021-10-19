package com.kodilla.stream.world;

import java.math.BigDecimal;

public class Country {
    public String name;
    public BigDecimal peopleQantity;

    public Country(String name, BigDecimal peopleQantity) {
        this.name = name;
        this.peopleQantity = peopleQantity;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getPeopleQantity() {
        return peopleQantity;
    }
}
