package org.nix.book.controller;

import org.nix.book.dto.base.BaseResultDto;
import org.nix.book.service.RecordsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.Map;

/**
 * @program: bookmanager
 * @description: 借阅记录controller
 * @author: Tang
 * @create: 2018-06-07 01:41
 **/

@RestController
@RequestMapping(value = "/records")
public class RecordsController {

    @Autowired
    private RecordsService recordsService;

    /**
     *  借阅记录接口
     */
    @GetMapping(value = "/recordsList")
    public Map<String,Object> findRecordsList() throws CloneNotSupportedException, IOException, ClassNotFoundException {

        BaseResultDto recordsList = recordsService.findRecordsList();

        return new ResultMap()
                .success("data",recordsList)
                .send();
    }


    /**
     * 根据用户id获取借阅记录
     * @return
     * @throws CloneNotSupportedException
     */
    @GetMapping(value = "/userRecords")
    public Map<String,Object> findBorrowRecordsByUserId(@RequestParam String id) throws CloneNotSupportedException, IOException, ClassNotFoundException {

        BaseResultDto recordsList = recordsService.findBorrowRecordsByUserId(id);

        return new ResultMap()
                .success("data",recordsList)
                .send();
    }
}
