package com.vmms.login.response;

import com.vmms.common.ResultCode;
import lombok.ToString;

@ToString
public enum LoginCode implements ResultCode {
    LOGIN_ERROR_FAILSEPASSEORD(false,100001,"用户名不存在或密码错误！"),
    LOGIN_ERROR_FAILSEVALIDCODE(false,100002,"验证码错误！");

    //操作代码
    boolean success;
    //操作代码
    int code;
    //提示信息
    String message;
    private LoginCode(boolean success, int code, String message){
        this.success = success;
        this.code = code;
        this.message = message;
    }

    @Override
    public boolean success() {
        return success;
    }

    @Override
    public int code() {
        return code;
    }

    @Override
    public String message() {
        return message;
    }
}
