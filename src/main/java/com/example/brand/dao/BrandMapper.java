package com.example.brand.dao;

import com.example.brand.domain.Brand;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BrandMapper extends BaseMapper<Brand> {

    public List<Brand> findBrand(Brand brand);
}
