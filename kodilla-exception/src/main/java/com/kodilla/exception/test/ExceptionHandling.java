package com.kodilla.exception.test;

public class ExceptionHandling extends Exception{
    public String checkSecondChallenge(Double x, Double y){
        SecondChallenge secondChallenge = new SecondChallenge();
        try {
            return secondChallenge.probablyIWillThrowException(x,y);
        } catch (Exception e) {
            System.out.println("Second challenge has been interrupted, empty value will be returned");
            e.printStackTrace();
            return "";
        }
    }
}
