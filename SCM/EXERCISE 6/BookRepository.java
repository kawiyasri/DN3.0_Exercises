package com.library.repository;

import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;

@Repository
public class BookRepository {

    public void getBooks() {
        List<String> books = Arrays.asList("The Great Gatsby", "1984", "To Kill a Mockingbird");
        books.forEach(System.out::println);
    }
}
