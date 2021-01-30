package com.example.parts.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.parts.domain.Parts;
import org.springframework.stereotype.Repository;

@Repository
public interface PartsMapper extends BaseMapper<Parts> {

    public void addParts(Parts parts);

    public IPage<Parts> findPartsByCondition(Page<Parts> page, Parts parts);
}
