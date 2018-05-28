package com.nix.model;

/**
 * 用户
 * **/

public class UserModel {
    //用户ID(学号)
    private Integer UserId;
    //用户名
    private String UserName;
    //用户密码
    private String Password;

    public Integer getUserId() {
        return UserId;
    }

    public void setUserId(Integer userId) {
        UserId = userId;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }
}
