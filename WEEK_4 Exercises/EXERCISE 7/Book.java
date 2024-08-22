//Customize Book Entity Serialization/Deserialization:
package com.example.bookstoreapi.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

@Data
public class Book {
    private Long id;
    private String title;
    private String author;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "$#.00")
    private Double price;

    private String isbn;
}
