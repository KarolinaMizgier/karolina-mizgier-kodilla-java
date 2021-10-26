package com.kodilla.exception.test;

public class ExceptionHandling extends Exception{
    public static String checkSecondChallenge(Double x, Double y){
        try {
            return SecondChallenge.probablyIWillThrowException(x, y);
        } catch (Exception e) {
            System.out.println("Second challenge has been interrupted, empty value will be returned");
            e.printStackTrace();
            return "";
        }
    }
}
