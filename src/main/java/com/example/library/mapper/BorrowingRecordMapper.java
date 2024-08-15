package com.example.library.mapper;

import com.example.library.dto.BorrowingRecordDTO;
import com.example.library.model.BorrowingRecord;

public class BorrowingRecordMapper {
    public static BorrowingRecordDTO toDTO(BorrowingRecord record){
        BorrowingRecordDTO dto = new BorrowingRecordDTO();
        dto.setBorrowingRecordId(record.getId());
        dto.setBookId(record.getBook().getBookId());
        dto.setPatronId(record.getPatron().getPatronId());
        dto.setBorrowDate(record.getBorrowDate());
        dto.setReturnDate(record.getReturnDate());
        return dto;
    }

    public static BorrowingRecord toEntity(BorrowingRecordDTO dto){
        BorrowingRecord record = new BorrowingRecord();
        record.setId(dto.getBorrowingRecordId());
        record.getBook().setBookId(dto.getBookId());
        record.getPatron().setPatronId(dto.getPatronId());
        record.setBorrowDate(dto.getBorrowDate());
        record.setReturnDate(dto.getReturnDate());
        return record;
    }
}
