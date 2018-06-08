package org.nix.book.dto;

import jdk.nashorn.internal.runtime.Undefined;
import org.nix.book.dto.base.AbstractResultDto;
import org.nix.book.model.BookInfo;
import org.nix.book.model.UserModel;

import java.util.List;

/**
 * @program: bookmanager
 * @description: 简易图书列表
 * @author: Tang
 * @create: 2018-06-08 16:35
 **/

public class SimpleBookDto extends AbstractResultDto {

    private List<BookInfo> bookInfos;

    public SimpleBookDto(List<BookInfo> bookInfos) {
        this.bookInfos = bookInfos;
    }

    @Override
    public void handler() throws CloneNotSupportedException {
        for (BookInfo model:bookInfos) {
            model.setEnteringDate(null);
            model.setEnteringMen(null);
            model.setISBNCode(null);
            model.setState(null);
            model.setTranslator(null);
            model.setPublishCompany(null);
        }
    }

    public List<BookInfo> getBookInfos() {
        return bookInfos;
    }

    public void setBookInfos(List<BookInfo> bookInfos) {
        this.bookInfos = bookInfos;
    }



}
