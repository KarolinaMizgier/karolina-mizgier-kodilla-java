package com.kodilla.testing.forum.collection;

import com.kodilla.testing.collection.OddNumbersExterminator;
import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class CollectionTestSuite {
    @BeforeEach
    public void before() {
        System.out.println("Test case: begin ");
    }

    @AfterEach
    public void after() {
        System.out.println("Test case: end");
    }

    OddNumbersExterminator exterminator = new OddNumbersExterminator();

    @DisplayName("When the list is empty")
    @Test
    public void testOddNumbersExterminatorEmptyList() {
        //given
        List<Integer> numbers = new ArrayList<>();
        //when
        List<Integer> result = exterminator.exterminate(numbers);
        //then
        Assertions.assertEquals(numbers, result);
        System.out.println("The list is empty. List size: " + result.size());
    }

    @DisplayName("When the list contains odd and even numbers")
    @Test
    public void testOddNumbersExterminatorNormalList() {
        //given
        List<Integer> numbers = Arrays.asList(2, 13, 6, 27, 4, 30, 3);
        List<Integer> expectedResult = Arrays.asList(2, 6, 4, 30);
        //when
        List<Integer> result = exterminator.exterminate(numbers);
        //then
        Assertions.assertEquals(result, expectedResult);
        System.out.println("List of odd numbers: " + result + "\n" + "Expected result: " + expectedResult);
    }
}
