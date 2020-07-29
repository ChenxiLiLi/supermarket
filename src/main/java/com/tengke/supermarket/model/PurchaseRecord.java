package com.tengke.supermarket.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;
/**
 * @author 彤老板
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
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
    private Date purchaseDate;
    /**
     * 商品编号
     */
    private Integer goodsId;
    /**
     * 进货单价
     */
    private Float purchasePrice;
    /**
     * 进货数量
     */
    private Integer pAmount;

    public PurchaseRecord(Integer supplierId, Integer staffId, Date purchaseDate, Integer goodsId, Float purchasePrice, Integer pAmount) {
        this.supplierId = supplierId;
        this.staffId = staffId;
        this.purchaseDate = purchaseDate;
        this.goodsId = goodsId;
        this.purchasePrice = purchasePrice;
        this.pAmount = pAmount;
    }
}
