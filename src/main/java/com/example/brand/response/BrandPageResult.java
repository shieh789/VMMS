package com.example.brand.response;

import com.example.brand.domain.Brand;
import com.example.common.ResponseResult;
import com.example.common.ResultCode;
import lombok.Data;

import java.util.List;

@Data
public class BrandPageResult extends ResponseResult {
    List<Brand> brandList;
    public BrandPageResult(ResultCode resultCode, List<Brand> brandList) {
        super(resultCode);
        this.brandList = brandList;
    }
}
