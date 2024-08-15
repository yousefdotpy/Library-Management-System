package com.example.library.repository;

import com.example.library.model.BorrowingRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface BorrowingRecordRepository extends JpaRepository<BorrowingRecord, Long> {
    @Query("SELECT br FROM BorrowingRecord br WHERE br.book.id = :bookId AND br.patron.id = :patronId AND br.returnDate IS NULL")
    BorrowingRecord findByBookIdAndPatronIdAndReturnDateIsNull(@Param("bookId") Long bookId, @Param("patronId") Long patronId);
}
