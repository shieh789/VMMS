package com.vmms.brand.response;

import com.vmms.brand.domain.Brand;
import com.vmms.common.ResponseResult;
import com.vmms.common.ResultCode;
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
