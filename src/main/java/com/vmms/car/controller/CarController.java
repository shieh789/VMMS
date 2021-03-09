package com.vmms.car.controller;


import com.vmms.common.QueryResponseResult;
import com.vmms.car.domain.Car;
import com.vmms.car.response.CarPageResult;
import com.vmms.car.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/car")
public class CarController {

    @Autowired
    CarService carService;

    @RequestMapping("/addCar")
    public CarPageResult addCar(@RequestBody Car car){
        CarPageResult carPageResult = carService.addCar(car);
        return carPageResult;
    }

    @GetMapping("/list/{page}/{size}")
    public QueryResponseResult findAllCar(@PathVariable("page") int page,@PathVariable("size") int size,Car car){
        QueryResponseResult carPageResult = carService.findAllCar(page,size,car);
        return carPageResult;
    }

}
