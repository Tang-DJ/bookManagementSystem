package org.nix.book.model;

import org.hibernate.validator.constraints.Length;
import org.nix.book.CloneTools;
import org.nix.book.model.base.BaseModel;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.IOException;
import java.util.Date;
import java.util.Objects;

/**
 * @program: bookmanage
 * @description: 图书信息model
 * @author: Tang
 * @create: 2018-06-05 16:40
 **/
@Entity
@Table(name = "BookInfo")
public class BookInfo extends BaseModel {

    /**
     * 图书名称
     */
    private String bookName;
    /**
     * 作者
     */
    private String author;
    /**
     * 译者
     */
    private String translator;
    /**
     * 书籍价格
     */
    private float price;
    /**
     * 书籍ISBN码
     */
    private String ISBNCode;
    /**
     * 书籍出版日期
     */
    private Date comeUpTime;
    /**
     * 书籍出版社
     */
    private String publishCompany;
    /**
     * 图书状态
     * （0借出;1在库）
     */
    private Integer state;
    /**
     * 入库者
     */
    private UserModel enteringMen;
    /**
     * 入库时间
     */
    private Date enteringDate;

    @Column(name = "bookName", nullable = false, length = 20)
    @Length(min = 1, max = 20)
    public String getBookName() {
        return bookName;
    }

    @Column(name = "author", nullable = false, length = 20)
    @Length(min = 1, max = 20)
    public String getAuthor() {
        return author;
    }

    @Column(name = "translator", nullable = false, length = 20)
    @Length(min = 1, max = 20)
    public String getTranslator() {
        return translator;
    }

    @Column(name = "price", nullable = false)
    public float getPrice() {
        return price;
    }

    @Column(name = "ISBNCode", nullable = false, unique = true, length = 14)
    @Length(min = 1, max = 14)
    public String getISBNCode() {
        return ISBNCode;
    }

    @Column(name = "comeUpTime", length = 19, nullable = false)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @Temporal(TemporalType.TIMESTAMP)
    public Date getComeUpTime() {
        return comeUpTime;
    }

    @Column(name = "publishCompany", nullable = false, length = 50)
    @Length(min = 1, max = 50)
    public String getPublishCompany() {
        return publishCompany;
    }

    @Column(name = "state", nullable = false)
    public Integer getState() {
        return state;
    }

    @ManyToOne(targetEntity = UserModel.class,cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "enteringMen",nullable = false)
    public UserModel getEnteringMen() {
        return enteringMen;
    }

    @Column(name = "enteringDate", length = 19, nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    public Date getEnteringDate() {
        return enteringDate;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setTranslator(String translator) {
        this.translator = translator;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public void setISBNCode(String ISBNCode) {
        this.ISBNCode = ISBNCode;
    }

    public void setComeUpTime(Date comeUpTime) {
        this.comeUpTime = comeUpTime;
    }

    public void setPublishCompany(String publishCompany) {
        this.publishCompany = publishCompany;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public void setEnteringMen(UserModel enteringMen) {
        this.enteringMen = enteringMen;
    }

    public void setEnteringDate(Date enteringDate) {
        this.enteringDate = enteringDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BookInfo bookInfo = (BookInfo) o;
        return Float.compare(bookInfo.price, price) == 0 &&
                Objects.equals(bookName, bookInfo.bookName) &&
                Objects.equals(author, bookInfo.author) &&
                Objects.equals(translator, bookInfo.translator) &&
                Objects.equals(ISBNCode, bookInfo.ISBNCode) &&
                Objects.equals(comeUpTime, bookInfo.comeUpTime) &&
                Objects.equals(publishCompany, bookInfo.publishCompany) &&
                Objects.equals(state, bookInfo.state) &&
                Objects.equals(enteringMen, bookInfo.enteringMen) &&
                Objects.equals(enteringDate, bookInfo.enteringDate);
    }

    @Override
    public int hashCode() {

        return Objects.hash(bookName, author, translator, price, ISBNCode, comeUpTime, publishCompany, state, enteringMen, enteringDate);
    }

    @Override
    public String toString() {
        return "BookInfo{" +
                "bookName='" + bookName + '\'' +
                ", author='" + author + '\'' +
                ", translator='" + translator + '\'' +
                ", price=" + price +
                ", ISBNCode='" + ISBNCode + '\'' +
                ", comeUpTime=" + comeUpTime +
                ", publishCompany='" + publishCompany + '\'' +
                ", state=" + state +
                ", enteringMen=" + enteringMen +
                ", enteringDate=" + enteringDate +
                '}';
    }


}
