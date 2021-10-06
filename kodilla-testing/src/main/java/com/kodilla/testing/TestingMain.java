package com.kodilla.testing;

import com.kodilla.testing.calculator.Calculator;

public class TestingMain {
     public static void main(String[] args) {
          //Test dodawania
          Calculator calculator = new Calculator();
          Integer result = calculator.add(13,7);
          Integer expectedResult = 20;
          if(result.equals(expectedResult)) {
               System.out.println("test OK");
          }
          else {
               System.out.println("Error!");
          }
          // Test odejmowania
          Calculator calculator2 = new Calculator();
          Integer result2 = calculator2.subtract(13,7);
          Integer expectedResult2 = 6;
          if(result2.equals(expectedResult2)) {
               System.out.println("test OK");
          }
          else {
               System.out.println("Error!");
          }
     }
}
