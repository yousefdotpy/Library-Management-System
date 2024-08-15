package com.example.library.controller;

import com.example.library.dto.BorrowingRecordDTO;
import com.example.library.service.BorrowingRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/borrowings")
public class BorrowingRecordController {

    @Autowired
    private BorrowingRecordService borrowingRecordService;

    @PostMapping("/borrow/{bookId}/patron/{patronId}")
    public BorrowingRecordDTO borrowBook(@PathVariable Long bookId, @PathVariable Long patronId) {
        return borrowingRecordService.borrowBook(bookId, patronId);
    }

    @PutMapping("/return/{bookId}/patron/{patronId}")
    public BorrowingRecordDTO returnBook(@PathVariable Long bookId, @PathVariable Long patronId) {
        return borrowingRecordService.returnBook(bookId, patronId);
    }
}