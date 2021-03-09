package com.vmms.brand.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.vmms.brand.domain.Brand;
import com.vmms.brand.dao.BrandMapper;
import com.vmms.brand.response.BrandPageResult;
import com.vmms.brand.service.BrandService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.vmms.common.CommonCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author code haha
 * @since 2021-01-02
 */
@Service
public class BrandServiceImpl extends ServiceImpl<BrandMapper, Brand> implements BrandService {

    @Autowired
    BrandMapper brandMapper;

    @Override
    public BrandPageResult findBrand(Brand brand) {
        List<Brand> brandList = brandMapper.findBrand(brand);
        String jsonString = JSON.toJSONString(brandList);
        List list = JSONObject.parseObject(jsonString, List.class);
        return new BrandPageResult(CommonCode.SUCCESS,list);
    }
}
