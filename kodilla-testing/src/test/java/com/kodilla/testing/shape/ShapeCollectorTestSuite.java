package com.kodilla.testing.shape;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class ShapeCollectorTestSuite {
    Shape circle = new Circle("Circle", 5.0);
    Shape triangle = new Triangle("Triangle", 4.0, 5.0);
    Shape square = new Square("Square", 5.0);
    ShapeCollector shapeCollector = new ShapeCollector();
    @Nested
    @DisplayName("Test Shape")
    class ShapeTest {
        @Nested
        @DisplayName("Test Circle")
        class CircleTest {
            @Test
            void testGetShapeName() {
                shapeCollector.addFigure(circle);
                String name = shapeCollector.getFigure(0).getShapeName();
                String expectedName = "Name: Circle ";
                Assertions.assertEquals(expectedName, name);
            }

            @Test
            void testGetField() {
                shapeCollector.addFigure(circle);
                String field = shapeCollector.getFigure(0).getField();
                String expectedField = "Field: 78.5 ";
                Assertions.assertEquals(field, expectedField);
            }
        }

        @Nested
        @DisplayName("Test Square")
        class SquareTest {
            @Test
            void testGetShapeName() {
                shapeCollector.addFigure(square);
                String name = shapeCollector.getFigure(0).getShapeName();
                String expectedName = "Name: Square ";
                Assertions.assertEquals(expectedName, name);
            }

            @Test
            void testGetField() {
                shapeCollector.addFigure(square);
                String field = shapeCollector.getFigure(0).getField();
                String expectedField = "Field: 25.0 ";
                Assertions.assertEquals(field, expectedField);
            }
        }

        @Nested
        @DisplayName("Test Triangle")
        class TriangleTest {
            @Test
            void testGetShapeName() {
                shapeCollector.addFigure(triangle);
                String name = shapeCollector.getFigure(0).getShapeName();
                String expectedName = "Name: Triangle ";
                Assertions.assertEquals(expectedName, name);
            }

            @Test
            void testGetField() {
                shapeCollector.addFigure(triangle);
                String field = shapeCollector.getFigure(0).getField();
                String expectedField = "Field: 10.0 ";
                Assertions.assertEquals(field, expectedField);
            }
        }
    }

    @Nested
    @DisplayName("Test ShapeCollector")
    class ShapeCollectorTest {
        @Test
        void testAddFigure() {
            shapeCollector.addFigure(circle);
            List<Shape> content = shapeCollector.getList();
            Shape added = content.get(0);
            Assertions.assertEquals(circle, added);
        }

        @Test
        void testRemoveFigure() {
            shapeCollector.addFigure(square);
            shapeCollector.addFigure(circle);
            shapeCollector.addFigure(triangle);
            List<Shape> content = shapeCollector.getList();
            System.out.println(content.size());
            for (Shape s : content) {
                System.out.println(s.getField() + s.getShapeName());
            }
            shapeCollector.removeFigure(circle);
            System.out.println(content.size());
            for (Shape s : content) {
                System.out.println(s.getField() + s.getShapeName());
            }
            List<Shape> expected = Arrays.asList(square, triangle);
            Assertions.assertEquals(content, expected);
        }

        @Test
        void testGetFigure() {
            shapeCollector.addFigure(square);
            shapeCollector.addFigure(circle);
            shapeCollector.addFigure(triangle);
            List<Shape> content = shapeCollector.getList();
            System.out.println(content.size());
            for (Shape s : content) {
                System.out.println(s.getShapeName() + s.getField());
            }
            Shape shape = shapeCollector.getFigure(0);
            System.out.println("First in list: " + shape.getShapeName() + shape.getField());
            Assertions.assertEquals(square, shape);
        }

        @Test
        void testShowFigures() {
            shapeCollector.addFigure(square);
            shapeCollector.addFigure(circle);
            shapeCollector.addFigure(triangle);
            String figures = shapeCollector.showFigures();
            String expected = "Name: Square Field: 25.0 \n" +
                    "Name: Circle Field: 78.5 \n" +
                    "Name: Triangle Field: 10.0 \n";
            Assertions.assertEquals(expected, figures);
        }
    }
}

