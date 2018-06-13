package org.nix.book.dto;

import org.nix.book.CloneTools;
import org.nix.book.model.BorrowRecords;
import org.nix.book.model.UserModel;

import java.io.IOException;
import java.util.Date;
import java.util.List;

/**
 * @program: bookmanager
 * @description: 借阅记录
 * @author: Tang
 * @create: 2018-06-07 01:36
 **/

public class RecordsDto extends org.nix.bookservice.dto.base.AbstractResultDto {

    private List<BorrowRecords> borrowRecords;

    public RecordsDto(List<BorrowRecords> borrowRecords) {
        this.borrowRecords = borrowRecords;
    }

    @Override
    public void handler() throws CloneNotSupportedException, IOException, ClassNotFoundException {
        for (BorrowRecords model:borrowRecords) {
            if(model.getReturnTime()==null){
                Date date = new Date(0);
                model.setReturnTime(date);
            }
            model.getUserModel().setUserInfoModel(null);
            model.getUserModel().setRoleModel(null);
            model.clone();
        }
    }

    public List<BorrowRecords> getBorrowRecords() {
        return borrowRecords;
    }

    public void setBorrowRecords(List<BorrowRecords> borrowRecords) {
        this.borrowRecords = borrowRecords;
    }
}
