package org.nix.book.service;

import org.nix.book.dao.repositories.RoleReposition;
import org.nix.book.dto.RoleDto;
import org.nix.book.dto.UserDto;
import org.nix.book.dto.base.BaseResultDto;
import org.nix.book.model.RoleModel;
import org.nix.book.model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: bookmanager
 * @description: 角色
 * @author: Tang
 * @create: 2018-06-07 01:23
 **/

@Service
public class RoleService {

    @Autowired
    private RoleReposition roleReposition;

    /**
     * 角色列表
     * @return
     * @throws CloneNotSupportedException
     */
    public BaseResultDto findRoleList() throws CloneNotSupportedException{
        List<RoleModel> roleModels = roleReposition.findRoleList();

        if (roleModels.size()>0){
            return new RoleDto(roleModels).result();
        }
        return null;
    }

    /**
     * 根据roleid获得实体
     * @param id
     * @return
     * @throws CloneNotSupportedException
     */
    public RoleModel findRoleById(String id) throws CloneNotSupportedException{
        RoleModel roleModel = roleReposition.findRoleById(id);
        return roleModel;

    }


}
