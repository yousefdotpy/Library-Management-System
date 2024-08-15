package com.example.library.service;

import com.example.library.dto.BorrowingRecordDTO;
import com.example.library.mapper.BorrowingRecordMapper;
import com.example.library.model.BorrowingRecord;
import com.example.library.repository.BookRepository;
import com.example.library.repository.BorrowingRecordRepository;
import com.example.library.repository.PatronRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class BorrowingRecordService {

    @Autowired
    private BorrowingRecordRepository borrowingRecordRepository;

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private PatronRepository patronRepository;

    public BorrowingRecordDTO borrowBook(Long bookId, Long patronId) {
        BorrowingRecord record = new BorrowingRecord();
        record.setBook(bookRepository.findById(bookId).orElseThrow(() -> new RuntimeException("Book not found")));
        record.setPatron(patronRepository.findById(patronId).orElseThrow(() -> new RuntimeException("Patron not found")));
        record.setBorrowDate(LocalDate.now());
        BorrowingRecord savedRecord = borrowingRecordRepository.save(record);
        return BorrowingRecordMapper.toDTO(savedRecord);
    }

    public BorrowingRecordDTO returnBook(Long bookId, Long patronId) {
        BorrowingRecord record = borrowingRecordRepository.findByBookIdAndPatronIdAndReturnDateIsNull(bookId, patronId);
        if (record == null) {
            throw new RuntimeException("Borrowing record not found");
        }
        record.setReturnDate(LocalDate.now());
        BorrowingRecord savedRecord = borrowingRecordRepository.save(record);
        return BorrowingRecordMapper.toDTO(savedRecord);
    }
}
