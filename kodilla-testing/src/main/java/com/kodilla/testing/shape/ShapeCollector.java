package com.kodilla.testing.shape;

import java.util.ArrayList;
import java.util.List;

public class ShapeCollector {

    List<Shape> figures = new ArrayList<>();

    public void addFigure(Shape shape) {
        figures.add(shape);
    }

    public void removeFigure(Shape shape) {
        figures.remove(shape);
    }

    public Shape getFigure(int n) {
        return figures.get(n);

    }

    public String showFigures() {
        String string = "";
        for (Shape s : figures) {
            string += s.getShapeName() + s.getField() + "\n";
        }
        return string;
    }

    public List<Shape> getList() {
        return figures;
    }
}
