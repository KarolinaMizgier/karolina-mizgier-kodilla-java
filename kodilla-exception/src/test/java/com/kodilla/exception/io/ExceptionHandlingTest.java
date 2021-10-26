package com.kodilla.exception.io;

import com.kodilla.exception.test.SecondChallenge;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ExceptionHandlingTest {

    @Test
    public void probablyIWillThrowException() {
    assertAll(
            () -> assertThrows(Exception.class,()->SecondChallenge.probablyIWillThrowException(2.0,0.0)),
            () -> assertThrows(Exception.class,()->SecondChallenge.probablyIWillThrowException(0.5,0.0)),
            () -> assertThrows(Exception.class,()->SecondChallenge.probablyIWillThrowException(5,1.5)),
            () -> assertDoesNotThrow(()->SecondChallenge.probablyIWillThrowException(1.5,3))
    );
    }
}
