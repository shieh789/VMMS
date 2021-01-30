package com.example.brand.controller;


import com.example.brand.domain.Brand;
import com.example.brand.response.BrandPageResult;
import com.example.brand.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
