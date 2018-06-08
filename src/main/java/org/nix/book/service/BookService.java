package org.nix.book.service;

import org.nix.book.dao.repositories.BookReposition;
import org.nix.book.dto.BookDto;
import org.nix.book.dto.RecordsDto;
import org.nix.book.dto.SimpleBookDto;
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

    /**
     * 获得最受欢迎图书列表
     * @return
     * @throws CloneNotSupportedException
     */
    public BaseResultDto getSimpleBookList() throws CloneNotSupportedException{
        List<BookInfo> bookInfoList = bookReposition.findBookList();

        if (bookInfoList.size()>0){
            return new SimpleBookDto(bookInfoList).result();
        }
        return null;
    }

    /**
     * 获得图书列表根据时间排序
     * @return
     * @throws CloneNotSupportedException
     */
    public BaseResultDto getSimpleBookListOrderByComingUpTime() throws CloneNotSupportedException{
        List<BookInfo> bookInfoList = bookReposition.findBookListOrderByComeUpTime();

        if (bookInfoList.size()>0){
            return new SimpleBookDto(bookInfoList).result();
        }
        return null;
    }

    public BaseResultDto findBookById(String id) throws CloneNotSupportedException{
        List<BookInfo> bookInfoList = bookReposition.findBookById(id);

        if (bookInfoList.size()>0){
            return new BookDto(bookInfoList).result();
        }
        return null;

    }


}
