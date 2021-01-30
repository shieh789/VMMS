package com.example.parts.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
@TableName(value = "car_parts")
public class Parts implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id",type = IdType.ASSIGN_UUID)
    public String id;
    @TableField("parts_name")
    public String partsName;
    @TableField("parts_color")
    public String partsColor;
    @TableField("brand_name")
    public String brandName;
    @TableField("cost_price")
    public BigDecimal costPrice;
    @TableField("parts_price")
    public BigDecimal partsPrice;
}
