package org.nix.bookservice.dto.base;

import org.nix.book.dto.base.BaseResultDto;

import java.io.IOException;

/**
 * Create by zhangpe0312@qq.com on 2018/6/4.
 */
public abstract class AbstractResultDto implements BaseResultDto{

    @Override
    public BaseResultDto result() throws CloneNotSupportedException, IOException, ClassNotFoundException {
        handler();
        return this;
    }
}
