package org.nix.book.model;

import org.hibernate.validator.constraints.Length;
import org.nix.book.model.base.BaseModel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Objects;

/**
 * @program: bookmanage
 * @description: 角色
 * @author: Tang
 * @create: 2018-06-05 18:42
 **/

@Entity
@Table(name = "RoleModel")
public class RoleModel extends BaseModel {
    //角色名称
    private String roleName;
    //角色描述
    private String roleInfo;
    //键值
    private Integer value;

    @Column(name = "roleName",nullable = false)
    @Length(min = 1,max = 255)
    public String getRoleName() {
        return roleName;
    }

    @Column(name = "roleInfo",nullable = false)
    @Length(min = 1,max = 255)
    public String getRoleInfo() {
        return roleInfo;
    }

    @Column(name = "value", nullable = false)
    public Integer getValue() {
        return value;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public void setRoleInfo(String roleInfo) {
        this.roleInfo = roleInfo;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RoleModel roleModel = (RoleModel) o;
        return Objects.equals(roleName, roleModel.roleName) &&
                Objects.equals(roleInfo, roleModel.roleInfo) &&
                Objects.equals(value, roleModel.value);
    }

    @Override
    public int hashCode() {

        return Objects.hash(roleName, roleInfo, value);
    }

    @Override
    public String toString() {
        return "RoleModel{" +
                "roleName='" + roleName + '\'' +
                ", roleInfo='" + roleInfo + '\'' +
                ", value=" + value +
                '}';
    }
}
