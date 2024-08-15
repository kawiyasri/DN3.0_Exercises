package com.library;

import com.library.service.BookService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class LibraryManagementApp {
    public static void main(String[] args) {
        // Load the Spring application context from the XML configuration
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        // Retrieve the BookService bean from the context
        BookService bookService = (BookService) context.getBean("bookService");

        // Use the BookService to display books, which verifies the DI setup
        bookService.displayBooks();
    }
}
