package com.vmms.parts.response;

import com.vmms.common.ResponseResult;
import com.vmms.common.ResultCode;
import com.vmms.parts.domain.Parts;
import lombok.Data;

import java.util.List;

@Data
public class PartsPageResult extends ResponseResult {
    Parts parts;
    List<Parts> carList;
    public PartsPageResult(ResultCode resultCode, Parts parts) {
        super(resultCode);
        this.parts = parts;
    }
}
