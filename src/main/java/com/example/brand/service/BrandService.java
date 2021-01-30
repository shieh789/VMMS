package com.example.brand.service;

import com.example.brand.domain.Brand;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.brand.response.BrandPageResult;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author code haha
 * @since 2021-01-02
 */
public interface BrandService extends IService<Brand> {
    public BrandPageResult findBrand(Brand brand);
}
