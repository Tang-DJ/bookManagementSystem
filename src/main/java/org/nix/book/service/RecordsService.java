package org.nix.book.service;

import org.nix.book.dao.repositories.RecordsReposition;
import org.nix.book.dao.repositories.RoleReposition;
import org.nix.book.dto.RecordsDto;
import org.nix.book.dto.RoleDto;
import org.nix.book.dto.base.BaseResultDto;
import org.nix.book.model.BorrowRecords;
import org.nix.book.model.RoleModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: bookmanager
 * @description: 借阅记录
 * @author: Tang
 * @create: 2018-06-07 01:25
 **/
@Service
public class RecordsService {

    @Autowired
    private RecordsReposition recordsReposition;

    public BaseResultDto findRecordsList() throws CloneNotSupportedException{
        List<BorrowRecords> borrowRecords = recordsReposition.findRecordsList();

        System.out.println(borrowRecords);
        if (borrowRecords.size()>0){
            return new RecordsDto(borrowRecords).result();
        }
        return null;
    }

}


