package com.kodilla.patterns.factory.tasks;

import com.kodilla.patterns.factory.Circle;
import com.kodilla.patterns.factory.Rectangle;
import com.kodilla.patterns.factory.Shape;
import com.kodilla.patterns.factory.Square;

public class TaskFactory {
    public static final String SHOPPING = "SHOPPING";
    public static final String PAINTING = "PAINTING";
    public static final String DRIVING = "DRIVING";

    public final Task whichTask(final String taskType) {
        switch (taskType) {
            case SHOPPING:
                return new ShoppingTask("Media Markt", "Hard drive", 1.0);
            case PAINTING:
                return new PaintingTask("Impression", "blue", "night sky");
            case DRIVING:
                return new DrivingTask("Trip", "Berlin", "car");
            default:
                return null;
        }
    }
}
