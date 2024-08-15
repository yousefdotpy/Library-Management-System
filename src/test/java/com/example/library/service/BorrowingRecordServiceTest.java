package com.example.library.service;

import com.example.library.dto.BorrowingRecordDTO;
import com.example.library.mapper.BorrowingRecordMapper;
import com.example.library.model.BorrowingRecord;
import com.example.library.model.Book;
import com.example.library.model.Patron;
import com.example.library.repository.BorrowingRecordRepository;
import com.example.library.repository.BookRepository;
import com.example.library.repository.PatronRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

public class BorrowingRecordServiceTest {

    @InjectMocks
    private BorrowingRecordService borrowingRecordService;

    @Mock
    private BorrowingRecordRepository borrowingRecordRepository;

    @Mock
    private BookRepository bookRepository;

    @Mock
    private PatronRepository patronRepository;

    public BorrowingRecordServiceTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testBorrowBook() {
        Book book = new Book();
        book.setBookId(1L);

        Patron patron = new Patron();
        patron.setPatronId(1L);

        BorrowingRecord record = new BorrowingRecord();
        record.setBook(book);
        record.setPatron(patron);
        record.setBorrowDate(LocalDate.now());

        when(bookRepository.findById(1L)).thenReturn(Optional.of(book));
        when(patronRepository.findById(1L)).thenReturn(Optional.of(patron));
        when(borrowingRecordRepository.save(any(BorrowingRecord.class))).thenReturn(record);

        BorrowingRecordDTO recordDTO = BorrowingRecordMapper.toDTO(record);
        assertEquals(recordDTO, borrowingRecordService.borrowBook(1L, 1L));
    }

    @Test
    void testReturnBook() {
        BorrowingRecord record = new BorrowingRecord();
        record.setId(1L);
        record.setReturnDate(null);

        when(borrowingRecordRepository.findByBookIdAndPatronIdAndReturnDateIsNull(1L, 1L)).thenReturn(record);
        when(borrowingRecordRepository.save(record)).thenReturn(record);

        BorrowingRecordDTO recordDTO = BorrowingRecordMapper.toDTO(record);
        assertEquals(recordDTO, borrowingRecordService.returnBook(1L, 1L));
    }

    @Test
    void testReturnBookNotFound() {
        when(borrowingRecordRepository.findByBookIdAndPatronIdAndReturnDateIsNull(1L, 1L)).thenReturn(null);

        assertThrows(RuntimeException.class, () -> borrowingRecordService.returnBook(1L, 1L));
    }
}
