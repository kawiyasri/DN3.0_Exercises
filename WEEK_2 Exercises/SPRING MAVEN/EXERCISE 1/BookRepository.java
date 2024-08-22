package com.library.repository;

import java.util.Arrays;
import java.util.List;

public class BookRepository {

    public void getBooks() {
        List<String> books = Arrays.asList("The Great Gatsby", "1984", "To Kill a Mockingbird");
        books.forEach(System.out::println);
    }
}
