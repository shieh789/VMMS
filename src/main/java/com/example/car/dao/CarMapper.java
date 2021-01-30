package com.example.car.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.car.domain.Car;
import org.springframework.stereotype.Repository;

@Repository
public interface CarMapper extends BaseMapper<Car> {

    public void addCar(Car car);

    public IPage<Car> findAllCar(Page<Car> page, Car car);

    //public void updateCar(Car car);

    //public Car findCarByPlateNumber(String plateNumber);

}
