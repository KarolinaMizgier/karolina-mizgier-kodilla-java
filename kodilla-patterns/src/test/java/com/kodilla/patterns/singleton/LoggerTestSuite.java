package com.kodilla.patterns.singleton;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoggerTestSuite {
    private static Logger logger;

    @BeforeAll
    public static void addLog() {
        logger = Logger.LOG;
        logger.log("Last log");
    }

    @Test
    void testGetLastLog() {
        //Given
        //When
        String log = logger.getLastLog();
        //Then
        assertEquals("Last log", log);
    }
}
