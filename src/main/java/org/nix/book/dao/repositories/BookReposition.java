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
            value = "SELECT id,book_name,come_up_time,publish_company FROM book_info ")
    List<BookInfo> getSimpleBookList();

}
