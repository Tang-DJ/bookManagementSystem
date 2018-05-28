package com.nix.model;

/**
 * 用户信息
 */

public class UserInfoModel{

    //用户ID(学号) 自增
    private Integer UserId;
    //院系
    private String Departments;
    //专业
    private String Major;
    //电话
    private String Phone;
    //邮箱
    private String Email;
    //可借最大数量
    private Integer Max;
    // 可借期限
    private Integer Time;
    // 在借数量
    private Integer LendedNum;

    public Integer getUserId() {
        return UserId;
    }

    public void setUserId(Integer userId) {
        UserId = userId;
    }

    public String getDepartments() {
        return Departments;
    }

    public void setDepartments(String departments) {
        Departments = departments;
    }

    public String getMajor() {
        return Major;
    }

    public void setMajor(String major) {
        Major = major;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public Integer getMax() {
        return Max;
    }

    public void setMax(Integer max) {
        Max = max;
    }

    public Integer getTime() {
        return Time;
    }

    public void setTime(Integer time) {
        Time = time;
    }

    public Integer getLendedNum() {
        return LendedNum;
    }

    public void setLendedNum(Integer lendedNum) {
        LendedNum = lendedNum;
    }

    @Override
    public String toString() {
        return "UserInfoModel{" +
                "UserId=" + UserId +
                ", Departments='" + Departments + '\'' +
                ", Major='" + Major + '\'' +
                ", Phone='" + Phone + '\'' +
                ", Email='" + Email + '\'' +
                ", Max=" + Max +
                ", Time=" + Time +
                ", LendedNum=" + LendedNum +
                '}';
    }
}
