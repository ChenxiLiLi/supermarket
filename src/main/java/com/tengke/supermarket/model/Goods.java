package com.tengke.supermarket.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.NonNull;

/**
 * @author  cgs
 * @Description 商品类
 * @date 2020年7月26日20:39:18
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Goods  {
    // 商品编号
    private Integer gdsId;
    // 商品名称
    private String gdsName;
    //品牌
    private String brand;
    //型号
    private String model;
    //种类
    private String category;
    //销售单价
    @NonNull
    private Float price;
    //库存数量
    private Integer amount;
    //状态（1正常/0停产）
    private Character gdsStatus;
    //单位
    private String unit;
}
