package com.vmms.login.response;

import com.vmms.common.ResponseResult;
import com.vmms.common.ResultCode;
import lombok.Data;
import org.springframework.security.core.userdetails.UserDetails;

@Data
public class LoginPageResult extends ResponseResult {

    UserDetails userDetails;

    public LoginPageResult(ResultCode resultCode, UserDetails userDetails) {
        super(resultCode);
        this.userDetails = userDetails;
    }
}
