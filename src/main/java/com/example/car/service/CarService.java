package com.example.car.service;
import com.example.common.QueryResponseResult;
import com.example.car.domain.Car;
import com.example.car.response.CarPageResult;

public interface CarService {

    public CarPageResult addCar(Car car);

    public QueryResponseResult findAllCar(Integer page,Integer size,Car car);

}
