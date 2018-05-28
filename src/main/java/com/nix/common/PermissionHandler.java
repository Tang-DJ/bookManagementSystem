package com.nix.common;
import java.lang.reflect.Method;


public interface PermissionHandler<R extends Object,M extends Object> {
    /**
     * 判断是否能够执行目的权限
     * @param roleInterface 持有的权限
     * @param method 目的权限
     * @return 持有权限是否能够操作目的权限
     * */
    boolean isHavePermission(R roleInterface, M method);
}
