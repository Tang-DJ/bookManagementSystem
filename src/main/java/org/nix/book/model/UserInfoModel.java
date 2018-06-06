package org.nix.book.model;

import org.hibernate.validator.constraints.Length;
import org.nix.book.model.base.BaseModel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "UserInfoModel")
public class UserInfoModel extends BaseModel {

    private String departments;
    private String major;
    private String phone;
    private String email;
    private Integer max;
    private Date time;
    private Integer lendedNum;

    @Column(name = "departments",nullable = false)
    @Length(min = 1,max = 255,message = "院系格式错误")
    public String getDepartments() {
        return departments;
    }

    @Column(name = "major",nullable = false)
    @Length(min = 1,max = 255,message = "专业格式错误")
    public String getMajor() {
        return major;
    }

    @Column(name = "email")
    @Length(min = 1,max = 255,message = "邮箱格式错误")
    public String getEmail() {
        return email;
    }

    @Column(name = "max",nullable = false)
    @Length(min = 1,max = 255,message = "可借最大数量格式错误")
    public Integer getMax() {
        return max;
    }

    @Column(name = "time",nullable = false)
    @Length(min = 1,max = 255,message = "可借期限格式错误")
    public Date getTime() {
        return time;
    }

    @Column(name = "lendedNum",nullable = false)
    @Length(min = 1,max = 255,message = "在借数量格式错误")
    public Integer getLendedNum() {
        return lendedNum;
    }

    @Column(name = "phone",unique = true,length = 12)
    @Length(min = 8,max = 12,message = "电话号码格式错误")
    public String getPhone() {
        return phone;
    }

    public void setDepartments(String departments) {
        this.departments = departments;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setMax(Integer max) {
        this.max = max;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public void setLendedNum(Integer lendedNum) {
        this.lendedNum = lendedNum;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        UserInfoModel that = (UserInfoModel) o;
        return Objects.equals(departments, that.departments) &&
                Objects.equals(major, that.major) &&
                Objects.equals(phone, that.phone) &&
                Objects.equals(email, that.email) &&
                Objects.equals(max, that.max) &&
                Objects.equals(time, that.time) &&
                Objects.equals(lendedNum, that.lendedNum);
    }

    @Override
    public int hashCode() {

        return Objects.hash(super.hashCode(), departments, major, phone, email, max, time, lendedNum);
    }

    @Override
    public String toString() {
        return "UserInfoModel{" +
                "departments='" + departments + '\'' +
                ", major='" + major + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", max=" + max +
                ", time=" + time +
                ", lendedNum=" + lendedNum +
                '}';
    }
}
