package org.nix.book.controller;

import org.nix.book.dto.base.BaseResultDto;
import org.nix.book.model.BookInfo;
import org.nix.book.model.BorrowRecords;
import org.nix.book.model.UserInfoModel;
import org.nix.book.model.UserModel;
import org.nix.book.service.BookService;
import org.nix.book.service.RecordsService;
import org.nix.book.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.Map;

/**
 * @program: bookmanager
 * @description: 图书controller
 * @author: Tang
 * @create: 2018-06-07 01:41
 **/

@RestController
@RequestMapping(value = "/book")
public class BookController {

    @Autowired
    private BookService bookService;

    @Autowired
    private UserService userService;

    @Autowired
    private RecordsService recordsService;


    /**
     *  图书列表接口
     */
    @GetMapping(value = "/bookList")
    public Map<String,Object> findUserList() throws CloneNotSupportedException, IOException, ClassNotFoundException {

        BaseResultDto bookList = bookService.findBookList();

        return new ResultMap()
                .success("data",bookList)
                .send();
    }

    /**
     * 前台最受欢迎图书列表
     * @return
     * @throws CloneNotSupportedException
     */
    @GetMapping(value = "/simBookList")
    public Map<String,Object> getSimpleBookList() throws CloneNotSupportedException, IOException, ClassNotFoundException {

        BaseResultDto bookList = bookService.getSimpleBookList();

        return new ResultMap()
                .success("data",bookList)
                .send();
    }

    /**
     * 出版时间排序
     * @return
     * @throws CloneNotSupportedException
     */
    @GetMapping(value = "/simBookListOrderByCome")
    public Map<String,Object> getSimpleBookListOderByComingUpTime() throws CloneNotSupportedException, IOException, ClassNotFoundException {

        BaseResultDto bookList = bookService.getSimpleBookListOrderByComingUpTime();

        return new ResultMap()
                .success("data",bookList)
                .send();
    }

    /**
     * 图书详情
     * @param id
     * @return
     * @throws CloneNotSupportedException
     */
    @GetMapping(value = "/bookDetail")
    public Map<String,Object> findBookById(@RequestParam String id) throws CloneNotSupportedException, IOException, ClassNotFoundException {

        BaseResultDto bookList = bookService.findBookById(id);

        return new ResultMap()
                .success("data",bookList)
                .send();
    }

    /**
     * 借书
     * @param id
     * @param userId
     * @return
     * @throws CloneNotSupportedException
     */
    @PostMapping(value = "/lendBook")
    public Map<String,Object> lendBookById(@RequestParam String id,
                                           @RequestParam String userId) throws CloneNotSupportedException{

        //判断该书是否能借出
        if(!bookService.hasLend(id)){
            return new ResultMap()
                    .fail("借出失败")
                    .send();
        }

        //设置书籍状态
        BookInfo bookInfo = bookService.changeBookState(id,0);

        //设置用户的信息
        UserModel userModel = userService.changeUserLendedNum(userId,+1);

        BorrowRecords borrowRecords = new BorrowRecords();
        borrowRecords.setBorrowTime(new Date());
        borrowRecords.setBookInfo(bookInfo);
        borrowRecords.setUserModel(userModel);


        //时间转换
        ZoneId zoneId = ZoneId.systemDefault();
        LocalDateTime localDateTime = LocalDateTime.now();
        localDateTime = localDateTime.minus(30, ChronoUnit.DAYS);//借书时间30天
        ZonedDateTime zdt = localDateTime.atZone(zoneId);
        Date date = Date.from(zdt.toInstant());

        borrowRecords.setShouldTime(date);
        recordsService.addRecord(borrowRecords);


        return new ResultMap().success("借书成功").send();
    }

    /**
     * 还书
     * @param id
     * @return
     * @throws CloneNotSupportedException
     */
    @PostMapping(value = "backBook")
    public Map<String,Object> backBook(@RequestParam String id) throws CloneNotSupportedException{

        BorrowRecords borrowRecords = recordsService.findBorrowRecordsById(id);

        BookInfo bookInfo = borrowRecords.getBookInfo();

        //设置书籍状态
        bookInfo.setState(1);

        //设置用户的信息
        UserModel userModel = borrowRecords.getUserModel();
        UserInfoModel userInfoModel = userModel.getUserInfoModel();

        Integer lendnum = userInfoModel.getLendedNum();
        userInfoModel.setLendedNum(lendnum-1);

        borrowRecords.setReturnTime(new Date());

        recordsService.updateRecord(borrowRecords);

        return new ResultMap().success("还书成功").send();
    }

    /**
     * 删除一本书
     * @param id
     * @return
     * @throws CloneNotSupportedException
     */
    @DeleteMapping(value = "/delBook")
    public Map<String,Object> delBookById(@RequestParam Integer id) throws CloneNotSupportedException{
        bookService.delBookById(id);
        return new ResultMap().success("删除成功").send();
    }

    /**
     * 删除多本书
     * @param ids
     * @return
     * @throws CloneNotSupportedException
     */
    @DeleteMapping(value = "/delBooks")
    public Map<String,Object> delBookById(@RequestParam Integer[] ids) throws CloneNotSupportedException{

        bookService.delBookByIds(ids);
        return new ResultMap().success("删除成功").send();
    }

    /**
     * 修改图书
     * @param bookInfo
     * @return
     * @throws CloneNotSupportedException
     */
    @PostMapping(value = "/updateBook")
    public Map<String,Object> updateBook( @ModelAttribute("BookInfo") BookInfo bookInfo) throws CloneNotSupportedException{
        bookService.updateBook(bookInfo);
        return new ResultMap().success("修改成功").send();
    }

    /**
     * 添加图书
     * @param bookInfo
     * @return
     * @throws CloneNotSupportedException
     */
    @PutMapping(value = "/addBook")
    public Map<String,Object> addBook(@RequestParam String userId,
                                      @ModelAttribute("BookInfo") BookInfo bookInfo) throws CloneNotSupportedException{
        bookService.addBook(userId,bookInfo);
        return new ResultMap().success("增加成功").send();
    }






}
