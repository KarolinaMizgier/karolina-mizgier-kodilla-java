package com.kodilla.stream;

import com.kodilla.stream.beautifier.PoemBeautifier;

import java.util.Locale;

public class StreamMain {

    public static void main(String[] args) {
        PoemBeautifier poemBeautifier = new PoemBeautifier();

        String text1 = poemBeautifier.beautify("Ala ma kota", (text) -> "ABC" + text + "ABC");
        String text2 = poemBeautifier.beautify("Ala ma kota", (text) -> text.toUpperCase(Locale.ROOT));
        String text3 = poemBeautifier.beautify("Ala ma kota", (text) -> text.replaceAll(" ", "_"));
        String text4 = poemBeautifier.beautify("Ala ma kota", (text) -> text.replace("a", "@"));
        System.out.println(text1);
        System.out.println(text2);
        System.out.println(text3);
        System.out.println(text4);
    }
}
