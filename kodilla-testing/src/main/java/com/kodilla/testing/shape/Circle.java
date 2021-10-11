package com.kodilla.testing.shape;

public class Circle implements Shape {
    String shapeName;
    Double radius;
    public Circle(String shapeName, Double radius) {
        this.shapeName = shapeName;
        this.radius = radius;
    }
    public String getShapeName() {
        return "Name: " +shapeName+ " ";
    }
    public String getField() {
        return "Field: "+String.valueOf(3.14*Math.pow(radius,2))+" ";
    }
}
