package org.nix.book.dto;

import org.nix.book.dto.base.AbstractResultDto;
import org.nix.book.model.BookInfo;
import org.nix.book.model.UserModel;

import java.util.List;

/**
 * @program: bookmanager
 * @description:
 * @author: Tang
 * @create: 2018-06-07 01:35
 **/

public class BookDto extends AbstractResultDto {

    private List<BookInfo> bookInfos;

    public BookDto(List<BookInfo> bookInfos) {
        this.bookInfos = bookInfos;
    }

    @Override
    public void handler() throws CloneNotSupportedException {
        for (BookInfo model:bookInfos) {
            model.setAuthor(null);
        }
    }

    public List<BookInfo> getBookInfos() {
        return bookInfos;
    }

    public void setBookInfos(List<BookInfo> bookInfos) {
        this.bookInfos = bookInfos;
    }
}
