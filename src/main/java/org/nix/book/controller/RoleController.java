package org.nix.book.controller;

import org.nix.book.dto.base.BaseResultDto;
import org.nix.book.service.RoleService;
import org.nix.book.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @program: bookmanager
 * @description: 角色controller
 * @author: Tang
 * @create: 2018-06-07 01:38
 **/

@RestController
@RequestMapping(value = "/role")
public class RoleController {

    @Autowired
    private RoleService roleService;

    /**
     *  角色列表接口
     */
    @GetMapping(value = "/roleList")
    public Map<String,Object> findUserListByUserName() throws CloneNotSupportedException {

        BaseResultDto roleList = roleService.findRoleList();

        return new ResultMap()
                .success("data",roleList)
                .send();
    }


}
