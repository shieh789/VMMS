package com.example.parts.response;

import com.example.common.ResponseResult;
import com.example.common.ResultCode;
import com.example.parts.domain.Parts;
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
