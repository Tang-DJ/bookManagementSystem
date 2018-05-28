package com.nix.model;

import java.sql.Time;
import java.util.Date;

public class BookInfoModel {
    //图书ID
    private Integer BookId;
    //图书名称
    private String BookName;
    //作者
    private String Author;
    //译者
    private String Translator;
    //价格
    private String Price;
    //ISBN编码
    private String ISBNCode;
    //出版日期
    private Date ComeUpTime;
    //出版社
    private String PublishCompany;
    //图书状态（0借出;1在库）
    private Integer State;
    //入库者
    private String EnteringMen;
    //入库日期
    private Date EnteringDate;

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

    public String getAuthor() {
        return Author;
    }

    public void setAuthor(String author) {
        Author = author;
    }

    public String getTranslator() {
        return Translator;
    }

    public void setTranslator(String translator) {
        Translator = translator;
    }

    public String getPrice() {
        return Price;
    }

    public void setPrice(String price) {
        Price = price;
    }

    public String getISBNCode() {
        return ISBNCode;
    }

    public void setISBNCode(String ISBNCode) {
        this.ISBNCode = ISBNCode;
    }

    public Date getComeUpTime() {
        return ComeUpTime;
    }

    public void setComeUpTime(Date comeUpTime) {
        ComeUpTime = comeUpTime;
    }

    public String getPublishCompany() {
        return PublishCompany;
    }

    public void setPublishCompany(String publishCompany) {
        PublishCompany = publishCompany;
    }

    public Integer getState() {
        return State;
    }

    public void setState(Integer state) {
        State = state;
    }

    public String getEnteringMen() {
        return EnteringMen;
    }

    public void setEnteringMen(String enteringMen) {
        EnteringMen = enteringMen;
    }

    public Date getEnteringDate() {
        return EnteringDate;
    }

    public void setEnteringDate(Date enteringDate) {
        EnteringDate = enteringDate;
    }
}




