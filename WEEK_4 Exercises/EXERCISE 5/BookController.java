package com.example.bookstoreapi.controller;

import com.example.bookstoreapi.exception.BookNotFoundException;
import com.example.bookstoreapi.model.Book;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<Book> getBookById(@PathVariable Long id) {
        Book book = books.stream()
                         .filter(b -> b.getId().equals(id))
                         .findFirst()
                         .orElseThrow(() -> new BookNotFoundException("Book not found"));

        return ResponseEntity.ok()
                             .header("Custom-Header", "Book Found")
                             .body(book);
    }

    @PostMapping
    public ResponseEntity<Book> addBook(@RequestBody Book book) {
        books.add(book);
        return ResponseEntity.status(HttpStatus.CREATED)
                             .header("Custom-Header", "Book Created")
                             .body(book);
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
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteBook(@PathVariable Long id) {
        books.removeIf(book -> book.getId().equals(id));
    }
}
