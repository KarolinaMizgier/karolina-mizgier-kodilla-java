package com.kodilla.patterns2.decorator.pizza;

import java.math.BigDecimal;

public class MushroomsDecorator extends AbstractPizzaOrderDecorator{

    public MushroomsDecorator(PizzaOrder pizzaOrder){
        super(pizzaOrder);
    }

    @Override
    public BigDecimal getPrice(){
        return super.getPrice().add(BigDecimal.valueOf(4.00));
    }

    @Override
    public String getToppings(){
        return super.getToppings() + "mushrooms ";
    }

}
