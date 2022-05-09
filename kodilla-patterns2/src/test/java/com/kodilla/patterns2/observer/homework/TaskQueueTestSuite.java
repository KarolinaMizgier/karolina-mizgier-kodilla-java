package com.kodilla.patterns2.observer.homework;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TaskQueueTestSuite {

    @Test
    public void testUpdate() {
        // Given
        Student karolinaMizgier = new Student("KarolinaMizgier");
        Student dummyStudent = new Student("DummyStudent");
        Mentor javaMentor = new Mentor("JavaMentor");
        Mentor sqlMentor = new Mentor("SqlMentor");
        karolinaMizgier.registerObserver(javaMentor);
        karolinaMizgier.registerObserver(sqlMentor);
        dummyStudent.registerObserver(javaMentor);
        // When
        karolinaMizgier.addTask(new Task("http://www.kdodilla.com/facade"));
        karolinaMizgier.addTask(new Task("http://www.kdodilla.com/aspect"));
        karolinaMizgier.addTask(new Task("http://www.kdodilla.com/observer"));
        dummyStudent.addTask(new Task("http://www.kdodilla.com/adapter"));
        dummyStudent.addTask(new Task("http://www.kdodilla.com/decor"));
        // Then
        System.out.println(javaMentor.getName() + " " + javaMentor.getTaskCheckCount());
        System.out.println(sqlMentor.getName() + " " + sqlMentor.getTaskCheckCount());
        assertEquals(5, javaMentor.getTaskCheckCount());
        assertEquals(3, sqlMentor.getTaskCheckCount());
    }
}
