package org.nix.book.dto;

import org.nix.book.dto.base.AbstractResultDto;
import org.nix.book.model.UserModel;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: bookmanage
 * @description: 用户
 * @author: Tang
 * @create: 2018-06-06 11:19
 **/

public class UserDto extends AbstractResultDto {

    private List<UserModel> userList;

    public UserDto(List<UserModel> userList) {
        this.userList = userList;
    }

    @Override
    public void handler() throws CloneNotSupportedException {
        for (UserModel model:userList) {
            model.setPassword(null);
            model.setUserInfoModel(null);
        }
    }

    public List<UserModel> getUserList() {
        return userList;
    }

    public void setUserList(List<UserModel> userList) {
        this.userList = userList;
    }
}
