package com.kodilla.good.patterns.challenges;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main(String args[]) {
        Map<String, List<String>> map = new MovieStore().getMovies();
        List<List<String>> allBooks = map.entrySet().stream()
                .map(Map.Entry::getValue)
                .collect(Collectors.toList());
        String books = allBooks.stream().flatMap(l -> l.stream())
                .collect(Collectors.joining("!"));
        System.out.println(books + "!");
    }

}
