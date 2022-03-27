package com.kodilla.patterns2.decorator.pizza;

import java.math.BigDecimal;

public class OlivesDecorator extends AbstractPizzaOrderDecorator{
    public OlivesDecorator(PizzaOrder pizzaOrder) {
        super(pizzaOrder);
    }

    @Override
    public BigDecimal getPrice(){
        return super.getPrice().add(BigDecimal.valueOf(5.00));
    }

    @Override
    public String getToppings(){
        return super.getToppings() + "olives ";
    }
}
