package com.kodilla.exception;

public class FirstChallenge {
    public double divide(double a, double b) {
        if (b == 0) {
            throw new ArithmeticException("Division by zero");
        }
        return a / b;
    }

    /**
     * This main can throw an ArithmeticException!!!
     *
     * @param args
     */
    public static void main(String[] args) {
        FirstChallenge firstChallenge = new FirstChallenge();
        try {
            double result = firstChallenge.divide(4, 0);
            System.out.println("Result: " + result);
        } catch (ArithmeticException e) {
            System.out.println("Bad operation: " + e.getMessage());
        }
    }
}
