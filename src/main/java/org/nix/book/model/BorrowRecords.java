package org.nix.book.model;

import org.nix.book.model.base.BaseModel;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

/**
 * @program: bookmanage
 * @description: 借阅记录model
 * @author: Tang
 * @create: 2018-06-05 16:51
 **/
@Entity
@Table(name = "BorrowRecords")
public class BorrowRecords extends BaseModel {

    //用户
    private UserModel userModel;

    //图书
    private BookInfo bookInfo;

    //借书时间
    private Date borrowTime;

    //预还书时间
    private Date shouldTime;

    //实际还书时间
    private Date returnTime;

    @ManyToOne(targetEntity = UserModel.class,cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "userModel",nullable = false)
    public UserModel getUserModel() {
        return userModel;
    }

    @OneToOne
    public BookInfo getBookInfo() {
        return bookInfo;
    }

    @Column(name = "borrowTime", length = 19, nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    public Date getBorrowTime() {
        return borrowTime;
    }

    @Column(name = "shouldTime", length = 19, nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    public Date getShouldTime() {
        return shouldTime;
    }

    @Column(name = "returnTime", length = 19, nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    public Date getReturnTime() {
        return returnTime;
    }

    public void setUserModel(UserModel userModel) {
        this.userModel = userModel;
    }

    public void setBookInfo(BookInfo bookInfo) {
        this.bookInfo = bookInfo;
    }

    public void setBorrowTime(Date borrowTime) {
        this.borrowTime = borrowTime;
    }

    public void setShouldTime(Date shouldTime) {
        this.shouldTime = shouldTime;
    }

    public void setReturnTime(Date returnTime) {
        this.returnTime = returnTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BorrowRecords that = (BorrowRecords) o;
        return Objects.equals(userModel, that.userModel) &&
                Objects.equals(bookInfo, that.bookInfo) &&
                Objects.equals(borrowTime, that.borrowTime) &&
                Objects.equals(shouldTime, that.shouldTime) &&
                Objects.equals(returnTime, that.returnTime);
    }

    @Override
    public int hashCode() {

        return Objects.hash(userModel, bookInfo, borrowTime, shouldTime, returnTime);
    }

    @Override
    public String toString() {
        return "BorrowRecords{" +
                "userModel=" + userModel +
                ", bookInfo=" + bookInfo +
                ", borrowTime=" + borrowTime +
                ", shouldTime=" + shouldTime +
                ", returnTime=" + returnTime +
                '}';
    }
}
