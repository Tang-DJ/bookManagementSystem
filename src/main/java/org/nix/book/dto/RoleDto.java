package org.nix.book.dto;

import org.nix.book.dto.base.AbstractResultDto;
import org.nix.book.model.BorrowRecords;
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
    private RoleModel roleModell;

    public RoleDto(List<RoleModel> roleModels) {
        this.roleModels = roleModels;
    }
    public RoleDto(RoleModel roleModels) {
        this.roleModell = roleModell;
    }

    @Override
    public void handler() throws CloneNotSupportedException {
        for (RoleModel model:roleModels) {
            model.setValue(null);
        }
    }

    public List<RoleModel> getRoleModels() {
        return roleModels;
    }

    public RoleModel getRoleModell() {
        return roleModell;
    }

    public void setRoleModels(List<RoleModel> roleModels) {
        this.roleModels = roleModels;
    }

    public void setRoleModell(RoleModel roleModell) {
        this.roleModell = roleModell;
    }
}
