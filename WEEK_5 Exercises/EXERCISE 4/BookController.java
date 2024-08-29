package com.example.bookstoreapi.controller;

import com.example.bookstoreapi.metrics.CustomMetrics;
import com.example.bookstoreapi.model.Book;
import com.example.bookstoreapi.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private CustomMetrics customMetrics;

    @PostMapping
    public ResponseEntity<Book> addBook(@RequestBody Book book) {
        customMetrics.incrementBookCreationCounter(); // Increment the custom metric counter
        return ResponseEntity.status(HttpStatus.CREATED).body(bookRepository.save(book));
    }

    // Other methods...
}
