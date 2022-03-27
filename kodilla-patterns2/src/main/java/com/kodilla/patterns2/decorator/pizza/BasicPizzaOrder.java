package com.kodilla.patterns2.decorator.pizza;

import java.math.BigDecimal;

public class BasicPizzaOrder implements PizzaOrder{

    @Override
    public BigDecimal getPrice(){
        return BigDecimal.valueOf(20.00);
    }

    @Override
    public String getToppings(){
        return "Pizza with toppings: ";
    }


}
