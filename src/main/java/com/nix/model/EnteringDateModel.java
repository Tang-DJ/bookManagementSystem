package com.nix.model;

import java.util.Date;

public class EnteringDateModel {
    //借阅记录ID
    private Integer BorrowID;
    //用户ID
    private Integer UserId;
    //图书ID
    private Integer BookId;
    //书名
    private String BookName;
    //借书时间
    private Date BorrowTime;
    //预还书时间
    private Date ShouldTime;
    //实际还书时间
    private Date ReturnTime;
    // 借阅状态（0借出;1已还）
    private Integer State;

    public Integer getBorrowID() {
        return BorrowID;
    }

    public void setBorrowID(Integer borrowID) {
        BorrowID = borrowID;
    }

    public Integer getUserId() {
        return UserId;
    }

    public void setUserId(Integer userId) {
        UserId = userId;
    }

    public Integer getBookId() {
        return BookId;
    }

    public void setBookId(Integer bookId) {
        BookId = bookId;
    }

    public String getBookName() {
        return BookName;
    }

    public void setBookName(String bookName) {
        BookName = bookName;
    }

    public Date getBorrowTime() {
        return BorrowTime;
    }

    public void setBorrowTime(Date borrowTime) {
        BorrowTime = borrowTime;
    }

    public Date getShouldTime() {
        return ShouldTime;
    }

    public void setShouldTime(Date shouldTime) {
        ShouldTime = shouldTime;
    }

    public Date getReturnTime() {
        return ReturnTime;
    }

    public void setReturnTime(Date returnTime) {
        ReturnTime = returnTime;
    }

    public Integer getState() {
        return State;
    }

    public void setState(Integer state) {
        State = state;
    }
}
