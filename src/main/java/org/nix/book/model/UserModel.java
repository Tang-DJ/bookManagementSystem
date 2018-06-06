package org.nix.book.model;

import org.nix.book.model.base.BaseModel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "UserModel")
public class UserModel extends BaseModel {

    private String userName;

    private String password;

    private UserInfoModel userInfoModel;

    @Column(name = "userName",nullable = false, unique = true,length = 12)
    public String getUserName() {
        return userName;
    }

    @Column(name = "password",nullable = false, length = 64)
    public String getPassword() {
        return password;
    }

    @OneToOne
    public UserInfoModel getUserInfoModel() {
        return userInfoModel;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUserInfoModel(UserInfoModel userInfoModel) {
        this.userInfoModel = userInfoModel;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        UserModel userModel = (UserModel) o;
        return Objects.equals(userName, userModel.userName) &&
                Objects.equals(password, userModel.password) &&
                Objects.equals(userInfoModel, userModel.userInfoModel);
    }

    @Override
    public int hashCode() {

        return Objects.hash(super.hashCode(), userName, password, userInfoModel);
    }

    @Override
    public String toString() {
        return "UserModel{" +
                "userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", userInfoModel=" + userInfoModel +
                '}';
    }
}
