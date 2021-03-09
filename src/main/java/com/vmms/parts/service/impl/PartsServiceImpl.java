package com.vmms.parts.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.vmms.common.CommonCode;
import com.vmms.common.QueryResponseResult;
import com.vmms.common.QueryResult;
import com.vmms.parts.dao.PartsMapper;
import com.vmms.parts.domain.Parts;
import com.vmms.parts.response.PartsPageResult;
import com.vmms.parts.service.PartsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PartsServiceImpl implements PartsService {

    @Autowired
    public PartsMapper partsMapper;

    @Override
    public PartsPageResult addParts(Parts parts) {
        partsMapper.insert(parts);
        return new PartsPageResult(CommonCode.SUCCESS,null);
    }


    @Override
    public QueryResponseResult findPartsByCondition(Integer currentPage, Integer pageSize, Parts parts) {
        QueryWrapper<Parts> queryWrapper =new QueryWrapper<>();
        if(!StringUtils.isBlank(parts.getId())){
            queryWrapper.eq("id",parts.getId());
        }
        if(!StringUtils.isBlank(parts.getBrandName())){
            queryWrapper.eq("brand_name",parts.getBrandName());
        }
        if(!StringUtils.isBlank(parts.getPartsName())){
            queryWrapper.eq("parts_name",parts.getPartsName());
        }
        if(!StringUtils.isBlank(parts.getPartsColor())){
            queryWrapper.eq("parts_color",parts.getPartsColor());
        }
        IPage<Parts> page =new Page<Parts>(currentPage,pageSize);
        IPage<Parts> carIPage = partsMapper.selectPage(page, queryWrapper);
        List<Parts> records = carIPage.getRecords();
        long total = carIPage.getTotal();
        QueryResult<Parts> carQueryResult=new QueryResult<Parts>();
        carQueryResult.setList(records);
        carQueryResult.setTotal(total);
        return new QueryResponseResult(CommonCode.SUCCESS,carQueryResult);
    }
}
