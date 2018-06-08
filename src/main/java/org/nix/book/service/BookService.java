package org.nix.book.service;

import org.nix.book.dao.repositories.BookReposition;
import org.nix.book.dto.BookDto;
import org.nix.book.dto.RecordsDto;
import org.nix.book.dto.base.BaseResultDto;
import org.nix.book.model.BookInfo;
import org.nix.book.model.BorrowRecords;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: bookmanager
 * @description: 图书
 * @author: Tang
 * @create: 2018-06-07 01:25
 **/

@Service
public class BookService {

    @Autowired
    private BookReposition bookReposition;

    /**
     * 获得图书列表
     * @return
     * @throws CloneNotSupportedException
     */
    public BaseResultDto findBookList() throws CloneNotSupportedException{
        List<BookInfo> bookInfoList = bookReposition.findBookList();

        if (bookInfoList.size()>0){
            return new BookDto(bookInfoList).result();
        }
        return null;
    }

    public BaseResultDto getSimpleBookList() throws CloneNotSupportedException{
        List<BookInfo> bookInfoList = bookReposition.getSimpleBookList();

        if (bookInfoList.size()>0){
            return new BookDto(bookInfoList).result();
        }
        return null;
    }



}
