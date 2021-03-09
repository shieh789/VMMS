package com.vmms.brand.service;

import com.vmms.brand.domain.Brand;
import com.baomidou.mybatisplus.extension.service.IService;
import com.vmms.brand.response.BrandPageResult;

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
