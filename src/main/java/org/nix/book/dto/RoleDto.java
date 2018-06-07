package org.nix.book.dto;

import org.nix.book.dto.base.AbstractResultDto;
import org.nix.book.model.RoleModel;

import java.util.List;

/**
 * @program: bookmanager
 * @description:
 * @author: Tang
 * @create: 2018-06-07 01:36
 **/

public class RoleDto extends AbstractResultDto {


    private List<RoleModel> roleModels;
    private RoleModel roleModel;

    public RoleDto(List<RoleModel> roleModels) {
        this.roleModels = roleModels;
    }
    public RoleDto(RoleModel roleModels) {
        this.roleModel = roleModel;
    }

    @Override
    public void handler() throws CloneNotSupportedException {

    }

    public List<RoleModel> getRoleModels() {
        return roleModels;
    }

    public RoleModel getRoleModel() {
        return roleModel;
    }

    public void setRoleModels(List<RoleModel> roleModels) {
        this.roleModels = roleModels;
    }

    public void setRoleModel(RoleModel roleModell) {
        this.roleModel = roleModel;
    }
}
