package com.kodilla.decorator.pizza;

import com.kodilla.patterns2.decorator.pizza.*;
import org.junit.jupiter.api.Test;


import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PizzaOrderTestSuite {

    @Test
    public void testBasicPizzaWithAllToppings(){
        //given
        PizzaOrder pizzaOrder = new BasicPizzaOrder();
        pizzaOrder = new MozarellaDecorator(pizzaOrder);
        pizzaOrder = new MushroomsDecorator(pizzaOrder);
        pizzaOrder = new OlivesDecorator(pizzaOrder);

        //when
        String pizza = pizzaOrder.getToppings();
        BigDecimal price = pizzaOrder.getPrice();
        //then
        assertEquals("Pizza with toppings: mozarella mushrooms olives ",pizza);
        assertEquals(new BigDecimal(32.50),price);
        }

    @Test
    public void testBasicPizzaWithMozarellaAndMushrooms(){
        //given
        PizzaOrder pizzaOrder = new BasicPizzaOrder();
        pizzaOrder = new MozarellaDecorator(pizzaOrder);
        pizzaOrder = new MushroomsDecorator(pizzaOrder);

        //when
        String pizza = pizzaOrder.getToppings();
        BigDecimal price = pizzaOrder.getPrice();
        //then
        assertEquals("Pizza with toppings: mozarella mushrooms ",pizza);
        assertEquals(new BigDecimal(27.50),price);
    }

    }

