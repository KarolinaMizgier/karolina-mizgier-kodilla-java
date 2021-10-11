package com.kodilla.testing.shape;

public class Triangle implements Shape{
    String shapeName;
    Double height;
    Double baseLength;

    public Triangle(String shapeName, Double height, Double baseLength) {
        this.shapeName = shapeName;
        this.height = height;
        this.baseLength = baseLength;
    }

    public String getShapeName() {
        return "Name: "+shapeName+" ";
    }
    public String getField() {
        return "Field: "+String.valueOf((height*baseLength)/2)+" ";
    }
}
