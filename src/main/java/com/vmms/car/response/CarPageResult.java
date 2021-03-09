package com.vmms.car.response;

import com.vmms.common.ResponseResult;
import com.vmms.common.ResultCode;
import com.vmms.car.domain.Car;
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
