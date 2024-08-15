package com.example.library.service;

import com.example.library.dto.BookDTO;
import com.example.library.model.Book;
import com.example.library.repository.BookRepository;
import com.example.library.mapper.BookMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public List<BookDTO> getAllBooks() {
        return bookRepository.findAll()
                .stream()
                .map(BookMapper::mapToBookDTO)
                .collect(Collectors.toList());
    }

    public Optional<BookDTO> getBookById(Long id) {
        return bookRepository.findById(id).map(BookMapper::mapToBookDTO);
    }

    public BookDTO saveBook(BookDTO bookDTO) {
        Book book = BookMapper.mapToBook(bookDTO);
        Book savedBook = bookRepository.save(book);
        return BookMapper.mapToBookDTO(savedBook);
    }

    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }

}
