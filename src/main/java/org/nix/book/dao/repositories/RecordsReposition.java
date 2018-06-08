package org.nix.book.dao.repositories;

import org.nix.book.model.BorrowRecords;
import org.nix.book.model.RoleModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RecordsReposition extends JpaRepository<BorrowRecords,Integer> {

    @Query(nativeQuery = true,
            value = "SELECT * FROM borrow_records ")
    List<BorrowRecords> findRecordsList();


    @Query(nativeQuery = true,
            value = "SELECT * FROM borrow_records WHERE id=?1")
    BorrowRecords findBorrowRecordsById(String id);

    @Query(nativeQuery = true,
            value = "SELECT * FROM borrow_records WHERE user_model=?1")
    List<BorrowRecords> findBorrowRecordsByUserId(String id);


}
