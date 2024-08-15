package com.example.library.dto;

import lombok.Data;

@Data
public class BookDTO {

    private long bookId;
    private String bookTitle;
    private String bookAuthor;
    private int publicationYear;
    private int isbn;
}