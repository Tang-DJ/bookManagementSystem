package org.nix.book.service;

import org.nix.book.dao.repositories.RecordsReposition;
import org.nix.book.dto.RecordsDto;
import org.nix.book.dto.base.BaseResultDto;
import org.nix.book.model.BorrowRecords;
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

    /**
     * 借阅记录全列表
     * @return
     * @throws CloneNotSupportedException
     */
    public BaseResultDto findRecordsList() throws CloneNotSupportedException{
        List<BorrowRecords> borrowRecords = recordsReposition.findRecordsList();

        System.out.println(borrowRecords);
        if (borrowRecords.size()>0){
            return new RecordsDto(borrowRecords).result();
        }
        return null;
    }

    /**
     * 添加借阅记录
     * @param borrowRecords
     * @return
     * @throws CloneNotSupportedException
     */
    public boolean addRecord(BorrowRecords borrowRecords) throws CloneNotSupportedException{
        recordsReposition.save(borrowRecords);
        return true;
    }

    /**
     * 更新借阅记录
     * @param borrowRecords
     * @return
     * @throws CloneNotSupportedException
     */
    public boolean updateRecord(BorrowRecords borrowRecords) throws CloneNotSupportedException{
        recordsReposition.saveAndFlush(borrowRecords);
        return true;
    }


    /**
     * 根据借阅id寻找借阅记录
     * @param id
     * @return
     * @throws CloneNotSupportedException
     */
    public BorrowRecords findBorrowRecordsById(String id) throws CloneNotSupportedException{
        return recordsReposition.findBorrowRecordsById(id);
    }


    /**
     * 根据用户id 寻找借阅记录
     * @param id
     * @return
     * @throws CloneNotSupportedException
     */
    public BaseResultDto findBorrowRecordsByUserId(String id) throws CloneNotSupportedException{
        List<BorrowRecords> borrowRecords = recordsReposition.findBorrowRecordsByUserId(id);

        System.out.println(borrowRecords);
        if (borrowRecords.size()>0){
            return new RecordsDto(borrowRecords).result();
        }
        return null;
    }

}


