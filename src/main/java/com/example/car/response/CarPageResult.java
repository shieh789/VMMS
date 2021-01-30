package com.example.car.response;

import com.example.common.ResponseResult;
import com.example.common.ResultCode;
import com.example.car.domain.Car;
import lombok.Data;

import java.util.List;

@Data
public class CarPageResult extends ResponseResult {
    Car car;
    List<Car> carList;
    public CarPageResult(ResultCode resultCode, Car car) {
        super(resultCode);
        this.car = car;
    }
}
