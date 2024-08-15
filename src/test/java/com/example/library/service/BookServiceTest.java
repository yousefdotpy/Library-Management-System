package com.example.library.service;

import com.example.library.dto.BookDTO;
import com.example.library.mapper.BookMapper;
import com.example.library.model.Book;
import com.example.library.repository.BookRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Collections;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

public class BookServiceTest {

    @InjectMocks
    private BookService bookService;

    @Mock
    private BookRepository bookRepository;

    public BookServiceTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetAllBooks() {
        Book book = new Book();
        book.setBookId(1L);
        book.setBookTitle("Test Book");
        book.setBookAuthor("Test Author");
        book.setIsbn(222);
        book.setPublicationYear(1677);

        when(bookRepository.findAll()).thenReturn(Collections.singletonList(book));

        BookDTO bookDTO = BookMapper.mapToBookDTO(book);
        assertEquals(Collections.singletonList(bookDTO), bookService.getAllBooks());
    }

    @Test
    void testGetBookById() {
        Book book = new Book();
        book.setBookId(1L);
        book.setBookTitle("Test Book");
        book.setBookAuthor("Test Author");
        book.setIsbn(222);
        book.setPublicationYear(1677);

        when(bookRepository.findById(1L)).thenReturn(Optional.of(book));

        BookDTO bookDTO = BookMapper.mapToBookDTO(book);
        assertEquals(Optional.of(bookDTO), bookService.getBookById(1L));
    }

    @Test
    void testSaveBook() {
        BookDTO bookDTO = new BookDTO();

        bookDTO.setBookTitle("Test Book");
        bookDTO.setBookAuthor("Test Author");
        bookDTO.setIsbn(222);
        bookDTO.setPublicationYear(1677);

        Book book = BookMapper.mapToBook(bookDTO);

        when(bookRepository.save(book)).thenReturn(book);

        assertEquals(bookDTO, bookService.saveBook(bookDTO));
    }

    @Test
    void testDeleteBook() {
        bookService.deleteBook(1L);
        verify(bookRepository, times(1)).deleteById(1L);
    }
}
