package org.nix.book.controller;

import org.nix.book.dto.base.BaseResultDto;
import org.nix.book.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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


    /**
     *  图书列表接口
     */
    @GetMapping(value = "/bookList")
    public Map<String,Object> findUserList() throws CloneNotSupportedException {

        BaseResultDto bookList = bookService.findBookList();

        return new ResultMap()
                .success("data",bookList)
                .send();
    }

    /**
     * 前台简易图书列表
     * @return
     * @throws CloneNotSupportedException
     */
    @GetMapping(value = "/simBookList")
    public Map<String,Object> getSimpleBookList() throws CloneNotSupportedException{

        BaseResultDto bookList = bookService.getSimpleBookList();

        return new ResultMap()
                .success("data",bookList)
                .send();
    }


}
