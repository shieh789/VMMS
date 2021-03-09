package com.vmms.car.service;
import com.vmms.common.QueryResponseResult;
import com.vmms.car.domain.Car;
import com.vmms.car.response.CarPageResult;

public interface CarService {

    public CarPageResult addCar(Car car);

    public QueryResponseResult findAllCar(Integer page,Integer size,Car car);

}
