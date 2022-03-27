package com.kodilla.patterns2.decorator.pizza;

import java.math.BigDecimal;

public class MozarellaDecorator extends AbstractPizzaOrderDecorator{

    public MozarellaDecorator(PizzaOrder pizzaOrder) {
        super(pizzaOrder);
    }

    @Override
    public BigDecimal getPrice(){
        return super.getPrice().add(BigDecimal.valueOf(3.50));
    }

    @Override
    public String getToppings(){
        return super.getToppings() + "mozarella ";
    }
}
