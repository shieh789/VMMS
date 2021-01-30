package com.example.parts.controller;

import com.example.common.QueryResponseResult;
import com.example.parts.domain.Parts;
import com.example.parts.response.PartsPageResult;
import com.example.parts.service.PartsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/parts")
public class PartsController {

    @Autowired
    PartsService partsService;

    @RequestMapping("/addParts")
    public PartsPageResult addParts(@RequestBody Parts parts){
        PartsPageResult partsPageResult = partsService.addParts(parts);
        return partsPageResult;
    }

    @GetMapping("/list/{page}/{size}")
    public QueryResponseResult findAllCar(@PathVariable("page") int page,@PathVariable("size") int size,Parts parts){
        QueryResponseResult carPageResult = partsService.findPartsByCondition(page,size,parts);
        return carPageResult;
    }
}
