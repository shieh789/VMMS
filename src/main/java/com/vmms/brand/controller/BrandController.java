package com.vmms.brand.controller;


import com.vmms.brand.domain.Brand;
import com.vmms.brand.response.BrandPageResult;
import com.vmms.brand.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author code haha
 * @since 2021-01-02
 */
@RestController
@RequestMapping("/brand")
public class BrandController {

    @Autowired
    BrandService brandService;

    @RequestMapping("/findBrand")
    public BrandPageResult findBrand(@RequestBody Brand brand){
        return brandService.findBrand(brand);
    }

}
