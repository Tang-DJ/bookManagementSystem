package com.nix.model;

/**
 * 图书管理员
 * **/

public class BookAdminModel {
    //图书管理员ID
    private Integer AdId;
    //图书管理员名
    private String AdName;
    //用户密码
    private String AdPassword;
    //联系电话
    private String AdPhone;
    //邮箱
    private String AdEmail;

    public Integer getAdId() {
        return AdId;
    }

    public void setAdId(Integer adId) {
        AdId = adId;
    }

    public String getAdName() {
        return AdName;
    }

    public void setAdName(String adName) {
        AdName = adName;
    }

    public String getAdPassword() {
        return AdPassword;
    }

    public void setAdPassword(String adPassword) {
        AdPassword = adPassword;
    }

    public String getAdPhone() {
        return AdPhone;
    }

    public void setAdPhone(String adPhone) {
        AdPhone = adPhone;
    }

    public String getAdEmail() {
        return AdEmail;
    }

    public void setAdEmail(String adEmail) {
        AdEmail = adEmail;
    }
}
