package com.example.car.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.common.CommonCode;
import com.example.common.QueryResponseResult;
import com.example.common.QueryResult;
import com.example.car.dao.CarMapper;
import com.example.car.domain.Car;
import com.example.car.response.CarPageResult;
import com.example.car.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarServiceImpl implements CarService {

    @Autowired
    public CarMapper carMapper;

    @Override
    public CarPageResult addCar(Car car) {
        carMapper.addCar(car);

        return new CarPageResult(CommonCode.SUCCESS,null);
    }

    @Override
    public QueryResponseResult findAllCar(Integer currentPage,Integer pageSize,Car car) {
        QueryWrapper<Car> queryWrapper =new QueryWrapper<>();
        if(!StringUtils.isBlank(car.plateNumber)){
            queryWrapper.eq("platenumber",car.plateNumber);
        }
        if(!StringUtils.isBlank(car.customerName)){
            queryWrapper.eq("customername",car.customerName);
        }
        if(!StringUtils.isBlank(car.motorcycleType)){
            queryWrapper.eq("motorcycletype",car.motorcycleType);
        }
        IPage<Car> page =new Page<>(currentPage,pageSize);
        IPage<Car> carIPage = carMapper.selectPage(page, queryWrapper);
        List<Car> records = carIPage.getRecords();
        long total = carIPage.getTotal();
        QueryResult<Car> carQueryResult=new QueryResult<Car>();
        carQueryResult.setList(records);
        carQueryResult.setTotal(total);
        return new QueryResponseResult(CommonCode.SUCCESS,carQueryResult);
    }
}
