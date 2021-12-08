package com.kodilla.spring.calculator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CalculatorTestSuite {
    @Autowired
    private Calculator calculator;

    @Test
    public void testAdd() {
        //Given
        //When
        double result = calculator.add(2,2);

        //Then
        Assertions.assertEquals(4,result);
    }
    @Test
    public void testSub() {
        //Given
        //When
        double result = calculator.sub(2,1);

        //Then
        Assertions.assertEquals(1,result);
    }
    @Test
    public void testMul() {
        //Given
        //When
        double result = calculator.mul(3,2);
        //Then
        Assertions.assertEquals(6,result);
    }
    @Test
    public void testDiv() {
        //Given
        //When
        double result = calculator.div(10,2);
        //Then
        Assertions.assertEquals(5,result);
    }

}
