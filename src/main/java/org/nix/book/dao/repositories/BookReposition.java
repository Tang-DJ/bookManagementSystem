package org.nix.book.dao.repositories;

import org.nix.book.model.BookInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BookReposition extends JpaRepository<BookInfo,Integer> {

    @Query(nativeQuery = true,
            value = "SELECT * FROM book_info ")
    List<BookInfo> findBookList();

    @Query(nativeQuery = true,
            value = "SELECT * FROM book_info ORDER BY come_up_time DESC")
    List<BookInfo> findBookListOrderByComeUpTime();

    @Query(nativeQuery = true,
            value = "SELECT * FROM book_info WHERE id = ?1")
    List<BookInfo> findBookById(String id);

    @Query(nativeQuery = true,
            value = "SELECT * FROM book_info WHERE id = ?1")
    BookInfo findBookById1(String id);


}
