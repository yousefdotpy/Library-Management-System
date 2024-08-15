package com.example.library.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class BorrowingRecordDTO {

    private long borrowingRecordId;
    private long bookId;
    private long patronId;
    private LocalDate borrowDate;
    private LocalDate returnDate;
}
