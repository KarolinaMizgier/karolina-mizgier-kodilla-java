package com.kodilla.stream.array;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static com.kodilla.stream.array.ArrayOperations.getAverage;

public class ArrayOperationsTestSuite {
    @Test
    void testGetAverage() {
        //Given
        int[] tab = {4, 16, 2, 85, 3};
        ArrayOperations arrayOperations;
        //When
        double result = getAverage(tab);
        double expectedResult = 22;
        Assertions.assertEquals(expectedResult, result);
    }
}
