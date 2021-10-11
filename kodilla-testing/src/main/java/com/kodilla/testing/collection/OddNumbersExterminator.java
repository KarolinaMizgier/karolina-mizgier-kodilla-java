package com.kodilla.testing.collection;

import java.util.ArrayList;
import java.util.List;

public class OddNumbersExterminator {
    public List<Integer> exterminate(List<Integer> numbers) {
        List<Integer> even = new ArrayList<>();
        for (Integer a : numbers) {
            if (a % 2 == 0) {
                even.add(a);
            }
        }
        return even;
    }
}
