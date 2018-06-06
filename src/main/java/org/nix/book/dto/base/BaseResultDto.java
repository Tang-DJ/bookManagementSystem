package org.nix.book.dto.base;

public interface BaseResultDto {

    /**
     * 返回结果
     * @return 返回前台需要的结果
     */
    BaseResultDto result() throws CloneNotSupportedException;

    /**
     * 处理数据
     */
    void handler() throws CloneNotSupportedException;

}
