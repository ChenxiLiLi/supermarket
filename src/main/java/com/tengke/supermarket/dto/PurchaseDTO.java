package com.tengke.supermarket.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
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
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date date;
    private String supplier;
    private Integer staffId;


}
