package com.example.library.mapper;

import com.example.library.dto.BookDTO;
import com.example.library.model.Book;

public class BookMapper {

    public static BookDTO mapToBookDTO(Book book) {
        BookDTO bookDTO = new BookDTO();
        bookDTO.setBookId(book.getBookId());
        bookDTO.setBookTitle(book.getBookTitle());
        bookDTO.setBookAuthor(book.getBookAuthor());
        bookDTO.setPublicationYear(book.getPublicationYear());
        bookDTO.setIsbn(book.getIsbn());
        return bookDTO;
    }

    public static Book mapToBook(BookDTO bookDTO) {
        Book book = new Book();
        book.setBookId(bookDTO.getBookId());
        book.setBookTitle(bookDTO.getBookTitle());
        book.setBookAuthor(bookDTO.getBookAuthor());
        book.setPublicationYear(bookDTO.getPublicationYear());
        book.setIsbn(bookDTO.getIsbn());
        return book;
    }
}
