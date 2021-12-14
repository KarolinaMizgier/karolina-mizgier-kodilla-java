package com.kodilla.patterns.strategy.social;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserTestSuite {
    @Test
    void testDefaultSharingStrategies() {
        //Given
        User john = new Millenials("John");
        User anna = new YGeneration("Anna");
        User adam = new ZGeneration("Adam");
        //When
        String johnsPublisher = john.sharePost();
        String annasPublisher = anna.sharePost();
        String adamsPublisher = adam.sharePost();
        //Then
        assertEquals("Facebook", johnsPublisher);
        assertEquals("Twitter", annasPublisher);
        assertEquals("Snapchat", adamsPublisher);
    }

    @Test
    void testIndividualSharingStrategy() {
        //Given
        User john = new Millenials("John");
        //When
        john.setSocialPublisher(new SnapchatPublisher());
        String johnsPublisher = john.sharePost();
        //Then
        assertEquals("Snapchat", johnsPublisher);
    }
}
