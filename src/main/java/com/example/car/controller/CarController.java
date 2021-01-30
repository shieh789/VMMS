package com.example.car.controller;


import com.example.common.QueryResponseResult;
import com.example.car.domain.Car;
import com.example.car.response.CarPageResult;
import com.example.car.service.CarService;
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
