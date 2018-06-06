package org.nix.book.dto.base;

public abstract class AbstractResultDto implements BaseResultDto {

    @Override
    public BaseResultDto result() throws CloneNotSupportedException {
        handler();
        return this;
    }
}
