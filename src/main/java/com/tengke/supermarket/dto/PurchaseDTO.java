package com.tengke.supermarket.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

/**
 * @author cgs
 */
@Data
@AllArgsConstructor
public class PurchaseDTO {

    private Integer purchaseId;
    private String goods;
    private Float price;
    private Integer amount;
    private Date date;
    private String supplier;
    private Integer staffId;


}
