package com.example.bookstoreapi.controller;

import com.example.bookstoreapi.model.Book;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    private List<Book> books = new ArrayList<>();

    public BookController() {
        books.add(new Book(1L, "Spring Boot in Action", "Craig Walls", 29.99, "1234567890"));
        books.add(new Book(2L, "Effective Java", "Joshua Bloch", 39.99, "0987654321"));
    }

    @GetMapping
    public List<Book> getAllBooks() {
        return books;
    }

    @GetMapping("/{id}")
    public Book getBookById(@PathVariable Long id) {
        return books.stream()
                    .filter(book -> book.getId().equals(id))
                    .findFirst()
                    .orElse(null);
    }

    @PostMapping
    public Book addBook(@RequestBody Book book) {
        books.add(book);
        return book;
    }

    @PutMapping("/{id}")
    public Book updateBook(@PathVariable Long id, @RequestBody Book updatedBook) {
        books.stream()
             .filter(book -> book.getId().equals(id))
             .forEach(book -> {
                 book.setTitle(updatedBook.getTitle());
                 book.setAuthor(updatedBook.getAuthor());
                 book.setPrice(updatedBook.getPrice());
                 book.setIsbn(updatedBook.getIsbn());
             });
        return updatedBook;
    }

    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable Long id) {
        books.removeIf(book -> book.getId().equals(id));
    }
}
