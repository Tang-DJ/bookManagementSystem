package org.nix.book.dao.repositories;

import org.nix.book.model.BookInfo;
import org.nix.book.model.BorrowRecords;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BookReposition extends JpaRepository<BookInfo,Integer> {

    @Query(nativeQuery = true,
            value = "SELECT * FROM book_info ")
    List<BookInfo> findBookList();


}
