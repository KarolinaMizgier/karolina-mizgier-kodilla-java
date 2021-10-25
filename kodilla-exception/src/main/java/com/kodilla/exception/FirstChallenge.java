package com.kodilla.exception;

public class FirstChallenge {
    public double divide(double a, double b) {
        double result = a / b;
        try {
            if (b == 0) {
                throw new ArithmeticException();
            }
        } catch (ArithmeticException e) {
            System.out.println("Nie można dzielić przez 0!");
        } finally {
            System.out.println("Dzielnik: " + b + " Dzielna: " + a);
        }
        return result;
    }


    /**
     * This main can throw an ArithmeticException!!!
     *
     * @param args
     */
    public static void main(String[] args) {
        FirstChallenge firstChallenge = new FirstChallenge();
        double result = firstChallenge.divide(4, 0);

        System.out.println("Wynik: " + result);
    }
}
