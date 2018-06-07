package org.nix.book.dto;

import org.nix.book.dto.base.AbstractResultDto;
import org.nix.book.model.BorrowRecords;
import org.nix.book.model.UserModel;

import java.util.List;

/**
 * @program: bookmanager
 * @description: 借阅记录
 * @author: Tang
 * @create: 2018-06-07 01:36
 **/

public class RecordsDto extends AbstractResultDto {

    private List<BorrowRecords> borrowRecords;


    public RecordsDto(List<BorrowRecords> borrowRecords) {
        this.borrowRecords = borrowRecords;
    }

    @Override
    public void handler() throws CloneNotSupportedException {
        for (BorrowRecords model:borrowRecords) {
            model.setBorrowTime(null);
        }
    }

    public List<BorrowRecords> getBorrowRecords() {
        return borrowRecords;
    }

    public void setBorrowRecords(List<BorrowRecords> borrowRecords) {
        this.borrowRecords = borrowRecords;
    }
}
