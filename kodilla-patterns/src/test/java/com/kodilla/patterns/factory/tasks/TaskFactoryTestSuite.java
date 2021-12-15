package com.kodilla.patterns.factory.tasks;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TaskFactoryTestSuite {
    @Test
    void testFactoryShoppingTask() {
        //Given
        TaskFactory factory = new TaskFactory();
        //When
        Task shopping = factory.whichTask(TaskFactory.SHOPPING);
        shopping.executeTask();
        //Then
        assertEquals("Media Markt", shopping.getTaskName());
        assertTrue(shopping.isTaskExecuted());
    }

    @Test
    void testFactoryDrivingTask() {
        //Given
        TaskFactory factory = new TaskFactory();
        //When
        Task driving = factory.whichTask(TaskFactory.DRIVING);
        driving.executeTask();
        //Then
        assertEquals("Trip", driving.getTaskName());
        assertTrue(driving.isTaskExecuted());
    }

    @Test
    void testFactoryPaintingTask() {
        //Given
        TaskFactory factory = new TaskFactory();
        //When
        Task painting = factory.whichTask(TaskFactory.PAINTING);
        painting.executeTask();
        //Then
        assertEquals("Impression", painting.getTaskName());
        assertTrue(painting.isTaskExecuted());
    }
}
