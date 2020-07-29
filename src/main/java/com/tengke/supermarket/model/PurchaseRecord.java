package com.tengke.supermarket.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;
/**
 * @author 彤老板
 */
@Data
public class PurchaseRecord {
    /**
     * 进货记录编号
     */
    private Integer purchaseId;
    /**
     * 供应商编号
     */
    private Integer supplierId;
    /**
     * 员工编号
     */
    private Integer staffId;
    /**
     * 进货日期
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date purchaseDate;
    /**
     * 商品编号
     */
    private Integer goodsId;
    /**
     * 进货单价
     */
    private Float price;
    /**
     * 进货数量
     */
    private Integer amount;


}
