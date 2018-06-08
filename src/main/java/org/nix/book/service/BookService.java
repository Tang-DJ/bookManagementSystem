package org.nix.book.service;

import org.nix.book.dao.repositories.BookReposition;
import org.nix.book.dao.repositories.RecordsReposition;
import org.nix.book.dto.BookDto;
import org.nix.book.dto.RecordsDto;
import org.nix.book.dto.SimpleBookDto;
import org.nix.book.dto.base.BaseResultDto;
import org.nix.book.model.BookInfo;
import org.nix.book.model.BorrowRecords;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.lang.Integer.parseInt;

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

    @Autowired
    private RecordsReposition recordsReposition;
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

    /**
     * 书籍详情
     * @param id
     * @return
     * @throws CloneNotSupportedException
     */
    public BaseResultDto findBookById(String id) throws CloneNotSupportedException{
        List<BookInfo> bookInfoList = bookReposition.findBookById(id);

        if (bookInfoList.size()>0){
            return new BookDto(bookInfoList).result();
        }
        return null;

    }

    /**
     * 重写书籍详情
     * @param id
     * @return
     * @throws CloneNotSupportedException
     */
    public BaseResultDto findBookById1(String id) throws CloneNotSupportedException{
        BookInfo bookInfo = bookReposition.findBookById1(id);

        if (bookInfo!=null){
            return new BookDto(bookInfo).result();
        }
        return null;

    }

    /**
     * 判断书是否已经借出
     * @param id
     * @return
     * @throws CloneNotSupportedException
     */
    public boolean hasLend(String id) throws CloneNotSupportedException{
        BookInfo bookInfo = bookReposition.findBookById1(id);

        Integer state = bookInfo.getState();

        //0已经借出，1在库
        if(state==0){
            return false;
        }
        else return true;

    }

    /**
     * 借还书 修改书籍状态
     * @param id
     * @param state
     * @return
     * @throws CloneNotSupportedException
     */
    public BookInfo changeBookState(String id,Integer state) throws CloneNotSupportedException{
        BookInfo bookInfo = bookReposition.findBookById1(id);
        bookInfo.setState(state);
        bookReposition.saveAndFlush(bookInfo);
        return bookInfo;
    }

    /**
     * 删除一本书
     * @param id
     * @return
     * @throws CloneNotSupportedException
     */
    public boolean delBookById(Integer id) throws CloneNotSupportedException{
        bookReposition.deleteById(id);
        return true;
    }

    /**
     * 删除多本书
     * @param ids
     * @return
     * @throws CloneNotSupportedException
     */
    public boolean delBookByIds(Integer[] ids) throws CloneNotSupportedException{
        for(int i = 0;i<ids.length;i++){
            bookReposition.deleteById(ids[i]);
        }
        return true;
    }

    /**
     * 修改图书
     * @param bookInfo
     * @return
     * @throws CloneNotSupportedException
     */
    public boolean updateBook(BookInfo bookInfo) throws CloneNotSupportedException{
        Integer id = bookInfo.getId();
        BookInfo bookInfo1 = bookReposition.findBookById1(id.toString());

        bookInfo1.setState(bookInfo.getState());
        bookInfo1.setPublishCompany(bookInfo.getPublishCompany());
        bookInfo1.setTranslator(bookInfo.getTranslator());
        bookInfo1.setPrice(bookInfo.getPrice());
        bookInfo1.setISBNCode(bookInfo.getISBNCode());
        bookInfo1.setComeUpTime(bookInfo.getComeUpTime());
        bookInfo1.setAuthor(bookInfo.getAuthor());
        bookInfo1.setBookName(bookInfo.getBookName());

        bookReposition.saveAndFlush(bookInfo1);
        return true;
    }
}
