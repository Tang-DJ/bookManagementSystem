package org.nix.book.controller;

import org.nix.book.dto.base.BaseResultDto;
import org.nix.book.service.RecordsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
    public Map<String,Object> findRecordsListByUserName(@RequestParam("userName")String userName) throws CloneNotSupportedException {

        BaseResultDto recordsList = recordsService.findRecordsListByUserName(userName);

        return new ResultMap()
                .success("data",recordsList)
                .send();
    }


}
