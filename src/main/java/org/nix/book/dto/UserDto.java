package org.nix.book.dto;

import org.nix.book.model.UserModel;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: bookmanage
 * @description: 用户
 * @author: Tang
 * @create: 2018-06-06 11:19
 **/

public class UserDto extends org.nix.bookservice.dto.base.AbstractResultDto {

    private List<UserModel> userList;

    private UserModel userModel;

    public UserDto(List<UserModel> userList) {
        this.userList = userList;
    }

    public UserDto(UserModel userModel){
        this.userModel = userModel;
    }

    @Override
    public void handler() throws CloneNotSupportedException {
        for (UserModel model:userList) {
            model.setPassword(null);
        }
    }

    public List<UserModel> getUserList() {
        return userList;
    }

    public void setUserList(List<UserModel> userList) {
        this.userList = userList;
    }

    public UserModel getUserModel() {
        return userModel;
    }

    public void setUserModel(UserModel userModel) {
        this.userModel = userModel;
    }
}
