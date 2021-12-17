package com.kodilla.patterns.builder.bigmac;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BigmacTestSuite {
    @Test
    void testBigMacBuilder() {
        //Given
        BigMac bigMac = new BigMac.BigmacBuilder()
                .bun("burger bun")
                .burgers(1)
                .sauce("spicy")
                .ingredient(Ingredients.SALATA.value())
                .ingredient(Ingredients.PIECZARKI.value())
                .ingredient(Ingredients.SER.value())
                .build();
        System.out.println(bigMac.toString());
        //When
        int ingredientsNumber = bigMac.getIngredients().size();
        //Then
        assertEquals(3, ingredientsNumber);
    }
}
