package com.nix.common.cache;

import com.nix.model.UserModel;

import javax.servlet.http.HttpSession;

/**
 * 登录用户缓存
 */
public final class UserCathe {

    public final static String USER_SESSION_KEY = "UserId";
    //本地线程临时存储
    private final static ThreadLocal<HttpSession> local = new ThreadLocal<>();

    //获取当前登录的用户
    public static UserModel currentUser() {
        return (UserModel) local.get().getAttribute(USER_SESSION_KEY);
    }
    //将存储了用户的session存到ThreadLocal里
    public static void putUser(HttpSession session) {
        local.set(session);
    }
    public static HttpSession getSession() {
        return local.get();
    }
}
