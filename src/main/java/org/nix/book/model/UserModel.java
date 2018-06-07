package org.nix.book.model;

import org.nix.book.model.base.BaseModel;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "UserModel")
public class UserModel extends BaseModel {

    private String userName;

    private String password;

    private UserInfoModel userInfoModel;

    private RoleModel roleModel;

    @Column(name = "userName",nullable = false, unique = true,length = 12)
    public String getUserName() {
        return userName;
    }

    @Column(name = "password",nullable = false, length = 64)
    public String getPassword() {
        return password;
    }

    @OneToOne(targetEntity = UserInfoModel.class,cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "userInfoModel",nullable = false)
    public UserInfoModel getUserInfoModel() {
        return userInfoModel;
    }

    @ManyToOne(targetEntity = RoleModel.class,cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "roleModel",nullable = false)
    public RoleModel getRoleModel() {
        return roleModel;
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

    public void setRoleModel(RoleModel roleModel) {
        this.roleModel = roleModel;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserModel userModel = (UserModel) o;
        return Objects.equals(userName, userModel.userName) &&
                Objects.equals(password, userModel.password) &&
                Objects.equals(userInfoModel, userModel.userInfoModel) &&
                Objects.equals(roleModel, userModel.roleModel);
    }

    @Override
    public int hashCode() {

        return Objects.hash(userName, password, userInfoModel, roleModel);
    }

    @Override
    public String toString() {
        return "UserModel{" +
                "userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", userInfoModel=" + userInfoModel +
                ", roleModel=" + roleModel +
                '}';
    }
}
