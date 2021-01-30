package com.example.car.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

@Data
@TableName(value = "car_info")
public class Car implements Serializable {
    public String id;
    @TableField("platenumber")
    public String plateNumber;
    @TableField("motorcycletype")
    public String motorcycleType;
    @TableField("customername")
    public String customerName;
    @TableField("customerphone")
    public String customerPhone;
}
