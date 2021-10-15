package com.kodilla.testing.forum.statistics;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class StatisticsCalculatortestSuite {
    @Mock
    private Statistics statisticsMock;

    @Nested
    @DisplayName("Test CalculateAdvStatistics")
    class testCalculateAdvStatistics {

        @Nested
        @DisplayName("Test according to post count")
        class TestAccordingToPostCount {

            @BeforeEach
            public void mockData() {
                List<String> userNames = Arrays.asList("Ania", "Monika", "Ala", "Daniel", "Andrzej");
                when(statisticsMock.usersNames()).thenReturn(userNames);
                when(statisticsMock.commentsCount()).thenReturn(1000);
            }   //Przyjmuję, że liczba użytkowników wyniesie 5 a komentarzy 1000

            @Test
            public void testWhen0posts() {
                //Given
                StatisticsCalculator statisticsCalculator = new StatisticsCalculator();
                when(statisticsMock.postsCount()).thenReturn(0);
                //When
                statisticsCalculator.calculateAdvStatistics(statisticsMock);
                double postAverage = statisticsCalculator.getPostAverage();
                double commentPerPostAverage = statisticsCalculator.getCommentPerPostAverage();
                //Then
                Assertions.assertEquals(0.0, postAverage);
                Assertions.assertEquals(0.0, commentPerPostAverage);
            }

            @Test
            public void testWhen1000posts() {
                //Given
                StatisticsCalculator statisticsCalculator = new StatisticsCalculator();
                when(statisticsMock.postsCount()).thenReturn(1000);
                //When
                statisticsCalculator.calculateAdvStatistics(statisticsMock);
                double postAverage = statisticsCalculator.getPostAverage();
                double commentPerPostAverage = statisticsCalculator.getCommentPerPostAverage();
                //Then
                Assertions.assertEquals(200.0, postAverage);
                Assertions.assertEquals(1.0, commentPerPostAverage);
            }
        }

        @Nested
        @DisplayName("Test according to comment count")
        class TestAccordingToCommentCount {
            @BeforeEach
            public void mockData() {
                List<String> userNames = Arrays.asList("Ania", "Monika", "Ala", "Daniel", "Andrzej");
                when(statisticsMock.usersNames()).thenReturn(userNames);
                when(statisticsMock.postsCount()).thenReturn(100);
            }   //Przyjmuję, że liczba użytkowników wyniesie 5 a postów 100

            @Test
            public void testWhen0comments() {
                //Given
                StatisticsCalculator statisticsCalculator = new StatisticsCalculator();
                when(statisticsMock.commentsCount()).thenReturn(0);
                //When
                statisticsCalculator.calculateAdvStatistics(statisticsMock);
                double commentAverage = statisticsCalculator.getCommentAverage();
                double commentPerPostAverage = statisticsCalculator.getCommentPerPostAverage();
                //Then
                Assertions.assertEquals(0.0, commentAverage);
                Assertions.assertEquals(0.0, commentPerPostAverage);
            }

            @Test
            public void testWhenLessCommentsThanPosts() {
                //Given
                StatisticsCalculator statisticsCalculator = new StatisticsCalculator();
                when(statisticsMock.commentsCount()).thenReturn(50);
                //When
                statisticsCalculator.calculateAdvStatistics(statisticsMock);
                double commentAverage = statisticsCalculator.getCommentAverage();
                double commentPerPostAverage = statisticsCalculator.getCommentPerPostAverage();
                //Then
                Assertions.assertEquals(10.0, commentAverage);
                Assertions.assertEquals(0.5, commentPerPostAverage);
            }

            @Test
            public void testWhenMoreCommentsThanPosts() {
                //Given
                StatisticsCalculator statisticsCalculator = new StatisticsCalculator();
                when(statisticsMock.commentsCount()).thenReturn(150);
                //When
                statisticsCalculator.calculateAdvStatistics(statisticsMock);
                double commentAverage = statisticsCalculator.getCommentAverage();
                double commentPerPostAverage = statisticsCalculator.getCommentPerPostAverage();
                //Then
                Assertions.assertEquals(30.0, commentAverage);
                Assertions.assertEquals(1.5, commentPerPostAverage);
            }

        }

        @Nested
        @DisplayName("Test according to user count")
        class TestAccordingToUserCount {
            @BeforeEach
            public void mockData() {
                when(statisticsMock.postsCount()).thenReturn(100);
                when(statisticsMock.commentsCount()).thenReturn(150);
            }   //Przyjmuję, że liczba postów wynosi 100, a komentarzy 150

            @Test
            public void testWhen0Users() {
                //Given
                StatisticsCalculator statisticsCalculator = new StatisticsCalculator();
                when(statisticsMock.usersNames()).thenReturn(Collections.emptyList());
                //When
                statisticsCalculator.calculateAdvStatistics(statisticsMock);
                double commentAverage = statisticsCalculator.getCommentAverage();
                double postAverage = statisticsCalculator.getPostAverage();
                //Then
                Assertions.assertEquals(0.0, commentAverage);
                Assertions.assertEquals(0.0, postAverage);
            }

            @Test
            public void testWhen100Users() {
                //Given
                StatisticsCalculator statisticsCalculator = new StatisticsCalculator();
                List<String> usrNames = new ArrayList<>();
                for (int i = 0; i < 100; i++) {
                    usrNames.add(String.valueOf(i));
                }
                when(statisticsMock.usersNames()).thenReturn(usrNames);
                //When
                statisticsCalculator.calculateAdvStatistics(statisticsMock);
                double commentAverage = statisticsCalculator.getCommentAverage();
                double postAverage = statisticsCalculator.getPostAverage();
                //Then
                Assertions.assertEquals(1.5, commentAverage);
                Assertions.assertEquals(1.0, postAverage);
            }
        }
    }
}
