package com.vmms.parts.controller;

import com.vmms.common.QueryResponseResult;
import com.vmms.parts.domain.Parts;
import com.vmms.parts.response.PartsPageResult;
import com.vmms.parts.service.PartsService;
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
