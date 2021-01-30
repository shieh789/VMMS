package com.example.login.response;

import com.example.common.ResponseResult;
import com.example.common.ResultCode;
import com.example.login.domain.User;
import lombok.Data;

@Data
public class LoginPageResult extends ResponseResult {
    User user;
    public LoginPageResult(ResultCode resultCode, User user) {
        super(resultCode);
        this.user = user;
    }
}
