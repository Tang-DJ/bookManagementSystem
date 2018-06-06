package org.nix.book.controller;

import java.util.HashMap;
import java.util.Map;

/**
 * Create by zhangpe0312@qq.com on 2018/6/4.
 */
public class ResultMap {

    private final static String SUCCESS_CODE = "0";
    private final static String SUCCESS_MSG = "操作成功";
    private final static String FAIL_CODE = "-1";
    private final static String FAIL_MSG = "操作失败";

    private final static String code = "code";

    private final static String msg = "msg";

    private Map<String,Object> result = new HashMap<>();

    public ResultMap success(){
        result.put(code,SUCCESS_CODE);
        result.put(msg,SUCCESS_MSG);
        return this;
    }

    public ResultMap success(String message){
        result.put(code,SUCCESS_CODE);
        result.put(msg,message);
        return this;
    }

    public ResultMap success(String key,Object dto){
        success();
        result.put(key,dto);
        return this;
    }

    public ResultMap fail(){
        result.put(code,FAIL_CODE);
        result.put(msg,FAIL_MSG);
        return this;
    }

    public ResultMap fail(String errorMsg){
        result.put(code,FAIL_CODE);
        result.put(msg,errorMsg);
        return this;
    }

    public Map<String,Object> send(){
        return result;
    }

}
