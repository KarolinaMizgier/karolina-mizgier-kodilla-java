package com.kodilla.exception.io;

import com.kodilla.exception.test.SecondChallenge;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ExceptionHandlingTest {

    @Test
    public void probablyIWillThrowException() {
        SecondChallenge secondChallenge = new SecondChallenge();
    assertAll(
            () -> assertThrows(Exception.class,()->secondChallenge.probablyIWillThrowException(2.0,0.0)),
            () -> assertThrows(Exception.class,()->secondChallenge.probablyIWillThrowException(0.5,0.0)),
            () -> assertThrows(Exception.class,()->secondChallenge.probablyIWillThrowException(5,1.5)),
            () -> assertDoesNotThrow(()->secondChallenge.probablyIWillThrowException(1.5,3))
    );
    }
}
