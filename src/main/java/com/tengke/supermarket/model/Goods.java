package com.tengke.supermarket.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.NonNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Goods  {               //商品信息表
    @NonNull
    private Integer gdsId;          // 商品编号
    private String gdsName;         // 商品名称
    private String brand;           //品牌
    private String model;           //型号
    private String category;        //种类
    @NonNull
    private Float price;            //销售单价
    private Integer amount;         //库存数量
    private Character gdsState;     //状态（1正常/0停产）
    private String unit;            //单位

}
