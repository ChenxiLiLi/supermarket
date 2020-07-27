package com.tengke.supermarket.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.NonNull;
/**
 * @author  cgs
 * @Description 销售项
 * @date 2020年7月26日20:37:22
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SellItem {
    //销售编号
    private Integer sellId;

    //商品编号
    private Integer gdsId;

    //商品单价
    private Float price;

    //商品数量
    private Integer amount;

}
