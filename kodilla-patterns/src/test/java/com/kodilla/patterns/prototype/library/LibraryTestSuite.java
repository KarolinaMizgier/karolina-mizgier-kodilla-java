package com.kodilla.patterns.prototype.library;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class LibraryTestSuite {
    @Test
    void testGetBooks() {
        Book book1 = new Book("Solaris", "Stanislaw Lem", LocalDate.of(1998, 10, 21));
        Book book2 = new Book("Teoia Wszystkiego", "Steven Hawking", LocalDate.of(2007, 9, 10));
        Book book3 = new Book("Gra Endera", "Oscar Scott Card", LocalDate.of(2010, 12, 26));

        Library library = new Library("Library1");
        library.getBooks().add(book1);
        library.getBooks().add(book2);
        library.getBooks().add(book3);

        Library clonedLibrary = null;

        try {
            clonedLibrary = library.shallowCopy();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        Library deepClonedLibrary = null;

        try {
            deepClonedLibrary = library.deepCopy();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        library.getBooks().remove(book1);

        //When
        //Then
        assertEquals(2, library.getBooks().size());
        assertEquals(2, clonedLibrary.getBooks().size());
        assertEquals(3, deepClonedLibrary.getBooks().size());
        assertEquals(clonedLibrary.getBooks(), library.getBooks());
        assertNotEquals(deepClonedLibrary.getBooks(), library.getBooks());


    }
}
