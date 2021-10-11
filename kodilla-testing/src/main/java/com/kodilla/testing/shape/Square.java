package com.kodilla.testing.shape;

public class Square implements Shape{
    String shapeName;
    Double side;

    public Square(String shapeName, Double side) {
        this.shapeName = shapeName;
        this.side = side;
    }

    public String getShapeName() {
        return "Name: " +shapeName + " ";
    }
    public String getField() {
        return "Field: "+String.valueOf(side*side)+" ";
    }
}
